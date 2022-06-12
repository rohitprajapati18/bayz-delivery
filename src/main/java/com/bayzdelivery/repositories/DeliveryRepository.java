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
    @Query(value = "select * from delivery "
            + "where start_time >= :start and end_time <= :end "
            + "GROUP BY delivery_man_id "
            + "order by max(price) desc limit 3", nativeQuery = true)
    List<Delivery> getDeliveryMan(Instant start, Instant end);

    @Query(value = "select avg(comission) from delivery\n"
            + "where start_time > :startTime and end_time < :endTime\n"
            + "and delivery_man_id = :id", nativeQuery = true)
    Long averageComission(Instant startTime, Instant endTime, Long id);

    @Query(value = "select * from delivery where "
            + "TIMESTAMPDIFF(MINUTE,start_time,:instantTime) > 45 and end_time is NULL", nativeQuery = true)
    List<Delivery> getDelayedDeliveries(Instant instantTime);

    @Query("FROM Delivery d WHERE ((d.startTime >= :start AND d.endTime <= :start) OR (d.startTime >= :end AND d.endTime <= :end)) AND d.deliveryMan.id = :deliveryMenId")
    List<Delivery> getOtherDelivery(Instant start, Instant end, Long deliveryMenId);
}
