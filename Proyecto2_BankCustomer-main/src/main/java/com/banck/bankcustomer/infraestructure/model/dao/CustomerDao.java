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
@Document(collection = "customer")
public class CustomerDao {

    @Id
    public String dniRuc;

    @Field(value = "customerType")
    public String customerType;

    @Field(value = "nombreRS")
    public String nombreRS;

    @Field(value = "direccion")
    public String direccion;
}
