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
import pat.practicaQuery.repository.AccountRepository;
import pat.practicaQuery.repository.UserJdbcTemplateRepository;
import pat.practicaQuery.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PracticaQueryApplication implements CommandLineRunner {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PracticaQueryApplication.class);

	@Autowired
	private UserRepository repository;
	@Autowired
	private Database database;
	@Autowired
	private UserJdbcTemplateRepository userJdbcTemplateRepository;
	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "jdbcintro");
		SpringApplication.run(PracticaQueryApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		// INSERT FORMA 1 CON jdbcTemplate
		LOGGER.info("1. INSERT en ambas tablas");
		database.insertData();

		// INSERT FORMA 2 CON save()
		LOGGER.info("1. INSERT en de una única sentencia con save");
		User newUser = new User("Carlota", "123");
		User result = repository.save(newUser);


		//UPDATE FORMA 1 CON @QUERY
		LOGGER.info("2- UPDATE el nombre de usuario de la tabla USER");
		repository.updateByUserName(2L, "Ana");

		// UPDATE FORMA 2 CON JdbcTemplate
		LOGGER.info("2- UPDATE la contraseña de un usuario de la tabla USER");
		User user1 = new User("Antonio","1235");
		userJdbcTemplateRepository.update(user1);

		//SELECT FORMA 1 CON @QUERY
		LOGGER.info("3. SELECT de toda la tabla USER");
		List<User> userList= repository.selectAllUser();
		for(User u : userList){
			LOGGER.info(u.toString());
		}



		//SELECT CON EL MÉTODO FINDBY() y findALL()
		LOGGER.info("3.SELECT DE TODA LA TABLA 1");

		Optional<User> optionalUser = repository.findById(1L);
		optionalUser.ifPresent(user -> LOGGER.info(user.toString()));
		repository.findAll()
				.forEach(user -> LOGGER.info(user.toString()));


		//DELETE FORMA 1 CON DELETE()
		LOGGER.info("4- DELETE FORMA 1 vamos a borrar al usuario que habíamos encontrado antes)");
		optionalUser.ifPresent(user -> repository.delete(user));

		//DELETE CON JdbcTemplate
		LOGGER.info("4- DELETE FORMA 2 vamos a borrar al usuario que habíamos creado antes");
		userJdbcTemplateRepository.delete(user1);

		//COMPROBAMOS los delete
		List<User> userList1= repository.selectAllUser();
		for(User u : userList1){
			LOGGER.info(u.toString());
		}

		//Query 1



	}
}

