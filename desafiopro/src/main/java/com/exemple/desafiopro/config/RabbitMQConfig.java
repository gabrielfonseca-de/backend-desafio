package com.exemple.desafiopro.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue todoQueue() {
        return new Queue("Mensagem aqui (depois conferir no desafio)", true);
    }

    @Bean
    public DirectMessageListenerContainer container(ConnectionFactory connectionFactory, RabbitTemplate rabbitTemplate) {
        DirectMessageListenerContainer container = new DirectMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("todoQueue");
        container.setMessageListener(rabbitTemplate);
        return container;
    }
}
