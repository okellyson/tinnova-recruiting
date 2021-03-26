package com.okellyson.carregister.veiculo.controllers;

import com.okellyson.carregister.veiculo.interfaces.IVeiculoService;
import com.okellyson.carregister.veiculo.models.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    IVeiculoService veiculoService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Veiculo>> listarVeiculos() {

        List<Veiculo> veiculos = veiculoService.listar();

        return ResponseEntity.ok()
                .body(veiculos);
    }
}
