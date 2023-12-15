package TskManager.Services.User;

import TskManager.Tables.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//It lets spring know that this class is going to be used for code injection
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public void saveUser(User user){
        userRepository.save(user);
    }

        public User login(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
