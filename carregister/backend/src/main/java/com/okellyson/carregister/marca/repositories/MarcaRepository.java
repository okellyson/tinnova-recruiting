package com.okellyson.carregister.marca.repositories;

import com.okellyson.carregister.marca.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Marca findFirstByNomeIgnoreCase(String nome);

}
