export default {
  state: {
    navActiveLink: "/"
  },

  actions: {
    navActiveLink({ commit }, link) {
      commit("navActiveLink", link);
    }
  },

  mutations: {
    navActiveLink(state, link) {
      state.navActiveLink = link;
    }
  },

  getters: {
    navActiveLink(state) {
      return state.navActiveLink;
    }
  }
};
