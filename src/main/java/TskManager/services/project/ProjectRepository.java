
package TskManager.services.project;

import TskManager.tables.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer>{
    
}
