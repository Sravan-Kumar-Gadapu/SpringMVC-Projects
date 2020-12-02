package com.example.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;

@Component
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate; 
	
	
	@Transactional
	public int save(User user)
	{
		int id=(Integer) this.hibernateTemplate.save(user);
		return id;
	}
	
	public User validateForm(String email, String password)
	{
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<User> findByCriteria =(List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
			return findByCriteria.get(0);
			else
				return null;
	}

}
