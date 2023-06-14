package vaccinationManagementSystem.example.vaccinationManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaccinationManagementSystem.example.vaccinationManager.Model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    public Doctor findByEmailId(String emailId);
}
