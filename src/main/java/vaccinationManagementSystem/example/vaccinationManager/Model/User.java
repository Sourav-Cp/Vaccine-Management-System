package vaccinationManagementSystem.example.vaccinationManager.Model;

import jakarta.persistence.*;
import lombok.Data;
import vaccinationManagementSystem.example.vaccinationManager.Enums.Gender;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String name;

    private int age;

    @Column(unique = true)
    private String emailId;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String mobileNo;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Dose dose;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment>appointmentList = new ArrayList<>();
}
