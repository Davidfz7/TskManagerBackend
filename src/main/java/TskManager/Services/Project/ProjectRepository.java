
package TskManager.Services.Project;

import TskManager.Tables.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository
        extends JpaRepository<Project, Long>{
    
}
