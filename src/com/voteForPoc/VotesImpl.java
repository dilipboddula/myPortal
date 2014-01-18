package com.voteForPoc;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.awards.Awards;
import com.test.HibernateUtil;
import com.users.SapientUsers;

public class VotesImpl implements VotesDAO {

	SessionFactory factory;
	@Override
	public int insertVote(Votes v) {
		int id=0;
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SapientUsers e=(SapientUsers)session.get(SapientUsers.class,v.getNomineeId());
		String nomineeName=e.getUserName();
		v.setNomineeName(nomineeName);
		Transaction t;
		try {
			t=session.beginTransaction();
			id=(Integer) session.save(v);
			t.commit();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return id;
	}

	@Override
	public boolean checkDuplicateVoteEntry(int scopeId, int nominatorId,
			int voteCompId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT* FROM votes WHERE nominatorId = ? and scopeId=? and voteCompId=?");
		query.addEntity(Votes.class);
		query.setParameter(0, nominatorId);
		query.setParameter(1, scopeId);
		query.setParameter(2, 1);
		
	   if ( query.list().size()!=0){
			session.close();
			factory.close();
		   return true;
		}
		else{
			session.close();
			factory.close();
			return false;
		}
	}

	@Override
	public List getAllVotesStastics(int scopeId, int voteCompId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SQLQuery q = session.createSQLQuery("select nomineeName,count(nomineeName) as voteCount,nomineeId from votes where scopeId=? AND voteCompId=? group by nomineeName order by voteCount desc;");
		q.setParameter(0, scopeId);
		q.setParameter(1, voteCompId);
		List result=q.list();
		int size=result.size();
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		for (Object obj : result) {
		    Object[] fields = (Object[]) obj;
		    System.out.println("Name = " + fields[0] + " (count = " + fields[1] + ") nomineeId"+fields[2]);
		    int a=((BigInteger) fields[1]).intValue();		   
		    pieDataset.setValue((String)fields[0], new Integer(a));		    
		}
		
		JFreeChart chart = ChartFactory.createPieChart
				("VoteForPocPic", // Title
						pieDataset, // Dataset
						true, // Show legend
						true, // Use tooltips
						false // Configure chart to generate URLs?
						);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSimpleLabels(true);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
		try {
			ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\dboddu\\Hibernate\\TrainingPortal\\WebContent\\graphs\\VoteForPocPic"+scopeId+".jpg"), chart, 500, 300);
			System.out.println("Char of Votes for Poc of scope "+scopeId+" created");
		} catch (Exception e) {
			System.out.println("Problem occurred creating chart.");
		}
	
		return result;
	}

	@Override
	public ArrayList<Votes> getCommentsStastics(int scopeId, int nomineeId,
			int voteCompId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT* FROM votes WHERE nomineeId = ? and scopeId=? and voteCompId=?");
		query.addEntity(Votes.class);
		query.setParameter(0, nomineeId);
		query.setParameter(1, scopeId);
		query.setParameter(2, voteCompId);
		
		ArrayList<Votes> al=(ArrayList<Votes>)query.list();
		return al;
	}

}
