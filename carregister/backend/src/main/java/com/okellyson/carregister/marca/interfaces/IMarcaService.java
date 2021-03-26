package com.okellyson.carregister.marca.interfaces;

import com.okellyson.carregister.marca.models.Marca;

public interface IMarcaService {

    Marca getByNome(String nome);

}
