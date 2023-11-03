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

    public List<Users> getUsers() {

        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
