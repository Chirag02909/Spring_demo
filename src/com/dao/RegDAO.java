package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Regvo;

@Repository
public class RegDAO {
	
	@Autowired
	private SessionFactory sf;
	
	public void save(Regvo v)
	{
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(v);
		tr.commit();
		s.close();
	}
}
