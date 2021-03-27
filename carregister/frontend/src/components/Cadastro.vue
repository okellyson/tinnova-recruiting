<template lang='pug'>

v-container

    h2 Cadastrar veículo

    .col-md-6
        v-text-field(
            label = "Veículo",
            v-model="model.veiculo",
            dense,
            outlined
            )

        .row
            .col-md-8
                v-text-field(
                    label="Marca",
                    v-model="model.marca"
                    dense,
                    outlined
                    )

            .col-md-4
                v-text-field(
                    label="Ano",
                    v-model="model.ano"
                    dense,
                    outlined
                    )

        v-text-field(
            label="Descrição",
            v-model="model.descricao",
            outlined
            )

    v-btn(
        color="success"
        @click='cadastrar'
    )
        b Cadastrar

    v-btn.ml-2(
        color="success"
        @click='voltar'
    )
        b Voltar

</template>

<script>

    import VeiculoService from '@/services/veiculo.service.js';

    export default {

        name: 'Cadastro',

        data: () => ({

            cadastro: true,
            disponiveis: null,
            model: {
                id: null,
                veiculo: null,
                marca: null,
                ano: null,
                descricao: null,
            },

        }),

        methods: {

            cadastrar() {

                if(this.cadastro) {

                    VeiculoService.cadastrar(this.model)
                        .then(() => {

                            this.$router.back();

                        })
                        .catch(() => {
                            window.alert("Ocorreu um erro.");
                        });

                } else {

                    VeiculoService.editar(this.model)
                        .then(() => {

                            this.$router.back();

                        })
                        .catch(() => {
                            window.alert("Ocorreu um erro.");
                        });

                }

            },

            voltar() {
                this.$router.back();
            },

            setModel(veiculo) {
                this.model = veiculo;
            }
        },

        mounted() {

            this.cadastro = !!this.$route.params.id;

            if(this.cadastro) {

                VeiculoService.buscarVeiculo(this.$route.params.id)
                    .then((response) => {

                        this.model = response.data;

                    })
            }

        }
    }
</script>

<style>

</style>
