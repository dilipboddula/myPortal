package com.admin;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.notifications.NotificationDAO;
import com.notifications.NotificationImpl;
import com.test.HibernateUtil;
import com.users.SapientUsers;

public class AdminImpl implements AdminDAO {
	
	SessionFactory factory;
	@Override
	public int addAdmin(Admin a) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        int id=0;
       // Assignment e=(Assignment)session.get(Assignment.class,assignmentId);
		try {
			
				t=session.beginTransaction();
				id=(Integer) session.save(a);
				t.commit();	
               
			
			
		} catch (HibernateException h) {
			
			h.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
		return id;

	}
	@Override
	public ArrayList<Admin> adminLogin(String adminUserName) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
		SQLQuery query=null;		
			query = session.createSQLQuery("SELECT * FROM admin WHERE adminUserName=? ");
			query.addEntity(Admin.class);
			query.setParameter(0, adminUserName);
		
		ArrayList<Admin> alist=(ArrayList<Admin>) query.list();
		for (Admin v : alist) {
			System.out.println(v);
			
		}
		return alist;

	}
	@Override
	public int addPoc(int scopeId, int nomineeId) {
		int id=0;
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		SapientUsers e=(SapientUsers)session.get(SapientUsers.class,nomineeId);
		String nomineeName=e.getUserName();
		String adminUserName=e.getUserSapientEmail();
		String adminPassword=e.getUserPassword();
		SQLQuery query=null;		
		query = session.createSQLQuery("SELECT * FROM admin WHERE adminRole=? and scopeId=? ");
		query.addEntity(Admin.class);
		query.setParameter(0, "POC");
		query.setParameter(1, scopeId);
		ArrayList<Admin> alist=(ArrayList<Admin>) query.list();
		session.close();
		if (alist.size()!=0){
			session=factory.openSession();
			Transaction t;
			t=session.beginTransaction();
			query = session.createSQLQuery("Update Admin set adminUserName=?,adminPassword=? where adminRole=? and scopeId=? ");
			query.addEntity(Admin.class);
			query.setParameter(0, adminUserName);
			query.setParameter(1, adminPassword);
			query.setParameter(2, "POC");
			query.setParameter(3, scopeId);
			int rows=query.executeUpdate();
			t.commit();
			System.out.println("no. of rows updated "+rows);
			id=1;		
			session.close();
		}
		else{
			session=factory.openSession();
			Transaction t;
			t=session.beginTransaction();
			Admin b=new Admin();
			b.setAdminRole("POC");
			b.setAdminUserName(adminUserName);
			b.setAdminPassword(adminPassword);
			b.setScopeId(scopeId);
			session.save(b);
			t.commit();
			id=1;		
			session.close();
		}
		if (id==1){
			NotificationDAO ref=new NotificationImpl();
			int result=ref.notifyPOC(scopeId, nomineeName);
			if (result==0){
				id=0;
			}
		}
		return id;
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
			query = session.createSQLQuery("Update Admin set adminPassword=? where adminId=? and scopeId=? and adminPassword=?");
			query.addEntity(Admin.class);
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
	@Override
	public ArrayList<Admin> getAllAdmins(int scopeId) {
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		//String queryStr="from Awards u where u.nomineeId like ? and u.corevalueId like ?";
		SQLQuery query = session.createSQLQuery("SELECT* FROM Admin WHERE scopeId = ?");
		query.addEntity(Admin.class);
		query.setParameter(0, scopeId);
		ArrayList<Admin> al=(ArrayList<Admin>) query.list();		
		return al;
	}

}
