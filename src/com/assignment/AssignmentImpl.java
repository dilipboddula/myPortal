package com.assignment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.users.SapientUsers;

public class AssignmentImpl implements AssignmentDAO{

	SessionFactory factory;
	@Override
	public boolean addAssignment(Assignment a) {
        factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        boolean result=false;
       // Assignment e=(Assignment)session.get(Assignment.class,assignmentId);
		try {
			
				t=session.beginTransaction();
				session.save(a);
				t.commit();	
                result=true;
			
			
		} catch (HibernateException h) {
			
			h.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
		return result;
	}

	@Override
	public ArrayList<Assignment> getAllAssignments(int scopeId) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
       // Query q=session.createQuery("from Assignment");
        SQLQuery query = session.createSQLQuery("SELECT * FROM Assignment WHERE scopeId = ?");
		query.addEntity(Assignment.class);
		query.setParameter(0, scopeId);
		ArrayList<Assignment> alist=(ArrayList<Assignment>) query.list();
		session.close();
		factory.close();
		return alist;
	}

	@Override
	public int submitAssigment(int scopeId,int assignmentId, int member1Id, int member2Id,
			String projectName, String fileName, String projectDescription,String url) {
		
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        Integer id = 0;
       // Assignment e=(Assignment)session.get(Assignment.class,assignmentId);
			
				try {
					t=session.beginTransaction();
					SubmitAssignment a=new SubmitAssignment();
					SapientUsers e=(SapientUsers)session.get(SapientUsers.class,member1Id);
					a.setMember1Id(member1Id);
					a.setMember1Name(e.getUserName());
					System.out.println(e.getUserName());
					a.setMember2Id(member2Id);
					if(member2Id==0){
						a.setMember2Name("None");
					
					}else{
						SapientUsers f=(SapientUsers)session.get(SapientUsers.class,member2Id);
						System.out.println(f.getUserName());
						a.setMember2Name(f.getUserName());
					}
					
					a.setAssignmentId(assignmentId);
					a.setFileName(fileName);
					a.setProjectDescription(projectDescription);
					a.setProjectName(projectName);
					a.setUrl(url);
					a.setScopeId(scopeId);
					Date date=Calendar.getInstance().getTime();
					System.out.println(date);
					a.setDate(date);
					id=(Integer) session.save(a);
					t.commit();			

					
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}finally{
					session.close();
					factory.close();
				}
				return id;
		
	}

	@Override
	public ArrayList<SubmitAssignment> getAllSubmittedAssignments(int scopeId) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
       // Query q=session.createQuery("from SubmitAssignment order by assignmentId");
        SQLQuery query = session.createSQLQuery("SELECT * FROM submitAssignment WHERE scopeId = ?");
      		query.addEntity(SubmitAssignment.class);
      		query.setParameter(0, scopeId);
        ArrayList<SubmitAssignment> alist=(ArrayList<SubmitAssignment>) query.list();
		session.close();
		factory.close();
		return alist;
	}


}
