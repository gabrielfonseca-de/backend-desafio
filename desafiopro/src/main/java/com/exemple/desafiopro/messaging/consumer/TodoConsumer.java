package com.exemple.desafiopro.messaging.consumer;

import com.exemple.desafiopro.messaging.model.TodoMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodoConsumer {
    @RabbitListener(queues = "todoQueue")
    public void receiveMessage(TodoMessage message) {
        log.info("Received message: {}", message);
    }
}

