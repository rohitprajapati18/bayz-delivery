package com.bayzdelivery.dto;

import com.bayzdelivery.model.Person;

public class DeliveryDTO {
    Person person;

    Long averageComission;

    public DeliveryDTO() {
        super();
    }

    public DeliveryDTO(Person person, Long averageComission) {
        super();
        this.person = person;
        //this.maximumOrderPrice = maximumOrderPrice;
        this.averageComission = averageComission;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getAverageComission() {
        return averageComission;
    }

    public void setAverageComission(Long averageComission) {
        this.averageComission = averageComission;
    }


}
