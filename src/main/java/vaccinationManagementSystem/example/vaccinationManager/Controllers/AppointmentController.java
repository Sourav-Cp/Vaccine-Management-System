package vaccinationManagementSystem.example.vaccinationManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.AppointmentReqDto;
import vaccinationManagementSystem.example.vaccinationManager.Services.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/booking")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto)
    {
        try
        {
            String msg = appointmentService.bookAppointment(appointmentReqDto);
            return new ResponseEntity<>(msg,HttpStatus.CREATED);
        }
        catch (RuntimeException ex)
        {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
