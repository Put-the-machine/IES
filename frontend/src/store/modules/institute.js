import Axios from "axios";
import Querystring from "query-string";
import jsog from "jsog";

export default {
  state: {
    institutes: []
  },

  actions: {
    async load_full_info({ commit }) {
      try {
        await Axios.post(
          "http://localhost:8079/login",
          Querystring.stringify({
            username: "student",
            password: "password"
          }),
          {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded"
            }
          }
        );
      } catch {
        console.log("404 after login");
      }

      await Axios.get(
        "http://localhost:8079/institutes/full_department_info"
      ).then(response => commit("institutes", jsog.decode(response.data)));
    }
  },

  mutations: {
    institutes(state, institutes) {
      state.institutes = institutes;
    }
  },

  getters: {
    getInstitutes(state) {
      return state.institutes;
    }
  }
};
