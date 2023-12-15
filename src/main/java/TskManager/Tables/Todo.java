
package TskManager.Tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Todo")
public class Todo implements Serializable{
    private static final long serialVersionUID = 1L;
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TodoID")
    private Long todoid;
    private String status; 
    private String description;
    private Long UserID;
    
    public Todo() {
    }

    public Todo(String status, String description, Long UserID) {
        this.status = status;
        this.description = description;
        this.UserID = UserID;
    }
}

