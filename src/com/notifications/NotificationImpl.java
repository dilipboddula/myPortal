package com.notifications;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.Admin;
import com.test.HibernateUtil;

public class NotificationImpl implements NotificationDAO{

	SessionFactory factory;
	@Override
	public int notifyPOC(int scopeId, String nomineeName) {
		int id=0;
		factory=HibernateUtil.getSessionfactory();
		Session session=factory.openSession();
		String defaultTemplate=" is nominated as POC with Effect from";
		SQLQuery query=null;		
		query = session.createSQLQuery("SELECT * FROM notification WHERE scopeId=? and defaultTemplate=? ");
		query.addEntity(Notification.class);
		query.setParameter(0, scopeId);
		query.setParameter(1, defaultTemplate);
		ArrayList<Notification> alist=(ArrayList<Notification>) query.list();
		Date date=Calendar.getInstance().getTime();
		System.out.println(date);
		session.close();
		if (alist.size()!=0){			
			session=factory.openSession();
			Transaction t;
			t=session.beginTransaction();
			query = session.createSQLQuery("Update notification set itemName=?,date=? where scopeId=? and defaultTemplate=? ");
			query.addEntity(Notification.class);
			query.setParameter(0, nomineeName);
			query.setParameter(1, date);
			query.setParameter(2, scopeId);
			query.setParameter(3, defaultTemplate);
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
			Notification b=new Notification();
			b.setDate(date);
			b.setDefaultTemplate(defaultTemplate);
			b.setItemName(nomineeName);
			b.setScopeId(scopeId);
			session.save(b);
			t.commit();	
			session.close();
			id=1;
		}
		return id;
	}

}
