package com.okellyson.carregister.veiculo.models;

import com.okellyson.carregister.marca.interfaces.IMarcaService;
import com.okellyson.carregister.marca.models.Marca;
import com.okellyson.carregister.util.Mensagem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "public", name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = Mensagem.SEM_MODELO)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id")
    @NotNull(message = Mensagem.SEM_MARCA)
    private Marca marca;

    @NotNull(message = Mensagem.SEM_ANO)
    private Integer ano;

    private String descricao;

    @NotNull(message = Mensagem.SEM_VENDIDO)
    private Boolean vendido;

    @NotNull(message = Mensagem.SEM_CREATED)
    private Date created;

    private Date updated;

    public Veiculo(VeiculoBuilder builder) {

        this.created = new Date();

        this.modelo = builder.modelo;
        this.descricao = builder.descricao;
        this.marca = builder.marca;
        this.ano = builder.ano;
        this.vendido = builder.vendido;

    }

    public static class VeiculoBuilder {

        public String modelo;
        public Marca marca;
        public Integer ano;
        public String descricao;
        public Boolean vendido;

        public VeiculoBuilder() {}

        public VeiculoBuilder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public VeiculoBuilder setMarca(Marca marca) {
            this.marca = marca;
            return this;
        }

        public VeiculoBuilder setAno(Integer ano) {
            this.ano = ano;
            return this;
        }

        public VeiculoBuilder setDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public VeiculoBuilder setVendido(Boolean vendido) {
            this.vendido = vendido != null && vendido;
            return this;
        }

        public Veiculo build() { return new Veiculo(this); }

    }

}
