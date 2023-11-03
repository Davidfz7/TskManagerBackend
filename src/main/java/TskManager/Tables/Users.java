package TskManager.Tables;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="Users")
public class Users implements Serializable {
    
    private static final long serialVersionUTD= 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id; 
    private String first_name;
    private String last_name;
    private String birthday;
    private String password;
    
    public Users() {
    }

    public Users(String first_name, String last_name, String birthday, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthday = birthday;
        this.password = password;
    }

    
    
    
}
