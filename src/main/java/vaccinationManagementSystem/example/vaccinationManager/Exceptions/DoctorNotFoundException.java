package vaccinationManagementSystem.example.vaccinationManager.Exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String message) {
        super(message);
    }
}
