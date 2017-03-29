package com.example;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.UUID;
import java.util.stream.IntStream;

public class XProducer implements Runnable {
    private final Producer producer;
    private final String topic;

    public XProducer(Producer producer, String topic) {
        this.producer = producer;
        this.topic = topic;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(0, 1000)
                .forEach(key -> {
                    ProducerRecord<Integer, String> record = new ProducerRecord<>(topic, 0, key++, UUID.randomUUID().toString());

                    producer.send(record, (metadata, exception) -> {
                        if (exception == null) {
                            System.out.println("Record sent!");
                        } else {
                            exception.printStackTrace();
                        }
                    });
                });

        producer.close();
    }
}
