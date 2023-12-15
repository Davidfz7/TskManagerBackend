
package TskManager.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_todos")
public class Todo {  
    @Id
    @GeneratedValue()
    @Column(name="TodoID")
    private Long todoid;
    @Column(length = 25, nullable = false)
    private String status; 
    @Column(length = 200, nullable = false)
    private String description;
    private int UserID;

}
