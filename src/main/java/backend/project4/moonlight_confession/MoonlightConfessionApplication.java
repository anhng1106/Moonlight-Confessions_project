package backend.project4.moonlight_confession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

import backend.project4.moonlight_confession.domain.AppUser;
import backend.project4.moonlight_confession.domain.AppUserRepository;
import backend.project4.moonlight_confession.domain.Relationship;
import backend.project4.moonlight_confession.domain.Recipient;
import backend.project4.moonlight_confession.domain.RecipientRepository;
import backend.project4.moonlight_confession.domain.RelationshipRepository;

@SpringBootApplication
public class MoonlightConfessionApplication {
	private static final Logger log = LoggerFactory.getLogger(MoonlightConfessionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoonlightConfessionApplication.class, args);
	}

	@Bean
	public CommandLineRunner recipientDemo(RecipientRepository recirepository, RelationshipRepository relarepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("save a couple of recipient");

			// List<String> relationshipTypes = Arrays.asList
			// (
   			//  "Friendship", "Family", "Lover", "Colleagues", "Strangers", "Anonymous", "Self"
			//  );

			// for (String type : relationshipTypes) {
   			// 	Relationship relationship = new Relationship(type);
    		// 	relarepository.save(relationship);
			// }

			Relationship relationship1 = new Relationship("Friendship");
			Relationship relationship2 = new Relationship("Family");
			Relationship relationship3 = new Relationship("Lover");
			Relationship relationship4 = new Relationship("Colleagues");
			Relationship relationship5 = new Relationship("Strangers");
			Relationship relationship6 = new Relationship("Anonymous");
			Relationship relationship7 = new Relationship("Self");

			relarepository.save(relationship1);
			relarepository.save(relationship2);
			relarepository.save(relationship3);
			relarepository.save(relationship4);
			relarepository.save(relationship5);
			relarepository.save(relationship6);
			relarepository.save(relationship7);
			
			recirepository.save(new Recipient("Alex", "Johnson", "+1-555-0123", "alex.johnson@example.com", "Hi, I'm so glad to work with you", relationship4));
			recirepository.save(new Recipient("Emily", "Turner", "+1-555-9876", "em.turner@mailservice.com", "I love you sis!", relationship2));
			recirepository.save(new Recipient("David", "Kim", "+1-555-7643", "d.kim@webmail.com", "Sorry for everything I've done!", relationship6));

			log.info("fetch all recipients");
			for (Recipient recipient : recirepository.findAll()) {
				log.info(recipient.toString());
			}

			// Create users with BCrypt encoded password (user/user, admin/admin)
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			urepository.saveAll(Arrays.asList(user1, user2));
	};
}}
