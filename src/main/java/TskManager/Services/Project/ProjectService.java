
package TskManager.Services.Project;

import TskManager.Tables.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;
    
    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
    
    public String addProject(Project project){
        projectRepository.save(project);
        return "there u go";
    }
}
