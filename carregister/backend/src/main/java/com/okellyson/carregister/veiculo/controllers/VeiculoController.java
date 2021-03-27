package com.okellyson.carregister.veiculo.controllers;

import com.okellyson.carregister.config.GenericController;
import com.okellyson.carregister.veiculo.dtos.VeiculoDTO;
import com.okellyson.carregister.veiculo.interfaces.IVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VeiculoController extends GenericController {

    private static final String BASE_ROUTE = "/veiculos";

    @Autowired
    IVeiculoService veiculoService;

    @GetMapping(value = BASE_ROUTE)
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos() {

        List<VeiculoDTO> veiculos = veiculoService.listar();

        return ok().body(veiculos);

    }

    @PostMapping(value = BASE_ROUTE + "/find")
    public ResponseEntity<List<VeiculoDTO>> listarPorFiltro(@Valid @RequestBody VeiculoDTO filtro) {

        List<VeiculoDTO> veiculos = veiculoService.listar();

        // Devia ser uma query
        if(filtro.getVendido() != null) {
            veiculos = veiculos.stream().filter(v -> v.getVendido().equals(filtro.getVendido())).collect(Collectors.toList());
        }

        return ok().body(veiculos);

    }

    @GetMapping(value = BASE_ROUTE + "/{id}")
    public ResponseEntity<VeiculoDTO> buscar(@PathVariable Integer id) {

        VeiculoDTO veiculo = veiculoService.buscar(id);

        return ok().body(veiculo);

    }

    @PostMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> cadastrar(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        // Método PUT pelo Axios não está funcionando. Medida paliativa, pois não existe tempo hábil para correção
        VeiculoDTO veiculoSalvo = veiculoDTO.getId() == null ? veiculoService.cadastrar(veiculoDTO) : veiculoService.editar(veiculoDTO);

        return ok().body(veiculoSalvo);

    }

    @PutMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> editar(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoEditado = veiculoService.editar(veiculoDTO);

        return ok().body(veiculoEditado);

    }

    @DeleteMapping(value = BASE_ROUTE + "/{id}")
    public ResponseEntity<VeiculoDTO> excluir(@PathVariable Integer id) {

        VeiculoDTO veiculoExcluido = veiculoService.excluir(id);

        return ok().body(veiculoExcluido);

    }

    @PatchMapping(value = BASE_ROUTE)
    public ResponseEntity<VeiculoDTO> vender(@Valid @RequestBody VeiculoDTO veiculoDTO) {

        VeiculoDTO veiculoVendido = veiculoService.vender(veiculoDTO);

        return ok().body(veiculoVendido);

    }
}
