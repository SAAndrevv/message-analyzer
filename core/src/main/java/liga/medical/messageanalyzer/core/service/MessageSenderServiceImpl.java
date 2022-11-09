package liga.medical.messageanalyzer.core.service;

import liga.medical.commonmodule.dto.rabbit.RabbitMessageDto;
import liga.medical.commonmodule.service.annotation.DBLog;
import liga.medical.messageanalyzer.api.service.MessageSenderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    @NonNull
    private AmqpTemplate template;
    @Value("${rabbit.queue.common-monitoring-queue}")
    private String queue;

    @Override
    @DBLog
    public void sendMessage(RabbitMessageDto messageDto) {
        template.convertAndSend(queue, messageDto);
    }

}
