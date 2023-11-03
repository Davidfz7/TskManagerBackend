package TskManager.Services;

import TskManager.Tables.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//It lets spring know that this class is going to be use for code injection
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository studentRepository) {
        this.userRepository = studentRepository;

    }
    // Se hizo un create que verifica que todos los espacios sean validos antes de guardarlos
    public Users createUser(Users user) {
        if (user.getFirst_name() == null || user.getLast_name() == null || user.getBirthday() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        
        return userRepository.save(user);
    }
    
    //Un llamado para ver todos los "Users"
    public List<Users> getUsers() {
        
        return userRepository.findAll();
    }
    
    //Un llamado por medio de "ID" para ver un "User" en especifico
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    //Un llamado por "ID" para editar un "User"
    public Users updateUser(Long id, Users updatedUser) {
        Users existingUser = userRepository.findById(id).orElse(null);

        if (existingUser != null) {
            // Actualiza los campos del usuario existente con los valores del usuario actualizado.
            existingUser.setFirst_name(updatedUser.getFirst_name());
            existingUser.setLast_name(updatedUser.getLast_name());
            existingUser.setBirthday(updatedUser.getBirthday());
            existingUser.setPassword(updatedUser.getPassword());

            return userRepository.save(existingUser);
        }

        return null; // Puedes manejar el caso en el que el usuario no existe.
    }

    //Un llamado por medio de "ID" para eliminar un "User"
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

