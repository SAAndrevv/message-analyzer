package liga.medical.messageanalyzer.dto.rabbit;

public enum RabbitType {
    DAILY("daily"), ALERT("alert"), ERROR("error");

    private final String type;

    RabbitType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
