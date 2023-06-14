package vaccinationManagementSystem.example.vaccinationManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vaccinationManagementSystem.example.vaccinationManager.Model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
