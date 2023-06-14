package vaccinationManagementSystem.example.vaccinationManager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vaccinationManagementSystem.example.vaccinationManager.Exceptions.VaccinationCentreNotFoundException;
import vaccinationManagementSystem.example.vaccinationManager.Model.VaccinationCentre;
import vaccinationManagementSystem.example.vaccinationManager.Repository.CentreRepository;

@Service
public class CentreService {
    @Autowired
    CentreRepository centreRepository;

    public String addCentre(VaccinationCentre vaccinationCentre) throws VaccinationCentreNotFoundException
    {
        if(vaccinationCentre.getAddress() == null)
        {
            throw new VaccinationCentreNotFoundException("Enter Valid Address");
        }
        centreRepository.save(vaccinationCentre);
        return "Centre Added Successfully";
    }
}
