package pat.practicaQuery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class User {

    @Id
    private long id;


    private String userName;
    private String password;
    private String email;



    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }




    //private String bankAccount;





    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
    }

}
