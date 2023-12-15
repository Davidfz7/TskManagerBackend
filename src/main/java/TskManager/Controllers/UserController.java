
package TskManager.Controllers;

import TskManager.Services.User.UserLogin;
import TskManager.Services.User.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TskManager.Tables.User;

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
    public List<User> getUser(){
        return userService.getUsers();
    }
    
   @PostMapping("/postbody")
   public String postBody(@RequestBody User user){
         userService.saveUser(user);
       return "New user added";
   }

   @PostMapping("/validate")
   public String loginController(@RequestBody UserLogin userlogin){
       User user = userService.login(userlogin.getUsername(), userlogin.getPassword());
       if(user != null){
          return "success";
       }
       return "notfound";
   }
    
    
    
}
