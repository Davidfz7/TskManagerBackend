
package TskManager.Services;

import TskManager.Tables.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository 
        extends JpaRepository<Users, Long> {
    
}
