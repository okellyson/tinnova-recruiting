package com.okellyson.carregister.veiculo.services;

import com.okellyson.carregister.config.GenericService;
import com.okellyson.carregister.marca.interfaces.IMarcaService;
import com.okellyson.carregister.marca.models.Marca;
import com.okellyson.carregister.marca.repositories.MarcaRepository;
import com.okellyson.carregister.util.Mensagem;
import com.okellyson.carregister.veiculo.dtos.VeiculoDTO;
import com.okellyson.carregister.veiculo.interfaces.IVeiculoService;
import com.okellyson.carregister.veiculo.models.Veiculo;
import com.okellyson.carregister.veiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService extends GenericService implements IVeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    IMarcaService marcaService;

    @Override
    public List<VeiculoDTO> listar() {

        return veiculoRepository.findAll()
                .stream().map(v -> new VeiculoDTO().parse(v))
                .collect(Collectors.toList());

    }

    @Override
    public VeiculoDTO buscar(Integer id) {

        return new VeiculoDTO().parse(getVeiculo(id));

    }

    @Override
    public VeiculoDTO cadastrar(VeiculoDTO veiculoDTO) {

        Marca entidadeMarca = marcaService.getByNome(veiculoDTO.getMarca());

        notIfNull(entidadeMarca, Mensagem.MARCA_NAO_ENCONTRADA);

        Veiculo veiculo = new Veiculo.VeiculoBuilder()
                .setModelo(veiculoDTO.getVeiculo())
                .setDescricao(veiculoDTO.getDescricao())
                .setMarca(entidadeMarca)
                .setAno(veiculoDTO.getAno())
                .setVendido(veiculoDTO.getVendido())
                .build();

        veiculoRepository.save(veiculo);

        return new VeiculoDTO().parse(veiculo);

    }

    @Override
    public VeiculoDTO editar(VeiculoDTO veiculoDTO) {

        Veiculo veiculo = getVeiculo(veiculoDTO.getId());

        veiculo.setModelo(veiculoDTO.getVeiculo());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setDescricao(veiculoDTO.getDescricao());

        Marca novaMarca = marcaService.getByNome(veiculoDTO.getMarca());
        notIfNull(novaMarca, Mensagem.MARCA_NAO_ENCONTRADA);

        veiculo.setMarca(novaMarca);

        veiculo.setUpdated(new Date());

        veiculoRepository.save(veiculo);

        return new VeiculoDTO().parse(veiculo);

    }

    @Override
    public VeiculoDTO excluir(VeiculoDTO veiculoDTO) {

        Veiculo veiculoSalvo = getVeiculo(veiculoDTO.getId());
        veiculoRepository.delete(veiculoSalvo);

        return veiculoDTO;

    }

    @Override
    public VeiculoDTO vender(VeiculoDTO veiculoDTO) {

        Veiculo veiculo = getVeiculo(veiculoDTO.getId());

        veiculo.setVendido(true);
        veiculo.setUpdated(new Date());

        veiculoRepository.save(veiculo);

        return new VeiculoDTO().parse(veiculo);

    }

    private Veiculo getVeiculo(Integer id) {

        Veiculo veiculo = veiculoRepository.findById(id).orElse(null);

        notIfNull(veiculo, Mensagem.VEICULO_NAO_ENCONTRADO);

        return veiculo;

    }
}
