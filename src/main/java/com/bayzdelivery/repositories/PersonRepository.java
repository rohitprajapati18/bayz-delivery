package com.bayzdelivery.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import com.bayzdelivery.model.Person;

import java.time.Instant;
import java.util.List;

@RestResource(exported=false)
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
