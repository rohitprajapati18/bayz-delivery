package com.bayzdelivery.service;

import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.model.Delivery;

import java.time.Instant;
import java.util.List;

public interface DeliveryService {

  public Delivery save(Delivery delivery);

  public Delivery findById(Long deliveryId);

  List<DeliveryDTO> getTopDeliveryMen(Instant start, Instant end);
}
