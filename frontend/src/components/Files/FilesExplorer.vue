<template lang="pug">
  .wrapper
    .nav-path
      span.nav-path(
        v-for="navPathItem in navPathItems"
      )
        span  / 
        b-link(:class="[ navPathItem == activePathItem ? '' : 'text-muted' ]") {{ navPathItem }}

    table.table.table-hover.border.mt-2
      thead
        tr.thead-dark
          th.font-weight-normal
            span Название
          th.font-weight-normal Время создания
      
      tbody.pointer
        tr(
          v-for="file in files"
          :key="file.name"
          @click="$emit('open', file)"
        )
          td
            b-icon-file-earmark-text(
              v-if="file.isFile"
              variant="info"
            )

            b-icon-folder-fill(
              v-else
              variant="primary"
            )

            span.ml-2 {{ file.name }}

          td {{ file.creationDate }}
</template>

<script>
import { BIconFileEarmarkText } from "bootstrap-vue";
import { BIconFolderFill } from "bootstrap-vue";

export default {
  props: ["path", "files"],

  computed: {
    navPathItems: function() {
      return this.path.split("/");
    },

    activePathItem: function() {
      return this.navPathItems[this.navPathItems.length - 1];
    }
  },

  components: {
    BIconFileEarmarkText,
    BIconFolderFill
  }
};
</script>
