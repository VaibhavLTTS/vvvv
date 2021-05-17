package com.ltts.Patients.Scheduler;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import com.ltts.Patients.Model.*;
import com.ltts.Patients.*;
import com.ltts.Patients.Dao.*;

@Service
public class PatientScheduler {
	
	@Autowired
	private PatientDao PDao;
    
     
	Logger log = LoggerFactory.getLogger(PatientScheduler.class);
    private RabbitTemplate rabbitTemplate;
    public PatientScheduler(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
    
    
    
	//scheduling  in every 3 seconds
    
    @Scheduled(fixedRate = 5000)
	public int generateBPRandom() {
    	

	
int minbp = 90;
int maxbp = 140;
Random random = new Random();


SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date = new Date();
int bp= random.nextInt((maxbp - minbp)+1) + minbp;
		
PatientModel Pmodel=new PatientModel(formatter.format(date),0,0,0);	
	Pmodel.setBlood_Pressure(bp);
	
		PDao.save(Pmodel);
		System.out.println("patient data added " + new Date().toString());
		rabbitTemplate.convertAndSend(PatientApplication.EXCHANGE_NAME, PatientApplication.Blood_Pressure,Pmodel);
		log.info("BloodPressure has been sent");
		return 0;
	}
	
    
	//scheduling  in every 5 seconds
	@Scheduled(fixedRate = 5000)
	public void startSchedulerHR()
	{
		
		
		int minhr = 60;
		int maxhr = 120;
		Random random = new Random();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		int hr= random.nextInt(maxhr - minhr) + minhr;
		PatientModel Pmodel=new PatientModel(formatter.format(date),0,0,0);		
				
			Pmodel.setHeart_Rate(hr);
			
		PDao.save(Pmodel);
		System.out.println("patient data added " + new Date().toString());
		rabbitTemplate.convertAndSend(PatientApplication.EXCHANGE_NAME, PatientApplication.Heart_rate,Pmodel);
		log.info("Heart_rate has been sent");
	}
	
	
	
	//scheduling  in every 5 seconds
	@Scheduled(fixedRate = 5000)
	public void startSchedulerOL()
	{

		
		int minol = 80;
		int maxol = 100;
		Random random = new Random();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		int ol= random.nextInt(maxol - minol) + minol;
		PatientModel Pmodel=new PatientModel(formatter.format(date),0,0,0);			
				
			Pmodel.setOxygen_Level(ol);
		PDao.save(Pmodel);
		System.out.println("patient data added " + new Date().toString());
		rabbitTemplate.convertAndSend(PatientApplication.EXCHANGE_NAME, PatientApplication.Oxygen_level,Pmodel);
		log.info("Oxygen_Level has been sent");
	}
	
	
	
//fetching from database in every 15seconds.
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchScheduler() {
		List<PatientModel> counts = PDao.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " + counts.size());
		log.info("Patient counts : {}", counts);
	}
	}
	


