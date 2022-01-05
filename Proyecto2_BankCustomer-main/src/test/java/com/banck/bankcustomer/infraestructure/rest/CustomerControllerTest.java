package com.banck.bankcustomer.infraestructure.rest;

import com.banck.bankcustomer.aplication.CustomerOperations;
import com.banck.bankcustomer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CustomerControllerTest {

    @Autowired
     CustomerController customerController;

    @Test
    void listAll() {
        log.info("CustomerControllerTest.get");
        Flux<Customer> result = customerController.listAll();
        List<Customer> lc = new ArrayList<>();
        Customer c = new Customer();
        c.setDniRuc("34984545");
        c.setCustomerType("CTP");
        c.setNombreRS("Empresa sac.");
        c.setDireccion("Jr. Andy LT. 18  ZN. 2 Trujillo");
        lc.add(c);
        assertEquals(result,lc);
    }

    @Test
    void get() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}