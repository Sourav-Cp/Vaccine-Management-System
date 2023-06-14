package vaccinationManagementSystem.example.vaccinationManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaccinationManagementSystem.example.vaccinationManager.Model.VaccinationCentre;
@Repository
public interface CentreRepository extends JpaRepository<VaccinationCentre,Integer> {
}
