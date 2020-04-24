import Vue from "vue";
import Vuex from "vuex";
import institute from "./modules/institute";
import user from "./modules/user";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    institute,
    user
  }
});
