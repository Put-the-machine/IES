import Vue from "vue";
import Vuex from "vuex";

import main from "./modules/main";
import user from "./modules/user";
import institute from "./modules/institute";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    main,
    user,
    institute
  }
});
