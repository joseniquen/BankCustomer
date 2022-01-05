package com.banck.bankcustomer.infraestructure.model.dao;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author jonavcar
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "customerType")
public class CustomerTypeDao {

    @Id
    public String codigo;

    @Field(value = "nombre")
    public String nombre;

    @Field(value = "descripcion")
    public String descripcion;
}
