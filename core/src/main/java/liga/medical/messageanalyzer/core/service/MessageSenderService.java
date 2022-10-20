package liga.medical.messageanalyzer.core.service;

import liga.medical.messageanalyzer.dto.rabbit.RabbitMessageDto;

public interface MessageSenderService {

    void sendMessage(RabbitMessageDto messageDto);

}
