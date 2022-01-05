package com.banck.bankcustomer.aplication.impl;

import com.banck.bankcustomer.aplication.CustomerTypeOperations;
import com.banck.bankcustomer.aplication.model.CustomerTypeRepository;
import com.banck.bankcustomer.domain.CustomerType;
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
public class CustomerTypeOperationsImpl implements CustomerTypeOperations {

    private final CustomerTypeRepository repositoryCustomerType;

    @Override
    public Flux<CustomerType> list() {
        log.info("CustomerTypeOperationsImpl.list");
        return repositoryCustomerType.listAll();
    }

    @Override
    public Mono<CustomerType> get(String dniRuc) {
        log.info("CustomerTypeOperationsImpl.get");
        return repositoryCustomerType.get(dniRuc);
    }

    @Override
    public Mono<CustomerType> create(CustomerType c) {
        log.info("CustomerTypeOperationsImpl.create");
        return repositoryCustomerType.create(c);
    }

    @Override
    public Mono<CustomerType> update(String dniRuc, CustomerType c) {
        log.info("CustomerTypeOperationsImpl.update");
        return repositoryCustomerType.update(dniRuc, c);
    }

    @Override
    public void delete(String dniRuc) {
        log.info("CustomerTypeOperationsImpl.delete");
        repositoryCustomerType.delete(dniRuc);
    }

}
