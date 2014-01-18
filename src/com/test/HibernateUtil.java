package com.test;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionfactory;
	static{
		sessionfactory=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionfactory(){
		return sessionfactory;
	}
}
