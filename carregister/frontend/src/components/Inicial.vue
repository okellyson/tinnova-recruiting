<template lang='pug'>

v-container

    h2 Listagem de veículos cadastrados
    hr

    .col-md-7
        v-simple-table(dense)
            template(v-slot:default)
                thead
                    tr
                        th Carro
                        th Marca
                        th Ano
                        th Vendido
                        th Ações
                tbody
                    tr(v-for="item in veiculos")
                        td {{ item.veiculo }}
                        td {{ item.marca }}
                        td {{ item.ano }}
                        td {{ item.vendido ? "Sim" : "Não"}}
                        td
                            v-btn.ma-2(color="success", @click="editar(item.id)")
                                v-icon(color="white")
                                    | mdi-pencil

                            v-btn.ma-2(color="error", @click="excluir(item.id)")
                                v-icon(color="white")
                                    | mdi-close

                            v-btn.ma-2(color="warning", :disabled="item.vendido", @click="vender(item)")
                                v-icon(color="white")
                                    | mdi-cash-multiple

    hr

    h2(v-if="disponiveis != null") Veículos disponíveis: {{disponiveis}}


    .row(v-if="decadas.length || fabricantes.length")

        hr
        .col-md-3(v-if="decadas.length")
            h3 Veículos por década:
            div(v-for="decada in decadas")
                b {{decada.decada}} -> {{decada.contador}}
                br

        .col-md-3(v-if="fabricantes.length")
            h3 Veículos por fabricante:
            div(v-for="fabricante in fabricantes")
                b {{fabricante.marca}} -> {{fabricante.contador}}
                br

    hr
    v-btn.mt-5(
        color="success"
        @click='cadastrar'
    )
        b Cadastrar

</template>

<script>

    import VeiculoService from '@/services/veiculo.service.js';

    export default {

        name: 'Lista',

        data: () => ({

            disponiveis: null,
            decadas: [],
            veiculos: [],
            fabricantes: [],

        }),

        methods: {

            cadastrar() {
                this.$router.push({name: 'Cadastro'})
            },

            editar(id) {
                this.$router.push({name: 'Edicao', params: { id: id}});
            },

            excluir(id) {

                VeiculoService.excluir(id)
                    .then(() => this.refresh());
            },

            vender(item) {

                VeiculoService.vender(item)
                    .then(() => {

                        this.refresh();
                        window.alert(`O veículo ${item.veiculo} voi vendido com sucesso!`);

                    })
            },

            refresh(){

                VeiculoService.listaVeiculos()
                    .then((response) => {

                        this.veiculos = response.data;

                        this.preparaDados();

                    });

                let filtro = {
                    vendido: false,
                }

                VeiculoService.listaComFiltro(filtro)
                    .then((response) => {

                        this.disponiveis = response.data.length;

                    });
                
                
            },

            preparaDados() {

                this.decadas = [];
                this.fabricantes = [];

                this.veiculos.forEach((v) => {

                    let decada = parseInt(v.ano / 10) * 10;
                    let encontrado = false;

                    for(let i = 0; i < this.decadas.length; i++) {

                        if(this.decadas[i].decada === decada) {
                            this.decadas[i].contador++;
                            encontrado = true;
                        }

                    }

                    if(!encontrado) {
                        this.decadas.push({decada: decada, contador: 1})
                    }

                    encontrado = false;

                    for(let i = 0; i < this.fabricantes.length; i++) {

                        if(this.fabricantes[i].marca === v.marca) {
                            this.fabricantes[i].contador++;
                            encontrado = true;
                        }

                    }

                    if(!encontrado) {
                        this.fabricantes.push({marca: v.marca, contador: 1})
                    }

                })
            }

        },

        mounted() {

            this.refresh();

            for(let i = 1900; i < new Date().getYear(); i += 10){
                this.decadas.push(i);
            }

        }
    }
</script>

<style>



</style>
