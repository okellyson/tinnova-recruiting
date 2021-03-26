package com.okellyson.carregister.marca.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(schema = "public", name = "marca")
public class Marca {

    @Id
    private Integer id;

    private String nome;

    private String codigo;

}
