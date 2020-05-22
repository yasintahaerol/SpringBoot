package com.example.demo.omreon.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlog")
public class ScUserlogController {
	
	@Autowired
	private ScUserlogRepository userlogRepository;
	
	@Autowired()
	private ScUserlogService userlogService;
	
	
	@GetMapping("/all")
	public List<ScUserlog> findAll() {
		return userlogRepository.findAll();
		}
	@GetMapping("/min")
	public Date min() {
		return userlogRepository.min();
	}
	@GetMapping("/max")
	public Date max() {
		return userlogRepository.max();
	}
	@SuppressWarnings("deprecation")
	@GetMapping("/maxYearDiff")
	public int maxYearDiff() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(userlogRepository.max());
	    return now.getYear() - cal.get(Calendar.YEAR) +1900;
	}
	@SuppressWarnings("deprecation")
	@GetMapping("/maxMonthDiff")
	public int maxMonthDiff() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(userlogRepository.max());
	    return now.getDay() - cal.get(Calendar.MONTH);
	}
	@SuppressWarnings("deprecation")
	@GetMapping("/maxDayDiff")
	public int maxDayDiff() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(userlogRepository.max());
	    return now.getDate() - cal.get(Calendar.DAY_OF_MONTH);
	}
	@GetMapping("/update")
	public void updateDay() {
		userlogService.updateDay();
	}
	
}


