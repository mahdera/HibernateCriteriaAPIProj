/**
 * 
 */
package com.mahder.hibernate.criteriaapi.study;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * @author alemayehu
 *
 */
public class TestByExample {
	public static void main(String args[]){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User exampleUser = new User();
		exampleUser.setId(5);
		exampleUser.setFullName("Name%");
		
		Example example = Example.create(exampleUser).enableLike();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(example);
		
		List<User> userList = (List<User>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(User u : userList){
			System.out.println(u.getFullName());
		}
	}
}//end class
