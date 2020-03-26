package com.mde;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisEmbededServer {

	@Bean
	public LettuceConnectionFactory redisConnectionFactory(Environment env) {
		return new LettuceConnectionFactory(env.getProperty("spring.redis.host"),
				env.getProperty("spring.redis.port", Integer.class));
	}

	@Bean
	public RedisTemplate<byte[], byte[]> redisTemplate(LettuceConnectionFactory connectionFactory) {
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

}
