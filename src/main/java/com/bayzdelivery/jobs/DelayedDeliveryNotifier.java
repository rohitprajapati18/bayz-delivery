package com.bayzdelivery.jobs;

import com.bayzdelivery.exceptions.GlobalExceptionHandler;
import com.bayzdelivery.model.Delivery;
import com.bayzdelivery.repositories.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DelayedDeliveryNotifier {

    @Autowired
    private DeliveryRepository deliveryRepository;

    private static final Logger LOG = LoggerFactory.getLogger(DelayedDeliveryNotifier.class);

    /**
     *  Use this method for the TASK 3
     *
     *  Finds all the deliveries that are over 45 mins and not delivered
     */
    @Scheduled(fixedDelay = 1000*45*60)
    public void checkDelayedDeliveries() {
        List<Delivery> delayedDeliveries = deliveryRepository.getDelayedDeliveries();

        for (Delivery delivery : delayedDeliveries) {
            System.out.println(delivery);
        }

        if(delayedDeliveries.isEmpty() == false) {
            notifyCustomerSupport();
        }
    }


    /**
     * This method should be called to notify customer support team
     * It just writes notification on console but it may be email or push notification in real.
     * So that this method should run in an async way.
     */
    @Async
    public void notifyCustomerSupport() {
        LOG.info("Customer support team is notified!");
    }
}
