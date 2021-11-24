package com.example.stockproducer;

import com.example.stockproducer.producer.Producer;
import com.example.stockproducer.service.KafkaService;
import com.example.stockproducer.service.KafkaServiceImpl;
import com.example.stockproducer.util.ConsoleReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Objects;

@EnableKafka
@RequiredArgsConstructor
public class StockProducerApplication {

  public static void main(String[] args) throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    Producer producer = new Producer();
    KafkaService kafkaService = new KafkaServiceImpl(producer.getKafkaProducer(), mapper);
    ConsoleReader reader = new ConsoleReader();

    while (true) {
      String object = reader.readObject();

      if(Objects.isNull(object)) {
        break;
      }
      kafkaService.produce(object);
    }
  }
}
