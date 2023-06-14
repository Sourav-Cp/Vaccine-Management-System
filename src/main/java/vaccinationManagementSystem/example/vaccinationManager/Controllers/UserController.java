package vaccinationManagementSystem.example.vaccinationManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.UpdateEmailDto;
import vaccinationManagementSystem.example.vaccinationManager.Model.User;
import vaccinationManagementSystem.example.vaccinationManager.Services.UserService;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
       return userService.addUser(user);
    }

    @GetMapping("/get-vacc-date")
    public Date getVaccinationDate(@RequestParam("userId")Integer userId)
    {
        return userService.getVaccinationDate(userId);
    }

    @PutMapping("/update-emailId")
    public String updateEmailId(@RequestBody UpdateEmailDto updateEmailDto)
    {
        return userService.updateEmailId(updateEmailDto);
    }

    @GetMapping("/get-id-by-emailId/{emailId}")
    public User getIdByEmailId(@PathVariable("emailId") String emailId)
    {
        return userService.getIdByEmailId(emailId);
    }
}
