export default {
  state: {
    pageTitle: "Информационно-образовательная среда СГТУ им. Гагарина"
  },
  actions: {
    pageTitle({ commit }, title) {
      commit("pageTitle", title);
    }
  },
  mutations: {
    pageTitle(state, title) {
      state.pageTitle = title;
    }
  },
  getters: {
    pageTitle(state) {
      return state.pageTitle;
    }
  }
};
