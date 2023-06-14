package vaccinationManagementSystem.example.vaccinationManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaccinationManagementSystem.example.vaccinationManager.Model.Dose;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
