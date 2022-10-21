package liga.medical.messageanalyzer.core.controller;

import liga.medical.messageanalyzer.core.exception.RabbitTypeException;
import liga.medical.messageanalyzer.core.service.MessageSenderService;
import liga.medical.messageanalyzer.dto.rabbit.RabbitMessageDto;
import liga.medical.messageanalyzer.dto.rabbit.RabbitType;
import liga.medical.messageanalyzer.dto.response.ResponseBody;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class RabbitController {

    @NonNull
    private MessageSenderService service;

    @GetMapping
    public ResponseEntity<?> getRabbitMessage(@Valid @RequestBody RabbitMessageDto message) {
        String type = message.getType().toUpperCase();
        try {
            RabbitType.valueOf(type);
        } catch (IllegalArgumentException exception) {
            throw new RabbitTypeException(type);
        }
        service.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseBody(HttpStatus.CREATED.toString(), "Message added in queue"));
    }
}
