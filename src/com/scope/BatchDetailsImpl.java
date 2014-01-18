package com.scope;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.users.SapientUsers;

public class BatchDetailsImpl implements BatchDetailsDAO {

	SessionFactory factory;
	@Override
	public int addBatch(BatchDetails b) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        int id=0;
       // Assignment e=(Assignment)session.get(Assignment.class,assignmentId);
		try {
			
				t=session.beginTransaction();
				id=(Integer) session.save(b);
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
	public ArrayList<BatchDetails> getSubmittedFiles(int updateId) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
		SQLQuery query=null;		
			query = session.createSQLQuery("SELECT * FROM BatchDetails WHERE updateId=? ");
			query.addEntity(BatchDetails.class);
			query.setParameter(0, updateId);
		
		ArrayList<BatchDetails> alist=(ArrayList<BatchDetails>) query.list();
		for (BatchDetails v : alist) {
			System.out.println(v);
			
		}
		return alist;
		}
	@Override
	public boolean updateFiles(int scopeId) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        boolean result=false;
        BatchDetails e=(BatchDetails)session.get(BatchDetails.class,scopeId);
        
		try {
			 result=read(scopeId, e.getFileName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			session.close();
		}
		if (result){
			Session session2=factory.openSession();
			Transaction t;
			t=session2.beginTransaction();
			
			String hql = "UPDATE BatchDetails set updateId = :a "  + 
		             "WHERE scopeId = :b";
		Query query = session2.createQuery(hql);
		query.setParameter("a", 1);
		query.setParameter("b", scopeId);
		int result2 = query.executeUpdate();
		t.commit();	
		System.out.println("Rows affected: " + result2);
			return true;
		}
		
		return result;
	}
	public boolean read(int scopeId,String fileName) throws IOException  {
		String path="C:/Users/dboddu/Hibernate/TrainingPortal/WebContent/excelfiles/";
		String inputfilename=path.concat(fileName);
		System.out.println("path filename in impl"+inputfilename);
	    File inputWorkbook = new File(inputfilename);
	    Workbook w;
	    String name=null;
	    String sapientEmail=null;
	    factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        Transaction t;
        
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      // Get the first sheet
	      Sheet sheet = w.getSheet(0);
	      // Loop over first 10 column and lines

	      for (int i = 1; i < sheet.getRows(); i++) {
	      for (int j = 0; j < sheet.getColumns(); j++) {
	        
	          Cell cell = sheet.getCell(j, i);
	          CellType type = cell.getType();
	          /*if (type == CellType.LABEL) {
	            System.out.println("I got a label "
	                + cell.getContents());
	          }

	          if (type == CellType.NUMBER) {
	            System.out.println("I got a number "
	                + cell.getContents());
	          }
*/
	          System.out.println("in fn");
	          if (j==0)
	          name=cell.getContents();
	          else
	        	  sapientEmail=cell.getContents();
	          }
	          System.out.println("name in excel is "+name);
	          NamesBean n=new NamesBean();
	          n.setName(name);
	          n.setScopeId(scopeId);
	          n.setSapientEmail(sapientEmail);
	          t=session.beginTransaction();
	          session.save(n);
			  t.commit();
	      }
	    } catch (BiffException e) {
	      e.printStackTrace();
	      return false;
	    }
		return true;
	  }
	@Override
	public ArrayList<BatchDetails> getSubmittedFiles() {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        
		SQLQuery query=null;		
			query = session.createSQLQuery("SELECT * FROM BatchDetails ");
			query.addEntity(BatchDetails.class);
			
		
		ArrayList<BatchDetails> alist=(ArrayList<BatchDetails>) query.list();
		for (BatchDetails v : alist) {
			System.out.println(v);
			
		}
		return alist;
		
	}
	@Override
	public boolean insertFileName(int scopeId, String fileName) {
		factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        boolean result=false;
		Transaction t;
		try {
			t=session.beginTransaction();
			
			String hql = "UPDATE BatchDetails set fileName = :a "  + 
			         "WHERE scopeId = :b";
			Query query = session.createQuery(hql);
			query.setParameter("a", fileName);
			query.setParameter("b", scopeId);
			int result2 = query.executeUpdate();
			t.commit();	
			System.out.println("Rows affected: " + result2);
			result=true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			result=false;
		}
	

	return result;
		
			

	}

}
