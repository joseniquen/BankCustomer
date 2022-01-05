package com.banck.bankcustomer.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jonavcar
 */
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    public String dniRuc;
    public String customerType;
    public String nombreRS;
    public String direccion;
}
