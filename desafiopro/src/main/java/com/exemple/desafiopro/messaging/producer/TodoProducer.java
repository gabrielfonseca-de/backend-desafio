package com.exemple.desafiopro.messaging.producer;

import com.exemple.desafiopro.messaging.model.TodoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoProducer {
    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME = "todoQueue";

    public void sendMessage(TodoMessage message) {
        rabbitTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
