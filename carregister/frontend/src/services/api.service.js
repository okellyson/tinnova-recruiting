import Vue from 'vue';
import axios from 'axios';
import VueAxios from 'vue-axios';

const ApiService = {

    async init() {

        Vue.use(VueAxios, axios);

        Vue.axios.defaults.baseURL = 'http://localhost:8099';
        Vue.axios.defaults.timeout = 300000;

    },

    async query(resource, params) {

        console.log("TOAQUI", params);

        try{
            return await Vue.axios.get(resource, params);
        } catch(erro) {

            const result = { message: this.genericErrorHandling(erro) };
            return Promise.reject(result);
            
        }

    },

    async get(resource, param = '') {

        try{
            return await Vue.axios.get(`${resource}/${param}`);
        }  catch(erro) {

            const result = { message: this.genericErrorHandling(erro) };
            return Promise.reject(result);
            
        }

    },

    async post(resource, params) {

        try {
            return await Vue.axios.post(resource, params);
        } catch (erro) {

            const result = { message: this.genericErrorHandling(erro) };
            return Promise.reject(result);

        }
    },

    async patch (resource, params) {
        try {
            return await Vue.axios.patch(resource, params);
        } catch (erro) {

            const result = { message: this.genericErrorHandling(erro) };
            return Promise.reject(result);

        }
    },

    async put (resource, params) {
        try {
            return await Vue.axios.post(resource, params);
        } catch (error) {
            const result = { message: this.genericErrorHandling(error) };

            return Promise.reject(result);
        }
    },

    async delete (resource, param) {
        try {
            return await Vue.axios.delete(`${resource}/${param}`);
        } catch (error) {
            const result = { message: this.genericErrorHandling(error) };

            return Promise.reject(result);
        }
    },

    genericErrorHandling (erro) {

        let { message } = erro;

        if (erro && erro.response && erro.response.status) {

            switch (erro.response.status) {

                case 401:
                    message = erro.response.data.message;
                    message = '';
                    break;
                case 404:
                    message = erro.response.data.message;
                    break;
                case 500:
                    message = erro.response.data.message;
                    break;
                default:
                    message = erro.response.data.message;
                    break;

            }
        }

        window.alert(`${erro.response.status} - Houve um erro na requisição. ${erro.response.error}.`);

        return message;

    },
}

export default ApiService;