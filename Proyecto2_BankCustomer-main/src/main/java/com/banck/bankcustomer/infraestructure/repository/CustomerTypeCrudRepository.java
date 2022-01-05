package com.banck.bankcustomer.infraestructure.repository;

import com.banck.bankcustomer.aplication.model.CustomerTypeRepository;
import com.banck.bankcustomer.domain.CustomerType;
import com.banck.bankcustomer.infraestructure.model.dao.CustomerDao;
import com.banck.bankcustomer.infraestructure.model.dao.CustomerTypeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author jonavcar
 */
@Slf4j
@Component
public class CustomerTypeCrudRepository implements CustomerTypeRepository {

    @Autowired
    ICustomerTypeCrudRepository repositoryCustomerType;

    @Override
    public Mono<CustomerType> get(String id) {
        log.info("CustomerTypeCrudRepository.get");
        return repositoryCustomerType.findById(id).map(this::CustomerDaoToCustomer);
    }

    public CustomerType CustomerDaoToCustomer(CustomerTypeDao cd) {
        log.info("CustomerTypeCrudRepository.CustomerDaoToCustomer");
        CustomerType customer = new CustomerType();
        customer.setCodigo(cd.getCodigo());
        customer.setNombre(cd.getNombre());
        customer.setDescripcion(cd.getDescripcion());
        return customer;
    }

    @Override
    public Flux<CustomerType> listAll() {
        log.info("CustomerTypeCrudRepository.listAll");
        return repositoryCustomerType.findAll().map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<CustomerType> create(CustomerType c) {
        log.info("CustomerTypeCrudRepository.create");
        return repositoryCustomerType.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<CustomerType> update(String id, CustomerType c) {
        log.info("CustomerTypeCrudRepository.update");
        c.setCodigo(id);
        return repositoryCustomerType.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public void delete(String id) {
        log.info("CustomerTypeCrudRepository.delete");
        repositoryCustomerType.deleteById(id);
    }

    public CustomerTypeDao CustomerToCustomerDao(CustomerType c) {
        log.info("CustomerTypeCrudRepository.CustomerToCustomerDao");
        CustomerTypeDao typeDao = new CustomerTypeDao();
        typeDao.setCodigo(c.getCodigo());
        typeDao.setNombre(c.getNombre());
        typeDao.setDescripcion(c.getDescripcion());
        return typeDao;
    }

}
