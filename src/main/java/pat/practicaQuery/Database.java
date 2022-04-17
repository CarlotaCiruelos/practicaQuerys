package pat.practicaQuery;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component
public class Database {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Database.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertData() {
        LOGGER.info("> Inserting data...");

        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('Antonio', '1')");
        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('Claudia', '2')");
        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('Teresa', '3')");
        jdbcTemplate.execute("INSERT INTO User(USER_NAME,PASSWORD) VALUES('Juan', '4')");
        jdbcTemplate.execute("INSERT INTO Account(USER_NAME,AMOUNT) VALUES('Antonio', '30')");
        jdbcTemplate.execute("INSERT INTO Account(USER_NAME,AMOUNT) VALUES('Antonio', '10')");
        jdbcTemplate.execute("INSERT INTO Account(USER_NAME,AMOUNT) VALUES('Teresa', '50')");
    }

}
