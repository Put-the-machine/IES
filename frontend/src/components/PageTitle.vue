<template lang="pug">
    h3.font-weight-light.text-nowrap.text-center.py-4 {{ title }}
</template>

<script>
export default {
  computed: {
    title: function() {
      return this.$store.getters.pageTitle;
    }
  }
};
</script>
