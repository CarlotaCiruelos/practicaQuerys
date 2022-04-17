package pat.practicaQuery.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pat.practicaQuery.entity.Account;
import pat.practicaQuery.entity.User;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    //INNER-JOIN
    @Query("SELECT * FROM ACCOUNT INNER JOIN USER ON USER.USER_NAME=ACCOUNT.USER_NAME")
    List<Account> getAccountWithUser();

    //LEFT JOIN
    @Query("SELECT ACCOUNT.AMOUNT FROM ACCOUNT LEFT JOIN USER ON USER.USER_NAME=ACCOUNT.USER_NAME")
    List<Account> getAllAccount();



}