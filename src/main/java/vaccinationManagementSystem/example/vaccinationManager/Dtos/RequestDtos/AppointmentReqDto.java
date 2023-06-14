package vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentReqDto {

    private int userId;
    private int doctorId;
    private LocalTime appointmentTime;
    private Date date;
}
