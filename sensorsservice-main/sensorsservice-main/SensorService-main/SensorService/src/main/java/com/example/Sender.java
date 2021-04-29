package com.example;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Component
public class Sender {
	private static final Logger log = LoggerFactory.getLogger(Sender.class);
	private final RabbitTemplate rabbitTemplate;
	public int hr;
	public int bp;
	public int ol;
	public Sender(final RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
//	
//	  public void schedule() { 
//		  generateBPRandom();
//		  generateHeartRateRandom();
//		  generateOLRandom(); 
//		  }
	@Scheduled(fixedDelay = 3000)
	public int generateBPRandom() {
		 int minbp = 90;
		 int maxbp = 140;
		Random random = new Random();
		Integer patientid = 2;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		/* return random.nextInt(max-min)+min; */
		// Integer blood_pressure = random.nextInt(max-min)+min;
		/*
		 * System.out.print("BP:"); System.out.println( blood_pressure);
		 */
		 bp= random.nextInt(maxbp - minbp) + minbp;
		SensorModel data = new SensorModel(patientid, formatter.format(date), bp,
				null, null);
		rabbitTemplate.convertAndSend(SensorServiceApplication.EXCHANGE_NAME, SensorServiceApplication.Blood_Pressure,
				data);
		log.info("BloodPressure Sent Successfully");
		return 0;
	}

	@Scheduled(fixedDelay = 5000)
	public int generateHeartRateRandom() {
		 int minhr = 60;
		 int maxhr = 100;
		Random random = new Random();
		Integer patientid = 2;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		 hr=random.nextInt(maxhr - minhr) + minhr;
		/*
		 * return (random.nextInt(max-min)+min) ;
		 */
		SensorModel data = new SensorModel(patientid, formatter.format(date), null, null,
				hr);
		rabbitTemplate.convertAndSend(SensorServiceApplication.EXCHANGE_NAME, SensorServiceApplication.Heart_rate, data);
		log.info("HeartRate Sent Successfully");
		return 0;
	}
	@Scheduled(fixedDelay = 8000)
	public int generateOLRandom() {
		 int minol = 75;
		 int maxol = 100;
		Random random = new Random();
		Integer patientid = 2;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		 ol=random.nextInt(maxol - minol) + minol;
		SensorModel data = new SensorModel(patientid, formatter.format(date), null,
				ol, null);
		rabbitTemplate.convertAndSend(SensorServiceApplication.EXCHANGE_NAME, SensorServiceApplication.Blood_oxygen_level,
				data);
		log.info("OxygenLevel Sent Successfully");
		return 0;
	}
}
