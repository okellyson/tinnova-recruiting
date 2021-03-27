import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import ApiService from './services/api.service';
import router from './router';

Vue.config.productionTip = false


ApiService.init()
	.then(() => {

		new Vue({
			vuetify,
			router,
			render: h => h(App)
		}).$mount('#app');
	});