package com.awards;

import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.test.HibernateUtil;
import com.users.SapientUsers;;



public class AwardsImpl implements AwardsDAO{

	SessionFactory factory;
	@Override
	public boolean addNominees(int nominatorId,int[] nomineeArray, String[] reasonArray,int scopeId,String impactArray[]) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		String[] coreValues=new String[]{"Creativity","Leadership","Openness","ClientFocusedDelivery","Relationship","People Growth"};
		String nominatorName;
		String[] nomineeNames=new String[6];
		SapientUsers e=(SapientUsers)session.get(SapientUsers.class,nominatorId);
		nominatorName=e.getUserName();
		for(int i=0;i<6;i++)
		{
			e=(SapientUsers)session.get(SapientUsers.class,nomineeArray[i]);
			nomineeNames[i]=e.getUserName();
		}
		Transaction t;
		try {
			for(int i=0;i<6;i++){
				t=session.beginTransaction();
				Awards a=new Awards();
				a.setNominatorId(nominatorId);
				a.setNomineeId(nomineeArray[i]);
				a.setNominatorName(nominatorName);
				a.setNomineeName(nomineeNames[i]);
				a.setCoreValueId(i);
				a.setReason(reasonArray[i]);
				a.setCoreValue(coreValues[i]);
				a.setScopeId(scopeId);
				a.setImpact(impactArray[i]);
				session.save(a);
				t.commit();			
			}
			return true;
		} catch (HibernateException h) {
			// TODO Auto-generated catch block
			h.printStackTrace();
			return false;
		}finally{
			session.close();
			factory.close();
			
		}
	}
	@Override
	public ArrayList<Awards> getAllNominees(int scopeId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT* FROM awards WHERE scopeId = ?");
		query.addEntity(Awards.class);
		query.setParameter(0, scopeId);
		ArrayList<Awards> alist=(ArrayList) query.list();
		session.close();
		factory.close();
		return alist;
	}
	@Override
	public List getTop5Creativity(int scopeId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SQLQuery query = session.createSQLQuery("select nomineename,count(nomineename) as votes,nomineeId from awards where corevalueid=0 AND scopeId = ? group by nomineename order by votes desc;");
		//query.addEntity(Awards.class);
		query.setParameter(0, scopeId);
		//SQLQuery q = session.createSQLQuery("");
		//Query q=session.createQuery("select e.nomineeName,e.corevalue,COUNT(*) from Awards e where e.corevalueid=0 group by e.nomineename order by COUNT(*) desc");
		//ArrayList<Awards> alist=(ArrayList) q.list();
		List result=query.list();
		int size=result.size();
		int i=0,others=0;
		DefaultPieDataset pieDataset = new DefaultPieDataset();
				for (Object obj : result) {
				    Object[] fields = (Object[]) obj;
				    System.out.println("Name = " + fields[0] + " (count = " + fields[1] + ")"+"id="+fields[2]);
				    int a=((BigInteger) fields[1]).intValue();
				    if (i<5){
				    pieDataset.setValue((String)fields[0], new Integer(a));
				    }
				    else {others=others+a;}
				    i++;
				}
				if (others!=0){
					System.out.println("in others");
					pieDataset.setValue("others", new Integer(others));
				}
				
		JFreeChart chart = ChartFactory.createPieChart
		("creativity", // Title
		pieDataset, // Dataset
		true, // Show legend
		true, // Use tooltips
		false // Configure chart to generate URLs?
		);
	    PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSimpleLabels(true);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
		try {
		ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\dboddu\\Hibernate\\TrainingPortal\\WebContent\\graphs\\creativity"+scopeId+".jpg"), chart, 500, 300);
		System.out.println("Chart Created");
		} catch (Exception e) {
			e.printStackTrace();
		System.out.println("Problem occurred creating chart.");
		}finally{
			session.close();
			factory.close();
			
		}
		return  result;
	}
	@Override
	public ArrayList<Awards> getComments(int nomineeId, int coreValueId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query=null;
		if (nomineeId!=0){
		query = session.createSQLQuery("SELECT* FROM awards WHERE nomineeId = ? AND coreValueId=?");
		query.addEntity(Awards.class);
		query.setParameter(0, nomineeId);
		query.setParameter(1, coreValueId);
		/*Query quer=session.createQuery(queryStr);
		quer.setParameter(0,nomineeId);
		quer.setParameter(1,coreValueId);*/
		}else{
			query = session.createSQLQuery("SELECT * FROM awards WHERE coreValueId=? ");
			query.addEntity(Awards.class);
			query.setParameter(0, coreValueId);
		}
		ArrayList<Awards> alist=(ArrayList<Awards>) query.list();
		for (Awards v : alist) {
			System.out.println(v.getNominatorName());
			
		}
		session.close();
		factory.close();
		return alist;
	}
	@Override
	public boolean checkAwardsDuplicate(int nominatorId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT* FROM awards WHERE nominatorId = ?");
		query.addEntity(Awards.class);
		query.setParameter(0, nominatorId);
		
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
	public ArrayList<Integer> getAwardStats(int scopeId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT count(distinct(nomineeId)) FROM awards WHERE scopeId = ?");
		query.setParameter(0, scopeId);
		List v= query.list();
		ArrayList<Integer> alFinal=new ArrayList<Integer>();
	/*
			alFinal.add(v);
			System.out.println("Total distinct "+v);
		}
		for (int i=0;i<6;i++){
			query = session.createSQLQuery("SELECT count(distinct(nomineeId)) FROM awards WHERE scopeId = ? and coreValueId=?");
			query.setParameter(0, scopeId);
			query.setParameter(1, i);
			al=(ArrayList<Integer>) query.list();
			for (Integer v : al) {
				alFinal.add(v);
				System.out.println("Core Value distinct "+i+"  "+v);
			}
		}*/
		return alFinal;
	}
	

}
