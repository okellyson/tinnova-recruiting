package com.okellyson.carregister.marca.services;

import com.okellyson.carregister.config.GenericService;
import com.okellyson.carregister.marca.interfaces.IMarcaService;
import com.okellyson.carregister.marca.models.Marca;
import com.okellyson.carregister.marca.repositories.MarcaRepository;
import com.okellyson.carregister.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService extends GenericService implements IMarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public Marca getByNome(String nome) {

        Marca marca = marcaRepository.findFirstByNomeIgnoreCase(nome);

        notIfNull(marca, Mensagem.MARCA_NAO_ENCONTRADA);

        return marca;
    }

}
