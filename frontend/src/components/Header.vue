<template lang="pug">
#header.semi-shadow.sticky-top
  b-navbar(type="light" variant="white")
    b-navbar-brand(href="#")
      router-link(to="/")
        b-img.logo(:src="logo")

    b-navbar-nav
      b-nav-item(active to="/") Главная
    
    b-navbar-nav.ml-auto
      LoginDropdown

</template>

<script>
import LoginDropdown from "./LoginDropdown.vue";
import Logo from "../assets/img/logo.png";

export default {
  name: "Header",
  props: ["logged", "user"],
  components: {
    LoginDropdown
  },
  data() {
    return {
      logo: Logo
    };
  }
};
</script>

<style lang="stylus" scoped>
#header
  border-top 0.2rem solid #046cc1

.logo
  width 9rem
</style>
