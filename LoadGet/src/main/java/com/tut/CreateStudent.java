package com.tut;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
	
	public static void main(String[] args) {
		// 1. Create a Student object
		Student st = new Student();
		st.setId(10);
		st.setCity("Mangalore");
		st.setName("Ganesha");
		// 2. Create a Hibernate SessionFactory
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 3. Open a Hibernate Session
		Session openSession = sessionFactory.openSession();
		// 4. Begin a transaction
		Transaction transaction = openSession.beginTransaction();
		// 5. Use the Session to save the Student object
		openSession.save(st);
		// 6. Commit the transaction to persist changes to the database
		transaction.commit();
		// 7. Close the Session and SessionFactory
		openSession.close();
		sessionFactory.close();
		
		
		
	}

}
