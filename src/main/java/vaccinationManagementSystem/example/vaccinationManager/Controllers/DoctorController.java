package vaccinationManagementSystem.example.vaccinationManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.AssociateDocDto;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.EmailIdAlreadyExistException;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.EmailIdEmptyException;
import vaccinationManagementSystem.example.vaccinationManager.Model.Doctor;
import vaccinationManagementSystem.example.vaccinationManager.Services.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor)
    {
        try
        {
           return doctorService.addDoctor(doctor);
        }
        catch (EmailIdAlreadyExistException ex)
        {
            return ex.getMessage();
        }
        catch (EmailIdEmptyException ex)
        {
            return ex.getMessage();
        }
    }

    @PostMapping("/associate-doctor")
    public ResponseEntity<String> associateDoctor(AssociateDocDto associateDocDto)
    {
        try {
            String msg = doctorService.associateDoctor(associateDocDto);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        catch (RuntimeException ex)
        {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}
