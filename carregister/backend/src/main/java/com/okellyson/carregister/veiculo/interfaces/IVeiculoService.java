package com.okellyson.carregister.veiculo.interfaces;

import com.okellyson.carregister.veiculo.dtos.VeiculoDTO;
import com.okellyson.carregister.veiculo.models.Veiculo;

import java.util.List;

public interface IVeiculoService {

    List<VeiculoDTO> listar();

    VeiculoDTO buscar(Integer id);

    VeiculoDTO cadastrar(VeiculoDTO veiculoDTO);

    VeiculoDTO editar(VeiculoDTO veiculoDTO);

    VeiculoDTO excluir(VeiculoDTO veiculoDTO);

    VeiculoDTO vender(VeiculoDTO veiculoDTO);

}
