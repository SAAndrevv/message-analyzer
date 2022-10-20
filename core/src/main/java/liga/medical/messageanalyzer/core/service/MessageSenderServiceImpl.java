package liga.medical.messageanalyzer.core.service;

import liga.medical.messageanalyzer.dto.rabbit.RabbitMessageDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class MessageSenderServiceImpl implements MessageSenderService {

    @NonNull
    private AmqpTemplate template;
    @Value("${rabbit.queue.common-monitoring-queue}")
    private String queue;

    @Override
    public void sendMessage(RabbitMessageDto messageDto) {
        template.convertAndSend(queue, messageDto);
    }
}
