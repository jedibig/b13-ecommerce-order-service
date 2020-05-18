package com.b13.orderservice.message;

import java.util.Map;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rabbit.properties")
public class RabbitConfiguration {
	
	Map<String, String> exchange;
	
	@Bean
	@ConditionalOnProperty(value = "exchange.topic")
	public TopicExchange topicExchange() {
		return new TopicExchange("${exchange.topic}");
	}
	
	@Bean
	@ConditionalOnProperty(value = "exchange.fanout")
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("${exchange.fanout}");
	}
	
	@Bean
	@ConditionalOnProperty(value = "exchange.direct")
	public DirectExchange directExchange() {
		return new DirectExchange("${exchange.direct}");
	}
	
	
	
	
}
