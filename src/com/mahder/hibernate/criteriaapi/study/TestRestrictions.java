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
public class TestRestrictions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		//criteria.add(Restrictions.like("fullName", "N%"))//Restrictions.add is like SQL AND connector
				//.add(Restrictions.between("id", 1, 10));
		//to do an OR....
		criteria.add(Restrictions.or(Restrictions.between("id", 1, 3), Restrictions.between("id", 6, 10)));
		
		List<User> userList = (List<User>) criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(User u : userList){
			System.out.println("The full name is : " + u.getFullName());
		}
	}

}//end class
