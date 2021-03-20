package hu.landov.moka.rabbit;

import hu.landov.moka.db.TextMessage;
import hu.landov.moka.db.TextMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "messages")
public class RabbitMessageListener {
    private static final Logger logger =
            LoggerFactory.getLogger(RabbitMessageListener.class);

    @Autowired
    TextMessageRepository messageRepository;

    @RabbitHandler
    public void receiveMessage(String message) {
        LocalDateTime stamp = LocalDateTime.now();
        messageRepository.save(new TextMessage("Hello"));
        logger.info("Received <" + message + "> : " + stamp);
    }
}
