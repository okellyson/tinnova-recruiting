package com.okellyson.carregister.veiculo.interfaces;

import com.okellyson.carregister.veiculo.models.Veiculo;
import com.sun.tools.javac.util.List;

public interface IVeiculoService {

    List<Veiculo> listar();

    void cadastrar(Veiculo veiculo);

}
