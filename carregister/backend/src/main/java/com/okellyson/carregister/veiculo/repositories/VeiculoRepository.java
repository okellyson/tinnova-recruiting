package com.okellyson.carregister.veiculo.repositories;

import com.okellyson.carregister.veiculo.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
