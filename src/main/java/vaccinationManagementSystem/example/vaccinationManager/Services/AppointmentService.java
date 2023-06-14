package vaccinationManagementSystem.example.vaccinationManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.AppointmentReqDto;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.DoctorNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.UserNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Model.Appointment;
import vaccinationManagementSystem.example.vaccinationManager.Model.Doctor;
import vaccinationManagementSystem.example.vaccinationManager.Model.User;
import vaccinationManagementSystem.example.vaccinationManager.Repository.AppointmentRepository;
import vaccinationManagementSystem.example.vaccinationManager.Repository.DoctorRepository;
import vaccinationManagementSystem.example.vaccinationManager.Repository.UserRepository;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserRepository userRepository;

    public String bookAppointment(AppointmentReqDto appointmentReqDto) throws DoctorNotFoundException,UserNotFoundException
    {
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDoctorId());
        if(doctorOptional.isEmpty()) throw new DoctorNotFoundException("Doctor doesn't Exist");

        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());
        if(userOptional.isEmpty()) throw new UserNotFoundException("User doesn't Exist");

        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        Appointment appointment = new Appointment();

        appointment.setAppointmentDate(appointmentReqDto.getDate());
        appointment.setAppointmentTime(appointmentReqDto.getAppointmentTime());

        appointment.setUser(user);
        appointment.setDoctor(doctor);

        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        return "Appointment booked successfully";
    }
}
