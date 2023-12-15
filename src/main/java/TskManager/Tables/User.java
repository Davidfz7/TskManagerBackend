package TskManager.Tables;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate; // Import para manejar fechas
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String username; 
    private String firstname;
    private String lastname;
    private LocalDate birthday; 
    private String password;
    @OneToMany
    @JoinColumn(name="UserID")
    private List<Project> projects;
    
    @OneToMany
    @JoinColumn(name="UserID")
    private List<Todo> todos;
    
    public User() {
    }

    public User(String username, String firstname, String lastname, LocalDate birthday, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.password = password;
    }

}

