package com.mahder.hibernate.criteriaapi.study;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class TestProjectionsAndQueryByExample {
	public static void main(String[] args){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class)
				.setProjection(Projections.property("id"))
				.addOrder(Order.desc("id"));
		
		List<Integer> userList = (List<Integer>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(Integer u : userList){
			System.out.println("User name is : " + u);
		}
	}
}//end class
