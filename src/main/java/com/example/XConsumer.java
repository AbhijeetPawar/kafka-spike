package com.example;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class XConsumer implements Runnable {

    private final Consumer consumer;
    private final Collection<String> topics;

    public XConsumer(Consumer consumer, Collection<String> topics) {
        this.consumer = consumer;
        this.topics = topics;
    }

    @Override
    public void run() {
        try {
            consumer.subscribe(topics);

            while (true) {
                ConsumerRecords<Integer, String> records = consumer.poll(0);
                for (ConsumerRecord<Integer, String> record : records) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("partition", record.partition());
                    data.put("offset", record.offset());
                    data.put("value", record.value());
                    System.out.println("Data : " + data);
                }

            }
        } catch (WakeupException e) {
            // ignore for shutdown
        } finally {
            consumer.close();
        }
    }
}
