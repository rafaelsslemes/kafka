package com.study.strproducer.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {

    @Autowired
    public KafkaProperties properties;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        System.out.println("CONFIGURED");
        return new KafkaAdmin(configs);

    }

    @Bean
    public KafkaAdmin.NewTopics createTopics(){

        System.out.println("TOPICS CREATED");

        return new KafkaAdmin.NewTopics(
          TopicBuilder.name("str-topic").partitions(2).replicas(1).build()  
        );

    }
}
