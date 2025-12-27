package dev.darsh;

import dev.darsh.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RabbitmqProducerApplication {

	@Autowired
	private RabbitMQProducer  rabbitMQProducer;

	@GetMapping("/send")
	public ResponseEntity<String> send(@RequestParam String message){
		rabbitMQProducer.sendMessage(message);
		return ResponseEntity.status(200).body("Message sent successfully");
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

}
