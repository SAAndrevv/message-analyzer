package liga.medical.messageanalyzer.core.exception;

public class RabbitTypeException extends RuntimeException {

    public RabbitTypeException(String type) {
        super("Invalid rabbit type: " + type);
    }

}
