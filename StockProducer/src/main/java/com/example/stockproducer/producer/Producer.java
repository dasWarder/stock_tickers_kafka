package com.example.stockproducer.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class Producer {

    private final String BOOTSTRAP_SERVERS = "127.0.0.1:9092";

    private final String STRING_SERIALIZER = org.apache.kafka.common.serialization.StringSerializer.class.getName();

    private static KafkaProducer<String, String> PRODUCER;

    public Producer() {

        Properties properties = new Properties();

        properties.setProperty(BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.setProperty(KEY_SERIALIZER_CLASS_CONFIG, STRING_SERIALIZER);
        properties.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, STRING_SERIALIZER);

        PRODUCER = new KafkaProducer<>(properties);
    }

    public KafkaProducer<String, String> getKafkaProducer() {
        return PRODUCER;
    }
}
