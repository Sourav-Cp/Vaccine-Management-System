package vaccinationManagementSystem.example.vaccinationManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import vaccinationManagementSystem.example.vaccinationManager.Model.Dose;
import vaccinationManagementSystem.example.vaccinationManager.Model.User;
import vaccinationManagementSystem.example.vaccinationManager.Repository.DoseRepository;
import vaccinationManagementSystem.example.vaccinationManager.Repository.UserRepository;

@Service
public class DoseService {

    @Autowired
    private DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseId,Integer userId)
    {
        User user = userRepository.findById(userId).get();
        Dose dose = new Dose();

        dose.setDoseId(doseId);
        dose.setUser(user);
        user.setDose(dose);

        userRepository.save(user);

        return "Dose given to user successfully";
    }
}
