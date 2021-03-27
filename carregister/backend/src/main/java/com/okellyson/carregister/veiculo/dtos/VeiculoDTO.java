package com.okellyson.carregister.veiculo.dtos;

import com.okellyson.carregister.veiculo.models.Veiculo;
import lombok.Getter;

import java.util.Date;

@Getter
public class VeiculoDTO {

    public Integer id;
    public String veiculo;
    public String marca;
    public Integer ano;
    public String descricao;
    public Boolean vendido;
    public Date created;
    public Date updated;

    public VeiculoDTO parse(Veiculo veiculo) {

        if(veiculo != null) {

            this.id = veiculo.getId();
            this.veiculo = veiculo.getModelo();
            this.marca = veiculo.getMarca().getNome();
            this.ano = veiculo.getAno();
            this.descricao = veiculo.getDescricao();
            this.vendido = veiculo.getVendido();
            this.created = veiculo.getCreated();
            this.updated = veiculo.getUpdated();

        }

        return this;

    }

}
