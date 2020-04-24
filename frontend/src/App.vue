<template lang="pug">
  #app.d-flex.flex-column
    Header(:logged="is_logged", :user="user")
    
    PageTitle(title="Информационно-образовательная среда СГТУ им. Гагарина")
    .container-fluid.bg-white.semi-shadow.flex-grow-1
      .container
        .row
          .col.px-5.py-4
            Home 
    Footer.footer
</template>

<script>
import Header from "./components/Header.vue";
import PageTitle from "./components/PageTitle";
import Home from "./components/Home/Home.vue";
import Footer from "./components/Footer.vue";

export default {
  name: "App",
  data() {
    return {};
  },

  computed: {
    is_logged: function() {
      return this.$store.state.is_logged;
    },

    user: function() {
      return this.$store.state.user;
    }
  },

  components: {
    Header,
    PageTitle,
    Home,
    Footer
  }
};
</script>

<style lang="stylus">
body
  background-color #efefef

.semi-shadow
  box-shadow 0 0 0.35rem 0 rgba(0, 0, 0, 0.1)

.text-theme
  color #046cc1

.bg-theme
  background-color #046cc1

#app
  min-height 100vh
  min-width 960px
</style>
