package com.banck.bankcustomer.aplication.impl;

import com.banck.bankcustomer.aplication.CustomerOperations;
import com.banck.bankcustomer.aplication.model.CustomerRepository;
import com.banck.bankcustomer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerOperationsImpl implements CustomerOperations {

    private final CustomerRepository repository;

    @Override
    public Flux<Customer> list() {
        log.info("CustomerOperationsImpl.list");
        return repository.listAllCustomer();
    }

    @Override
    public Mono<Customer> get(String dniRuc) {
        log.info("CustomerOperationsImpl.get");
        return repository.getCustomer(dniRuc);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        log.info("CustomerOperationsImpl.create");
        return repository.create(c);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        log.info("CustomerOperationsImpl.update");
        return repository.update(dniRuc, c);
    }

    @Override
    public void delete(String dniRuc) {
        log.info("CustomerOperationsImpl.delete");
        repository.delete(dniRuc);
    }

}
