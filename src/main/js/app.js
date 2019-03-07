import Vue from 'vue';
import App from './components/App.vue'

var app = new Vue({
    render: h => h(App)
}).$mount('#app');
