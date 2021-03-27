import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
    {
        path: '/',
        name: 'App',

        component: () => import('@/components/Inicial.vue'),
    },{
        path: '/cadastro',
        name: 'Cadastro',

        component: () => import('@/components/Cadastro.vue'),
    },{
        path: '/edicao/:id',
        name: 'Edicao',

        component: () => import('@/components/Cadastro.vue'),
    },
];

const router = new VueRouter({
    mode: 'hash',
    routes
})

export default router;