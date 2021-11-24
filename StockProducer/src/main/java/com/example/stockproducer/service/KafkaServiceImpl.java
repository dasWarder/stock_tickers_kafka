package com.example.stockproducer.service;

import com.example.stockproducer.model.StockTickerData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

  private final KafkaProducer<String, String> producer;

  private final ObjectMapper mapper;

  @Override
  @Transactional
  public void produce(String serializeObject) throws JsonProcessingException {

    log.info("Produce a new stock ticker object");
    StockTickerData stockTickerData = mapper.readValue(serializeObject, StockTickerData.class);

    ProducerRecord<String, String> record =
        new ProducerRecord<>("stockTickers", stockTickerData.getCompanyKey(), serializeObject);
    producer.send(record);
  }
}
