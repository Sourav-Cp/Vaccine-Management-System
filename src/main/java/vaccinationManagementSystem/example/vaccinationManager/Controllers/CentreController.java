package vaccinationManagementSystem.example.vaccinationManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.VaccinationCentreNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Model.VaccinationCentre;
import vaccinationManagementSystem.example.vaccinationManager.Services.CentreService;

@RestController
@RequestMapping("/centre")
public class CentreController {

    @Autowired
    CentreService centreService;

    public ResponseEntity<String> addCentre(VaccinationCentre vaccinationCentre)
    {
        try {
            String msg = centreService.addCentre(vaccinationCentre);
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }
        catch (VaccinationCentreNotFoundException ex)
        {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
