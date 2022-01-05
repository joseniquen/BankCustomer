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
public class CustomerType {

    public String codigo;
    public String nombre;
    public String descripcion;
}
