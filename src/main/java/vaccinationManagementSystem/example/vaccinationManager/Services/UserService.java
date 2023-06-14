package vaccinationManagementSystem.example.vaccinationManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.UpdateEmailDto;
import vaccinationManagementSystem.example.vaccinationManager.Model.Dose;
import vaccinationManagementSystem.example.vaccinationManager.Model.User;
import vaccinationManagementSystem.example.vaccinationManager.Repository.UserRepository;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user)
    {
        user = userRepository.save(user);
        return user;
    }
    public Date getVaccinationDate(Integer userId)
    {
       User user = userRepository.findById(userId).get();
       Dose dose = user.getDose();

       return dose.getVaccinationDate();
    }
    public String updateEmailId(UpdateEmailDto updateEmailDto)
    {
        int userId = updateEmailDto.getUserId();
        User user = userRepository.findById(userId).get();
        user.setEmailId(updateEmailDto.getNewEmail());

        userRepository.save(user);

        return "EmailId successfully updated";
    }
    public User getIdByEmailId(String emailId)
    {
        User user = userRepository.findByEmailId(emailId);
        return user;
    }
}
