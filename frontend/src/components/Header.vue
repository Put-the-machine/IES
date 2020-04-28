<template lang="pug">
  #header.semi-shadow.sticky-top
    b-navbar(type="light" variant="white")
      b-navbar-brand(href="#")
        router-link(to="/")
          b-img.logo(:src="logo")

      b-navbar-nav
        b-nav-item(
          v-for="item in nav_items"
          :key="item.name"
          :to="item.link"
          :class="{ active: navActiveLink == item.link }"
        ) {{ item.name }}
      
      b-navbar-nav.ml-auto
        UserDropdown(v-if="logged")
        LoginDropdown(v-else)
</template>

<script>
import UserDropdown from "./UserDropdown";
import LoginDropdown from "./LoginDropdown";
import Logo from "../assets/img/logo.png";

export default {
  props: ["logged", "user"],

  components: {
    UserDropdown,
    LoginDropdown
  },

  data() {
    return {
      logo: Logo,

      nav_dict: {
        "": [{ name: "Главная", link: "/" }],

        student: [
          { name: "Главная", link: "/" },
          { name: "Сообщения", link: "/messages" }
        ],

        teacher: [
          { name: "Главная", link: "/" },
          { name: "Сообщения", link: "/t-messages" },
          { name: "Мои дисциплины", link: "/t-courses" }
        ],

        manager: [
          { name: "Главная", link: "/" },
          { name: "Учебный план", link: "/manage-curriculum" }
        ],

        administrator: [
          { name: "Главная", link: "/" },
          { name: "Регистрация", link: "/registration" },
          { name: "Институты", link: "/institutes" },
          { name: "Направления", link: "/courses" },
          { name: "Кафедры", link: "/departments" },
          { name: "Пользователи", link: "/users" }
        ]
      }
    };
  },

  computed: {
    nav_items: function() {
      return this.nav_dict[this.user.role];
    },

    navActiveLink: function() {
      return this.$store.getters.navActiveLink;
    }
  }
};
</script>

<style lang="stylus" scoped>
#header
  border-top 0.2rem solid #046cc1

.logo
  width 9rem
</style>
