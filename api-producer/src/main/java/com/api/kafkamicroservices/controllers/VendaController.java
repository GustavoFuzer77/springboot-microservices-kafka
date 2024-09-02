package com.api.kafkamicroservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {

  private KafkaTemplate<String, String> kafkaTemplate;

  public VendaController(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @PostMapping("/send")
  public ResponseEntity<String> send(@RequestBody String id) {
    kafkaTemplate.send("product-update-topic", id);
    return ResponseEntity.ok().body(id);
  }
}
