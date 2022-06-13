package com.bayzdelivery.repositories;

import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.model.Person;
import liquibase.pro.packaged.D;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.Instant;
import java.util.List;

@RestResource(exported = false)
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    @Query(value = "SELECT * FROM delivery "
            + "WHERE start_time >= :start AND end_time <= :end "
            + "GROUP BY delivery_man_id "
            + "ORDER MAX(price) DESC limit 3", nativeQuery = true)
    List<Delivery> getDeliveryMan(Instant start, Instant end);

    @Query(value = "SELECT AVG(comission) FROM delivery\n"
            + "WHERE start_time > :startTime AND end_time < :endTime\n"
            + "AND delivery_man_id = :id", nativeQuery = true)
    Long averageComission(Instant startTime, Instant endTime, Long id);

    @Query(value = "SELECT * FROM delivery WHERE "
            + "TIMESTAMPDIFF(MINUTE,start_time,:instantTime) > 45 AND end_time IS NULL", nativeQuery = true)
    List<Delivery> getDelayedDeliveries(Instant instantTime);

    @Query("FROM Delivery d WHERE ((d.startTime >= :start AND d.endTime <= :start) OR (d.startTime >= :end AND d.endTime <= :end)) AND d.deliveryMan.id = :deliveryMenId")
    List<Delivery> getOtherDelivery(Instant start, Instant end, Long deliveryMenId);
}
