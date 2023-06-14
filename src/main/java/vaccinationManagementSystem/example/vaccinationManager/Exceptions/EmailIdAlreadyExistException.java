package vaccinationManagementSystem.example.vaccinationManager.Exceptions;

public class EmailIdAlreadyExistException extends RuntimeException{
    public EmailIdAlreadyExistException(String message) {
        super(message);
    }
}
