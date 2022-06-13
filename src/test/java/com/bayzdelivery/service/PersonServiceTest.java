package com.bayzdelivery.service;

import com.bayzdelivery.model.Person;
import com.bayzdelivery.repositories.PersonRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest(){
        List<Person> persons = new ArrayList<>();

        Person p = new Person();
        p.setEmail("abcd@gmail.com");
        p.setName("John Doe");
        p.setDeliveryMen(true);
        p.setRegistrationNumber("134324");

        persons.add(p);
        when(personRepository.findAll()).thenReturn(persons);

        List<Person> person = personService.getAll();

        assertThat(person).isEqualTo(persons);
    }

    @Test
    public void saveTest(){
        Person p = new Person();
        p.setEmail("abcd@gmail.com");
        p.setName("John Doe");
        p.setDeliveryMen(true);
        p.setRegistrationNumber("134324");

        when(personRepository.save(p)).thenReturn(p);

        Person sp = personService.save(p);
        assertThat(sp).isEqualTo(p);
    }
}
