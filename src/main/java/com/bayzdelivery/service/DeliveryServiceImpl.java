package com.bayzdelivery.service;

import java.time.Instant;
import java.util.*;

import com.bayzdelivery.dto.DeliveryDTO;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

  @Autowired
  DeliveryRepository deliveryRepository;

  @Autowired
  PersonRepository personRepository;

  public Delivery save(Delivery delivery){
    Optional<Person> deliveryPerson = personRepository.findById(delivery.getDeliveryMan().getId());
    Optional<Person> customer = personRepository.findById(delivery.getCustomer().getId());

    if(customer.isPresent() && deliveryPerson.isPresent()){
      delivery.setDeliveryMan(deliveryPerson.get());
      delivery.setCustomer(customer.get());

      List<Delivery> others = deliveryRepository.getOtherDelivery(delivery.getStartTime(), delivery.getEndTime(), delivery.getDeliveryMan().getId());

      Boolean flag = false;
      if(!others.isEmpty()) flag = true;
      if(!delivery.getDeliveryMan().getDeliveryMen()) flag = true;
      if(delivery.getCustomer().getDeliveryMen()) flag = true;

      if(!flag) return deliveryRepository.save(delivery);
    }

    return new Delivery();
  }

  public Delivery findById(Long deliveryId) {
    Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
    if (optionalDelivery.isPresent()) {
      return optionalDelivery.get();
    }else return null;
  }

  @Override
  public List<DeliveryDTO> getTopDeliveryMen(Instant start, Instant end) {
    List<Delivery> deliveries = deliveryRepository.getDeliveryMan(start, end);

    //List<Person> topDeliveryPersons = new ArrayList<Person>();
    List<DeliveryDTO> result = new ArrayList<>();

    for (Delivery delivery : deliveries) {
      Person deliveryMan = delivery.getDeliveryMan();
      Long avgComission = deliveryRepository.averageComission(start, end, deliveryMan.getId());
      result.add(new DeliveryDTO(deliveryMan, avgComission));
    }

    return result;
  }
}

Hello world