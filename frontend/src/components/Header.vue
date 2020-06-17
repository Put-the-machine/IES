<template lang="pug">
  #header.semi-shadow.sticky-top
    b-navbar(
      type="light"
      variant="white"
      toggleable="lg"
    )
      b-navbar-brand(href="#")
        router-link(to="/")
          b-img.logo(:src="logo")

      b-navbar-toggle(
        target="nav-collapse"
      )

      b-collapse#nav-collapse(is-nav)
        b-navbar-nav(
            v-for="item in nav_items"
            :key="item.name"
        )
          b-nav-item(
            v-if="!item.is_dropdown"
            :to="item.link"
            :class="{ active: navActiveLink == item.link }"
          ) {{ item.name }}

          b-nav-item-dropdown.m-2(
            v-else
            text="Учебный план"
            ref='dropdown'
            size="sm"
            :class="{ active: navActiveLink == '/studyplan' }"
          )
            b-dropdown-item(
              v-for="group in user.groups"
              :key="group.id"
              :to="'/curriculum/' + group.courseProfile.id"
            ) {{ group.name }}
        
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
      logo: Logo
    };
  },

  computed: {
    user_role: function() {
      return this.$store.getters.user_role;
    },

    nav_items: function() {
      let nav_dict = {
        "": [{ name: "Главная", link: "/" }],

        student: [
          { name: "Главная", link: "/" },
          { name: "Учебный план", link: "/studyplan" },
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
      };

      if (this.user_role === "student") {
        nav_dict.student[1].is_dropdown = true;
        nav_dict.student[1].items = this.user.groups;
      }

      return nav_dict[this.user_role];
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
