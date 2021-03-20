package hu.landov.moka.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMessageSender {
    private static final Logger logger =
            LoggerFactory.getLogger(RabbitMessageSender.class);
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void sendMessage(String message) {
        this.template.convertAndSend(queue.getName(), message);
        logger.info(" [x] Sent '" + message + "'");
    }
}
