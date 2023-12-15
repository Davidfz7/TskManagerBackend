
package TskManager.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "_projects")
public class Project {
    
    @Id
    @GeneratedValue()
    private Long projectid;
    @Column(length = 50, nullable = false)
    private String projectname; 
    @Column(length = 25, nullable = false)
    private String status;
    @Column(length = 200, nullable = false)
    private String description;
    private int UserID;
    
}
