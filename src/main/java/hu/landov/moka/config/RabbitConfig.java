package hu.landov.moka.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableRabbit
@Import(DBConfig.class)
@ComponentScan(basePackages = {"hu.landov.moka.db","hu.landov.moka.rabbit"})
public class RabbitConfig {

    @Bean
    Queue queue() {
        return new Queue("messages");
    }

    @Bean
    public RabbitTemplate rabbitTemplate()
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate( connectionFactory() );
        //rabbitTemplate.setMessageConverter( jsonMessageConverter() );
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory()
    {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername( "guest" );
        connectionFactory.setPassword( "guest" );
        connectionFactory.setHost( "localhost" );
        connectionFactory.setPort( 5672 );
        return connectionFactory;
    }

    @Bean
    RabbitAdmin admin() {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory());
        admin.declareQueue(queue());
      //  admin.declareBinding(dataBinding(weather(), forecasts()));
        return admin;
    }

    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory listenerFactory()
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory( connectionFactory() );
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
}
