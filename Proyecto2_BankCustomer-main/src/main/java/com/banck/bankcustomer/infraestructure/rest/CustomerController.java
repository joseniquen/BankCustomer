package com.banck.bankcustomer.infraestructure.rest;

import com.banck.bankcustomer.aplication.CustomerOperations;
import com.banck.bankcustomer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 *
 * @author jonavcar
 */
@Slf4j
@RestController
@RequestMapping("/customer/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerOperations operations;

   /* @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 400, message = "Error", response = GenericError.class),
            @ApiResponse(code = 401, message = "Acceso no autorizado", response = GenericError.class),
            @ApiResponse(code = 500, message = "Ocurrio un error", response = GenericError.class)
    })*/
    @GetMapping
    public Flux<Customer> listAll() {
        log.info("CustomerController.listAll");
        return operations.list();
    }

    @GetMapping("/{id}")
    public Mono<Customer> get(@PathVariable("id") String dniRuc) {
        log.info("CustomerController.get");
        return operations.get(dniRuc);
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer c) {
        log.info("CustomerController.create");
        return operations.create(c);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable("id") String dniRuc, @RequestBody Customer c) {
        log.info("CustomerController.update");
        return operations.update(dniRuc, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String dniRuc) {
        log.info("CustomerController.delete");
        operations.delete(dniRuc);
    }
}
