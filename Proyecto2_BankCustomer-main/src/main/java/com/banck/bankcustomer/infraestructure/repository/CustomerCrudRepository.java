package com.banck.bankcustomer.infraestructure.repository;

import com.banck.bankcustomer.aplication.model.CustomerRepository;
import com.banck.bankcustomer.domain.Customer;
import com.banck.bankcustomer.infraestructure.model.dao.CustomerDao;
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
public class CustomerCrudRepository implements CustomerRepository {

    @Autowired
    ICustomerCrudRepository repository;

    @Override
    public Mono<Customer> getCustomer(String dniRuc) {
        log.info("CustomerCrudRepository.getCustomer");
        return repository.findById(dniRuc).map(this::CustomerDaoToCustomer);
    }

    public Customer CustomerDaoToCustomer(CustomerDao cd) {
        log.info("CustomerCrudRepository.CustomerDaoToCustomer");
        Customer customer = new Customer();
        customer.setDniRuc(cd.getDniRuc());
        customer.setNombreRS(cd.getNombreRS());
        customer.setDireccion(cd.getDireccion());
        customer.setCustomerType(cd.getCustomerType());
        return customer;
    }

    @Override
    public Flux<Customer> listAllCustomer() {
        log.info("CustomerCrudRepository.listAllCustomer");
        return repository.findAll().map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<Customer> create(Customer c) {
        log.info("CustomerCrudRepository.create");
        return repository.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public Mono<Customer> update(String dniRuc, Customer c) {
        log.info("CustomerCrudRepository.update");
        c.setDniRuc(dniRuc);
        return repository.save(CustomerToCustomerDao(c)).map(this::CustomerDaoToCustomer);
    }

    @Override
    public void delete(String dniRuc) {
        log.info("CustomerCrudRepository.delete");
        repository.deleteById(dniRuc);
    }

    public CustomerDao CustomerToCustomerDao(Customer c) {
        log.info("CustomerCrudRepository.CustomerToCustomerDao");
        CustomerDao customerDao = new CustomerDao();
        customerDao.setDniRuc(c.getDniRuc());
        customerDao.setNombreRS(c.getNombreRS());
        customerDao.setDireccion(c.getDireccion());
        customerDao.setCustomerType(c.getCustomerType());
        return customerDao;
    }

}
