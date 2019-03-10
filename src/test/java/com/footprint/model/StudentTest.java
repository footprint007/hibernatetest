package com.footprint.model;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
//import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StudentTest {
	
	private Session session;
	private Transaction transaction;
	private SessionFactory sessionFactory = null;
	
	@BeforeEach
	public void init() {
		/*①创建一个SessionFactory工厂类*/
//		Configuration configuration = new Configuration().configure();
//		ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		/*②通过工厂类开启Session对象*/
		session = sessionFactory.openSession();
		/*③开始事务*/
		transaction = session.beginTransaction();
		System.out.println(session);
	}
	
	@AfterEach
	public void destory() {
		/*⑤提交事务*/
		transaction.commit();
		/*⑥关闭Session*/
		session.close();
		/*⑦关闭工厂类*/
		sessionFactory.close();
	}

	@Test
	void test() {
		Student student = new Student();
		student.setUsername("战魂");
		student.setPassword("dasdsada");
		student.setRegDate(new Date().getTime());
		session.save(student);
	}
	
	@Test
	public void doworkTest() {
		session.doWork(new Work() {
			
			@Override
			public void execute(java.sql.Connection connection) throws SQLException {
				System.out.println(connection);		
			}
		});
	}
	
	@Test
	public void hqlTest() {
		String hql = "from Student";
		Query<Student> query = session.createQuery(hql);
		List<Student> list = query.list();
		System.out.println(list);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
