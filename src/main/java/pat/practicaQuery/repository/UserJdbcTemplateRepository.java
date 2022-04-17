package pat.practicaQuery.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pat.practicaQuery.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserJdbcTemplateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM USER", Integer.class);
    }


    public int update(User user) {

        return jdbcTemplate.update("UPDATE USER SET PASSWORD = ? WHERE USER_NAME = ?", user.getPassword(), user.getUserName());
    }

    public int delete(User user) {
        return jdbcTemplate.update("DELETE USER WHERE ID = ?", user.getId());
    }






}
