import "@babel/polyfill";
import "mutationobserver-shim";
import Vue from "vue";
import "./plugins/bootstrap-vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";
import VueCookies from "vue-cookies";
import jsog from "jsog";

axios.defaults.withCredentials = true;
Vue.prototype.$http = axios;

Vue.config.productionTip = false;

Vue.prototype.$jsog = jsog;

Vue.use(VueCookies);
Vue.$cookies.config("1y");

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
