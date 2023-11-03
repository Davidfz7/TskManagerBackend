
package TskManager.Controllers;

import TskManager.Services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import TskManager.Tables.Users;
import org.springframework.web.bind.annotation.CrossOrigin;
//Esta anotacion indica que esto es un controlador en Django seria algo como la clase VIEWS
@RestController
//Esto indica que esta clase es una URL la cual
//Va a contener contenido para mostrar en pantalla EN DJANGO SERIA ALGO COMO LA CLASE URL
//NOTA IMPORTANTE
@RequestMapping(path = "/api/users") //NOTA: Cambie de ruta base para una mejor organización
//NOTA IMPORTABTE
@CrossOrigin
public class UserController {
    
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    

    
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        try {
            Users createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } 
        catch (IllegalArgumentException e) {
           //return ResponseEntity.badRequest().body(e.getMessage());
           //Nota; a ser posible, cambiar a un ResponseEntity para un mensaje de error
           return null;
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users user = userService.getUserById(id);
        if (user != null) {
            Users updatedUserResult = userService.updateUser(id, updatedUser);
            if (updatedUserResult != null) {
                return ResponseEntity.ok(updatedUserResult);
            } else {
                //return ResponseEntity.badRequest().body(new ErrorResponse("No se pudo actualizar el usuario"));
                //Nota; a ser posible, cambiar a un ResponseEntity para un mensaje de error
                return null;
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

