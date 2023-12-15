
package TskManager.Controllers;

//Esta anotacion indica que esto es un controlador en Django seria algo como la clase VIEWS

import TskManager.Services.Project.ProjectService;
import TskManager.Tables.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Esto indica que esta clase es una URL la cual
//Va a contener contenido para mostrar en pantalla EN DJANGO SERIA ALGO COMO LA CLASE URL
@RequestMapping(path = "/api") 
@CrossOrigin
public class ProjectController {
    private final ProjectService projectService;
    
    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    
    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
    
    @PostMapping("/addproject")
    public String addProject(@RequestBody Project project){
        
        return projectService.addProject(project);
    }
}
