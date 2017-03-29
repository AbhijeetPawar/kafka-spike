package com.example;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Runner {

    private final Consumer consumer;
    private final Producer producer;

    @Autowired
    public Runner(Consumer consumer, Producer producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        String topicName = "sales_topic";

        Thread consumerThread = new Thread(new XConsumer(consumer, Collections.singleton(topicName)));
        Thread producerThread = new Thread(new XProducer(producer, topicName));

        consumerThread.start();
//        producerThread.start();
    }

}
