/**
 * 
 */
package com.mahder.hibernate.criteriaapi.study;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * @author alemayehu
 *
 */
public class TestCriteriaAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("fullName", "Name9"));//where user_name = 'User 9'
		
		List<User> userList = (List<User>) criteria.list();
		session.getTransaction().commit();
		session.close();
		
		for(User user : userList){
			System.out.println("User full name is : "+user.getFullName());
		}
	}

}//end class
