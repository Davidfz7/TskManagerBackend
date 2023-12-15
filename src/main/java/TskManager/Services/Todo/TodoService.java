
package TskManager.Services.Todo;

import TskManager.Tables.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TodoService {
    
    private final TodoRepository todoRepository;
    
    @Autowired
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }
}
