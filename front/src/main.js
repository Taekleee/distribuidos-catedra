import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import VueRouter from 'vue-router'
import Hello from './components/HelloWorld'
import Form from './components/Form'
import Alert from './components/Alert'
Vue.use(VueRouter)

Vue.config.productionTip = false
Vue.config.silent = true

const routes = [
  { path: '/inicio', component: Hello },
  { path: '/form', component: Form },
  { path: '/creado', component: Alert}

]

// Create the router instance and pass the `routes` option
// You can pass in additional options here, but let's
// keep it simple for now.
const router = new VueRouter({
  routes, // short for routes: routes
  mode: 'history'
})
//instatinat the vue instance

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
