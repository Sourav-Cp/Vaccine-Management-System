package vaccinationManagementSystem.example.vaccinationManager.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int centreId;
    private String centreName;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String address;
    private int doseCapacity;

    @OneToMany(mappedBy = "vaccinationCentre",cascade = CascadeType.ALL)
    private List<Doctor> doctorList = new ArrayList<>();
}
