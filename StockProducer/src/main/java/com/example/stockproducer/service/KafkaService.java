package com.example.stockproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KafkaService {

  void produce(String serializeObject) throws JsonProcessingException;
}
