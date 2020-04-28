<template lang="pug">
  #app.d-flex.flex-column.justify-content-between
    .top
      Header(:logged="is_logged", :user="user")
    
      router-view

    Footer
</template>

<script>
import Header from "./components/Header";
import Wrapper from "./components/Wrapper";
import Footer from "./components/Footer";

export default {
  data() {
    return {};
  },

  computed: {
    is_logged: function() {
      return this.$store.getters.isLogged;
    },

    user: function() {
      return this.$store.getters.user;
    }
  },

  components: {
    Header,
    Wrapper,
    Footer
  }
};
</script>

<style lang="stylus">

body
  background-color #efefef

#app
  min-height 100vh

.semi-shadow
  box-shadow 0 0 0.35rem 0 rgba(0, 0, 0, 0.1)

.text-theme
  color #046cc1

.bg-theme
  background-color #046cc1

.b-dropdown-form:focus
  outline none !important

.pointer
  cursor pointer
</style>
