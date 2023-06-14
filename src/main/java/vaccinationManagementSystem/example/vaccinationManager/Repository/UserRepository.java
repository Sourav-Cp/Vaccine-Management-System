package vaccinationManagementSystem.example.vaccinationManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaccinationManagementSystem.example.vaccinationManager.Model.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     public User findByEmailId(String emailId);
}
