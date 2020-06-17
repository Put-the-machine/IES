<template lang="pug">
  b-nav-item-dropdown.m-2(:text="user.fullName" ref='dropdown' size="sm" right)
    b-dropdown-header {{ user.username }}
    b-dropdown-item-button(@click="logout()") Выйти
</template>

<script>
export default {
  data() {
    return {};
  },

  computed: {
    user() {
      return this.$store.getters.user;
    }
  },

  methods: {
    logout() {
      this.$store.dispatch("logout", this.user.id);
      this.$router.push("/");
    }
  }
};
</script>
