package pat.practicaQuery.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Account {
    @Id
    private long id;

    private String IBAN;
    private String userName;
    private CardType card;
    private Long amount;

    private Account(Long amount){
        this.amount = amount;
    }

    private Account(String userName, Long amount){
        this.amount = amount;
        this.userName = userName;
    }
}
