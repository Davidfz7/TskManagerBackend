
package TskManager.Controllers;

import TskManager.Services.Todo.TodoService;
import TskManager.Tables.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Esta anotacion indica que esto es un controlador en Django seria algo como la clase VIEWS
@RestController
//Esto indica que esta clase es una URL la cual
//Va a contener contenido para mostrar en pantalla EN DJANGO SERIA ALGO COMO LA CLASE URL
@RequestMapping(path = "/api") 
@CrossOrigin
public class TodoController {
    
    private final TodoService todoService;
    
    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    
    @GetMapping("todos")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }
}
