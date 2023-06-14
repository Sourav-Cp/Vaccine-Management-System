package vaccinationManagementSystem.example.vaccinationManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vaccinationManagementSystem.example.vaccinationManager.Services.DoseService;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    private DoseService doseService;

    @PostMapping("/give-dose")
    public String giveDose(@RequestParam("doseId")String doseId,@RequestParam("userId")Integer userId)
    {
        return doseService.giveDose(doseId,userId);
    }
}
