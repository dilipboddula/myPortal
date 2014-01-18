package com.users;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.admin.Admin;
import com.awards.Awards;
import com.scope.NamesBean;
import com.test.HibernateUtil;

public class SapientUsersImpl implements SapientUsersDAO {

	SessionFactory factory;
	@Override
	public int addUser(SapientUsers s) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        int id=0;
       // Assignment e=(Assignment)session.get(Assignment.class,assignmentId);
        SQLQuery query=null;		
		query = session.createSQLQuery("SELECT * FROM SapientUsers WHERE userName=? ");
		query.addEntity(SapientUsers.class);		
		query.setParameter(0, s.getUserName());
		ArrayList<SapientUsers> alist=(ArrayList<SapientUsers>) query.list();
		if (alist.size()>=1){
			id=-1;
			return id;
		}
		else{
		try {
			
				t=session.beginTransaction();
				id=(Integer) session.save(s);
				t.commit();	       
			
			
		} catch (HibernateException h) {
			
			h.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
		}
		return id;

	}
	@Override
	public ArrayList<SapientUsers> userLogin(String email) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
		SQLQuery query=null;		
			query = session.createSQLQuery("SELECT * FROM SapientUsers WHERE userSapientEmail=? ");
			query.addEntity(SapientUsers.class);
			query.setParameter(0, email);
		
		ArrayList<SapientUsers> alist=(ArrayList<SapientUsers>) query.list();
		for (SapientUsers v : alist) {
			System.out.println(v);
			
		}
		return alist;
		}
	@Override
	public int checkMailIdInNames(String sapientEmail) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        int id=0;
		SQLQuery query=null;		
			query = session.createSQLQuery("SELECT * FROM names WHERE sapientEmail=? ");
			query.addEntity(NamesBean.class);
			query.setParameter(0,sapientEmail);
		
		ArrayList<NamesBean> alist=(ArrayList<NamesBean>) query.list();
		if (alist.size()==0){
			return id;
		}else{
			for (NamesBean v : alist) {
				System.out.println(v);
				id=v.getScopeId();				
			}		
			query = session.createSQLQuery("SELECT * FROM sapientUsers WHERE userSapientEmail=? ");
			query.addEntity(SapientUsers.class);
			query.setParameter(0,sapientEmail);
			ArrayList<NamesBean> blist=(ArrayList<NamesBean>) query.list();
			if (blist.size()>=1){
				id=-1;
				return id;
			}
		}
		return id;
	}
	@Override
	public ArrayList<SapientUsers> getAllUsers(int scopeId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT* FROM SapientUsers WHERE scopeId = ? order by userName");
		query.addEntity(SapientUsers.class);
		query.setParameter(0, scopeId);
		ArrayList<SapientUsers> al=(ArrayList<SapientUsers>) query.list();		
		return al;
	}
	@Override
	public int changePassword(int id, int scopeId, String newPassword,String curPassword) {
		int result=0;
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		Transaction t;
		t=session.beginTransaction();
		SQLQuery query=null;	
		try {
			query = session.createSQLQuery("Update SapientUsers set userPassword=? where userId=? and scopeId=? and userPassword=?");
			query.addEntity(SapientUsers.class);
			query.setParameter(0, newPassword);
			query.setParameter(1, id);
			query.setParameter(2, scopeId);
			query.setParameter(3, curPassword);
			int rows=query.executeUpdate();
			t.commit();
			System.out.println("no. of rows updated "+rows);
			if (rows==0){
				result=-1;
			}else result=1;		
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	}



