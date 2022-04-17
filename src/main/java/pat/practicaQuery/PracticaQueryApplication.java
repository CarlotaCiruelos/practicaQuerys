package pat.practicaQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;
import pat.practicaQuery.entity.User;
import pat.practicaQuery.repository.UserRepository;

import java.util.Optional;

@SpringBootApplication
public class PracticaQueryApplication implements CommandLineRunner {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PracticaQueryApplication.class);

	@Autowired
	private UserRepository repository;
	@Autowired
	private Database dbSeeder;

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "jdbcintro");
		SpringApplication.run(PracticaQueryApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		LOGGER.info("@@ Inserting Data....");
		dbSeeder.insertData();

		LOGGER.info("@@ findAll() call...");
		repository.findAll()
				.forEach(user -> LOGGER.info(user.toString()));

		LOGGER.info("@@ findById() call...");
		Optional<User> optionalUser = repository.findById(1L);
		optionalUser.ifPresent(user -> LOGGER.info(user.toString()));

		LOGGER.info("@@ save() call...");
		User newUser = new User("Franz", "Kafka");
		User result = repository.save(newUser);
		LOGGER.info(result.toString());

		LOGGER.info("@@ delete");
		optionalUser.ifPresent(user -> repository.delete(user));

		LOGGER.info("@@ findAll() call...");
		repository.findAll()
				.forEach(user -> LOGGER.info(user.toString()));

		LOGGER.info("@@ findByFirstName() call...");
		repository.findByFirstName("Franz")
				.forEach(user -> LOGGER.info(user.toString()));
		LOGGER.info("@@ updateByFirstName() call...");

		repository.updateByFirstName(2L, "Date Inferno");
		repository.findAll()
				.forEach(person -> LOGGER.info(person.toString()));

	}
}

