package liga.medical.messageanalyzer.core.controller;

import liga.medical.commonmodule.dto.body.ResponseBody;
import liga.medical.commonmodule.dto.enums.RabbitMessageType;
import liga.medical.messageanalyzer.core.exception.RabbitTypeException;
import liga.medical.messageanalyzer.api.service.MessageSenderService;
import liga.medical.commonmodule.dto.rabbit.RabbitMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class RabbitController {

    @NonNull
    private MessageSenderService service;

    @PostMapping
    public ResponseEntity<?> getRabbitMessage(@Valid @RequestBody RabbitMessageDto message) {
        String type = message.getType().toUpperCase();
        try {
            RabbitMessageType.valueOf(type);
        } catch (IllegalArgumentException exception) {
            throw new RabbitTypeException(type);
        }
        service.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseBody(HttpStatus.CREATED.toString(), "Message added in queue"));
    }

}
