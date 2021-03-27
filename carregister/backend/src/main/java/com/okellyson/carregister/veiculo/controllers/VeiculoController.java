package com.okellyson.carregister.veiculo.controllers;

import com.okellyson.carregister.veiculo.dtos.VeiculoDTO;
import com.okellyson.carregister.veiculo.interfaces.IVeiculoService;
import com.okellyson.carregister.veiculo.models.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VeiculoController {

    private static final String BASE_ROUTE = "/veiculo";

    @Autowired
    IVeiculoService veiculoService;

    @GetMapping(value = BASE_ROUTE)
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos() {

        List<VeiculoDTO> veiculos = veiculoService.listar();

        return ResponseEntity.ok()
                .body(veiculos);

    }

    @GetMapping(value = BASE_ROUTE + "/{id}")
    public ResponseEntity<VeiculoDTO> buscar(@PathVariable Integer id) {

        VeiculoDTO veiculo = veiculoService.buscar(id);

        return ResponseEntity.ok()
                .body(veiculo);

    }

    @PostMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> cadastrar(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoSalvo = veiculoService.cadastrar(veiculoDTO);

        return ResponseEntity.ok()
                .body(veiculoSalvo);

    }

    @PutMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> editar(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoEditado = veiculoService.editar(veiculoDTO);

        return ResponseEntity.ok()
                .body(veiculoEditado);

    }

    @DeleteMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> excluir(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoExcluido = veiculoService.excluir(veiculoDTO);

        return ResponseEntity.ok()
                .body(veiculoExcluido);

    }

    @PatchMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> vender(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoVendido = veiculoService.vender(veiculoDTO);

        return ResponseEntity.ok()
                .body(veiculoVendido);

    }
}
