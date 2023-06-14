package vaccinationManagementSystem.example.vaccinationManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaccinationManagementSystem.example.vaccinationManager.Dtos.RequestDtos.AssociateDocDto;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.DoctorNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.EmailIdAlreadyExistException;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.EmailIdEmptyException;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.VaccinationCentreNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Model.Doctor;
import vaccinationManagementSystem.example.vaccinationManager.Model.VaccinationCentre;
import vaccinationManagementSystem.example.vaccinationManager.Repository.CentreRepository;
import vaccinationManagementSystem.example.vaccinationManager.Repository.DoctorRepository;

import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CentreRepository centreRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmptyException, EmailIdAlreadyExistException
    {
        if(doctor.getEmailId() == null)
        {
            throw new EmailIdEmptyException("Email Id is must");
        }
        if(doctorRepository.findByEmailId(doctor.getEmailId()) != null)
        {
            throw new EmailIdAlreadyExistException("Email Id Already Exist");
        }
        doctorRepository.save(doctor);

        return "Doctor Added Successfully";
    }

    public String associateDoctor(AssociateDocDto associateDocDto) throws DoctorNotFoundException,VaccinationCentreNotFoundException
    {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(associateDocDto.getDocId());
        if(optionalDoctor.isEmpty()) throw new DoctorNotFoundException("Doctor doesn't Exist");

        Optional<VaccinationCentre> optionalVaccinationCentre = centreRepository.findById(associateDocDto.getCentreId());
        if(optionalVaccinationCentre.isEmpty()) throw new VaccinationCentreNotFoundException("Centre doesn't Exist");

        Doctor doctor = optionalDoctor.get();
        VaccinationCentre vaccinationCentre = optionalVaccinationCentre.get();

        doctor.setVaccinationCentre(vaccinationCentre);//setting the foreign key
        vaccinationCentre.getDoctorList().add(doctor); //setting the list of doctors

        centreRepository.save(vaccinationCentre);

        return "Doctor has been associated with centre";
    }
}
