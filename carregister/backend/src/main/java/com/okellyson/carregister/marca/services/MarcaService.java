package com.okellyson.carregister.marca.services;

import com.okellyson.carregister.marca.interfaces.IMarcaService;
import com.okellyson.carregister.marca.models.Marca;
import com.okellyson.carregister.marca.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService implements IMarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public Marca getByNome(String nome) {
        return marcaRepository.findFirstByNomeIgnoreCase(nome);
    }

}
