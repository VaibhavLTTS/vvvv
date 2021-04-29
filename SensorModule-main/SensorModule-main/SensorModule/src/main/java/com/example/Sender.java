package com.example;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	private final RabbitTemplate rabbitTemplate;

	public Sender(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	/*
	 * public void schedule() { generateBPRandom(); generateHeartRateRandom();
	 * generateOLRandom(); }
	 */
	@Scheduled(fixedDelay = 3000)
	public void generateBPRandom() {

		int minbp = 90;
		int maxbp = 140;
		Random random = new Random();
		Integer patientid = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		/* return random.nextInt(max-min)+min; */
		// Integer blood_pressure = random.nextInt(max-min)+min;
		/*
		 * System.out.print("BP:"); System.out.println( blood_pressure);
		 */
		SensorModel data = new SensorModel(patientid, formatter.format(date), random.nextInt(maxbp - minbp) + minbp,
				null, null);
		rabbitTemplate.convertAndSend(SensorModuleApplication.EXCHANGE_NAME, SensorModuleApplication.Blood_Pressure,
				data);
		log.info("BloodPressure Sent Successfully");
	}

	@Scheduled(fixedDelay = 5000)
	public void generateHeartRateRandom() {

		int minhr = 40;
		int maxhr = 100;
		Random random = new Random();
		Integer patientid = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		/*
		 * return (random.nextInt(max-min)+min) ;
		 */
		SensorModel data = new SensorModel(patientid, formatter.format(date), null, null,
				random.nextInt(maxhr - minhr) + minhr);
		rabbitTemplate.convertAndSend(SensorModuleApplication.EXCHANGE_NAME, SensorModuleApplication.Heart_rate, data);
		log.info("HeartRate Sent Successfully");
	}

	@Scheduled(fixedDelay = 8000)
	public void generateOLRandom() {

		int minol = 60;
		int maxol = 100;
		Random random = new Random();
		Integer patientid = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		SensorModel data = new SensorModel(patientid, formatter.format(date), null,
				random.nextInt(maxol - minol) + minol, null);
		rabbitTemplate.convertAndSend(SensorModuleApplication.EXCHANGE_NAME, SensorModuleApplication.Blood_oxygen_level,
				data);
		log.info("OxygenLevel Sent Successfully");

	}
}
