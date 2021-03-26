package com.okellyson.carregister.veiculo.models;

import com.okellyson.carregister.marca.models.Marca;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(schema = "public", name = "veiculo")
public class Veiculo {

    @Id
    private Integer id;

    @NotNull
    private String modelo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id")
    private Marca marca;

    @NotNull
    private Integer ano;

    private String descricao;

    @NotNull
    private Boolean vendido;

    @NotNull
    private Date created;

    private Date updated;

}
