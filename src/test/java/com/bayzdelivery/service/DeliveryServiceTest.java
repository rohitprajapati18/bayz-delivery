package com.bayzdelivery.service;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.DeliveryRepository;
import com.bayzdelivery.repositories.PersonRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeliveryServiceTest {
    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById(){
        Person p = new Person();
        p.setEmail("abcd@gmail.com");
        p.setName("John Doe");
        p.setDeliveryMen(true);
        p.setRegistrationNumber("134324");

        Person q = new Person();
        q.setEmail("acd@gmail.com");
        q.setName("Jane Doe");
        q.setDeliveryMen(false);
        q.setRegistrationNumber("231231");

        Delivery d = new Delivery();
        d.setId(224L);
        d.setDeliveryMan(p);
        d.setCustomer(q);
        d.setDistance(12L);
        d.setEndTime(Instant.now());
        d.setStartTime(Instant.now().minus(Period.ofDays(1)));

        when(deliveryRepository.findById(12L)).thenReturn(Optional.of(d));

        Delivery sd = deliveryService.findById(12L);
        assertThat(sd).isEqualTo(d);
    }

    @Test
    public void saveTest(){
        Person p = new Person();
        p.setEmail("abcd@gmail.com");
        p.setName("John Doe");
        p.setDeliveryMen(true);
        p.setRegistrationNumber("134324");

        Person q = new Person();
        q.setEmail("acd@gmail.com");
        q.setName("Jane Doe");
        q.setDeliveryMen(false);
        q.setRegistrationNumber("231231");

        Delivery d = new Delivery();
        d.setDeliveryMan(p);
        d.setCustomer(q);
        d.setDistance(12L);
        d.setEndTime(Instant.now());
        d.setStartTime(Instant.now().minus(Period.ofDays(1)));

        when(deliveryRepository.save(d)).thenReturn(d);

        Delivery sd = deliveryService.save(d);
        assertThat(sd).isEqualTo(d);
    }
}
