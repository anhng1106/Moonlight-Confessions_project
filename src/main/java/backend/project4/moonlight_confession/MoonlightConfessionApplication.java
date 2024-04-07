package backend.project4.moonlight_confession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoonlightConfessionApplication {
	private static final Logger log = LoggerFactory.getLogger(MoonlightConfessionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoonlightConfessionApplication.class, args);
	}



}
