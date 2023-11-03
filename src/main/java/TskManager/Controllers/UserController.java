
package TskManager.Controllers;

import TskManager.Services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TskManager.Tables.Users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.PostPersist;
import java.io.IOException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//Esta anotacion indica que esto es un controlador en Django seria algo como la clase VIEWS
@RestController
//Esto indica que esta clase es una URL la cual
//Va a contener contenido para mostrar en pantalla EN DJANGO SERIA ALGO COMO LA CLASE URL
@RequestMapping(path = "/api") 
@CrossOrigin
public class UserController {
     
     private final UserService userService;
     
     @Autowired //Code Injection in this constructor
     public UserController(UserService userService){
         
         this.userService = userService; 
     
     }
     
    @GetMapping("/users")//Aqui se indica el contenido a mostrar o devolver en esta direccion
    public List<Users> getUser(){
    
        return userService.getUsers();
    }
    
   @PostMapping("/postbody")
   public String postBody(@RequestBody Users user){
       userService.saveUser(user);
       System.out.println("Hola");
       return "Se entrego la data";
   }
    
    
    
}
