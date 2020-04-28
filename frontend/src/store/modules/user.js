export default {
  state: {
    is_logged: false,
    user: {
      id: null,
      fullname: "",
      role: ""
    }
  },

  actions: {
    auth({ commit }, form) {
      let request = {
        POST: {
          url: "/api/users.login",
          data: form
        }
      };

      alert(JSON.stringify(request, null, "    "));

      commit("autorize", {
        id: 1,
        fullname: "Имя Фамилия",
        role: "student"
      });
    },

    logout({ commit }, id) {
      let request = {
        POST: {
          url: "/api/users.logout",
          data: {
            id
          }
        }
      };

      alert(JSON.stringify(request, null, "    "));
      commit("logout");
    }
  },

  mutations: {
    autorize(state, user) {
      state.is_logged = true;
      state.user = user;
    },

    logout(state) {
      state.user.fullname = "";
      state.user.role = "";
      state.is_logged = false;
    }
  },

  getters: {
    isLogged(state) {
      return state.is_logged;
    },

    user(state) {
      return state.user;
    }
  }
};
