package com.example.demo.omreon.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScUserlogService {
	
	private EntityManager entityManager;

	private ScUserlogRepository userRepository;
	
	@Autowired()
	public ScUserlogService(ScUserlogRepository userRepository) {
		this.userRepository = userRepository;
	}
	public Date min() {
		return userRepository.min();
	}
	public Date max() {
		return userRepository.max();
	}
	@SuppressWarnings("deprecation")
	public int maxDayDiff() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(max());
	    return now.getDate() - cal.get(Calendar.DAY_OF_MONTH);
	}
	@Transactional
	public void updateDay() {
		String sql = "Update sc_sessions set start_time = date_add(start_time , interval :day YEAR)";
		Session session = entityManager.unwrap(Session.class);
		entityManager.createQuery(sql).setParameter("day", maxDayDiff()).executeUpdate();
		
			
	}
}
