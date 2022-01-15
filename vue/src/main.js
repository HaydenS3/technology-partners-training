import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

//How does this work?
new Vue({
  render: h => h(App),
}).$mount('#app')
