package com.okellyson.carregister.veiculo.services;

import com.okellyson.carregister.marca.interfaces.IMarcaService;
import com.okellyson.carregister.marca.models.Marca;
import com.okellyson.carregister.marca.repositories.MarcaRepository;
import com.okellyson.carregister.veiculo.interfaces.IVeiculoService;
import com.okellyson.carregister.veiculo.models.Veiculo;
import com.okellyson.carregister.veiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements IVeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;


    @Override
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }
}
