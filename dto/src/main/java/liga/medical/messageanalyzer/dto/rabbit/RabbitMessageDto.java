package liga.medical.messageanalyzer.dto.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMessageDto {
    @NotEmpty(message = "Field type can't be an empty")
    private String type;
    private String message;
}
