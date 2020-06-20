import Axios from "axios";
import Querystring from "query-string";
import jsog from "jsog";

const nullUser = {
  id: -1,
  authorities: null,
  email: "",
  fullName: "",
  year: null,
  username: null
};

export default {
  state: {
    is_logged: false,
    user: nullUser
  },

  actions: {
    async auth({ commit }, form) {
      const baseUrl = "/";

      try {
        await Axios.post(
          baseUrl + "login",
          Querystring.stringify({
            username: form.login,
            password: form.password
          }),
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            withCredentials: true
          }
        );
      } catch {
        console.log("404 after login");
      } finally {
        let userdata = null;

        await Axios.get(baseUrl + "who-am-i", {
          withCredentials: true
        }).then(response => {
          userdata = jsog.decode(response.data);
        });

        await Axios.get(baseUrl + "students/" + userdata.id + "/groups", {
          withCredentials: true
        }).then(response => (userdata.groups = jsog.decode(response.data)));

        commit("autorize", userdata);
      }
    },

    async logout({ commit }) {
      try {
        await Axios.get("/logout", {
          withCredentials: true
        });
      } catch {
        console.log("404 after logout");
      }

      commit("logout");
    }
  },

  mutations: {
    autorize(state, user) {
      state.is_logged = true;
      state.user = user;
    },

    logout(state) {
      state.user = nullUser;
      state.is_logged = false;
    }
  },

  getters: {
    isLogged(state) {
      return state.is_logged;
    },

    user(state) {
      return state.user;
    },

    user_role(state) {
      return state.user.authorities
        ? state.user.authorities[0].toLowerCase()
        : "";
    }
  }
};
