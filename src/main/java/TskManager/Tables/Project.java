
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
@Table(name = "Projects")
public class Project implements Serializable{
    private static final long serialVersionUID = 1L;
    
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProjectID")
    private Long projectid;
    private String projectname; 
    private String status;
    private String description;
    private Long UserID;
    
    public Project() {
    }

    public Project(String projectname, String status, String description, Long UserID) {
        this.projectname = projectname;
        this.status = status;
        this.description = description;
        this.UserID = UserID;
    }
}
