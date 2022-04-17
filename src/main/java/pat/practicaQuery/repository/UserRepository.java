package pat.practicaQuery.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pat.practicaQuery.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByFirstName(String firstName);

    @Modifying
    @Query("UPDATE user SET first_name = :first_name WHERE id = :id")
    boolean updateByFirstName(@Param("id") Long id, @Param("first_name") String name);
}
