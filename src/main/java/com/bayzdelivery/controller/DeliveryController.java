package com.bayzdelivery.controller;

import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bayzdelivery.service.DeliveryService;

import java.time.Instant;
import java.util.List;

@RestController
public class DeliveryController {

  @Autowired
  DeliveryService deliveryService;

  @PostMapping(path ="/api/delivery")
  public ResponseEntity<Delivery> createNewDelivery(@RequestBody Delivery delivery) {
    return ResponseEntity.ok(deliveryService.save(delivery));
  }

  @GetMapping(path = "/api/delivery/{delivery-id}")
  public ResponseEntity<Delivery> getDeliveryById(@PathVariable(name="delivery-id",required=true)Long deliveryId){

    Delivery delivery = deliveryService.findById(deliveryId);
    if (delivery !=null)
      return ResponseEntity.ok(delivery);
    return ResponseEntity.notFound().build();
  }

  @GetMapping(path="/api/delivery/top-delivery-men/")
  public ResponseEntity<List<DeliveryDTO>> getTop3Person(@RequestParam(name="start-time") String startTime, @RequestParam(name="end-time") String endTime) {
    Instant start = Instant.parse(startTime);
    Instant end = Instant.parse(endTime);

    List<DeliveryDTO> person = deliveryService.getTopDeliveryMen(start, end);
    return ResponseEntity.ok(person);
  }
}
