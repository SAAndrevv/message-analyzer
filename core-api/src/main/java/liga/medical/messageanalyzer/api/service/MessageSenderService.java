package liga.medical.messageanalyzer.api.service;

import liga.medical.commonmodule.dto.rabbit.RabbitMessageDto;

public interface MessageSenderService {

    void sendMessage(RabbitMessageDto messageDto);

}
