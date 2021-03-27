import ApiService from './api.service';

const baseURL = '/veiculos';

export default {

    listaVeiculos: async () => ApiService.query(baseURL),

    listaComFiltro: async (filtro) => ApiService.post(baseURL + "/find", filtro),

    buscarVeiculo: async (id) => ApiService.get(baseURL, id),

    cadastrar: async (veiculo) => ApiService.post(baseURL, veiculo),

    editar: async (veiculo) => ApiService.put(baseURL, veiculo),

    vender: async (veiculo) => ApiService.patch(baseURL, veiculo),

    excluir: async (id) => ApiService.delete(baseURL, id)

};