<template lang="pug">
.main
  PageTitle(:title="title")
  .container-fluid.bg-white.semi-shadow.flex-grow-1
    .container
      .row
        .col.px-0.px-md-3.px-lg-5.py-4
          slot
</template>

<script>
import PageTitle from "./PageTitle";

export default {
  props: ["title"],

  components: {
    PageTitle
  }
};
</script>
