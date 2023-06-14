package vaccinationManagementSystem.example.vaccinationManager.Exceptions;

public class EmailIdEmptyException extends RuntimeException{
    public EmailIdEmptyException(String message) {
        super(message);
    }
}
