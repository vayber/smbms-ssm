import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from "./router/index.js"
import toast from "./components/toast/index.js"

Vue.use(ElementUI);
Vue.config.productionTip = false
//注册全局使用$toast
Vue.use(toast)

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
