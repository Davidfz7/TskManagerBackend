
package TskManager.services.project;

import TskManager.services.project.ProjectRepository;
import TskManager.tables.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    
    public void saveProject(Project project){
       projectRepository.save(project);
       
    }
    
}
