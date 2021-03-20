package hu.landov.moka;


import hu.landov.moka.config.RabbitConfig;
import hu.landov.moka.db.TextMessage;
import hu.landov.moka.db.TextMessageRepository;
import hu.landov.moka.rabbit.RabbitMessageListener;
import hu.landov.moka.rabbit.RabbitMessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import com.google.common.collect.Lists;

import java.util.List;

public class MessageSenderCli {
    private static final Logger logger =
            LoggerFactory.getLogger(MessageSenderCli.class);


    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(RabbitConfig.class);
        RabbitMessageSender messageSender = ctx.getBean(RabbitMessageSender.class);
        //TextMessageRepository repository = ctx.getBean(TextMessageRepository.class);
        messageSender.sendMessage("Hello");
     //   List<TextMessage> messageList = Lists.newArrayList(repository.findAll());
     //   messageList.forEach((text) -> {logger.info(text.toString());});
        ctx.close();


    }
}
