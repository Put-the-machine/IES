<template lang="pug">
  .wrapper
    .nav-path
      span.nav-path(
        v-for="pathItem in path"
      )
        span  / 
        span(
          :class="{'text-primary': path.indexOf(pathItem) == path.length - 1}"
          @click="$emit('open', pathItem.path, isFile=false, '')"
        ).pointer {{ pathItem.name }}

    table.table.table-hover.border.mt-2
      thead
        tr.thead-dark
          th.font-weight-normal Название
          th.font-weight-normal Дата
      
      tbody.pointer
        tr(v-if="files.length == 0")
          td(colspan="2")
            .text-muted.text-center Ничего не найдено

        tr(
          v-for="file in sortedFiles"
          :key="file.name"
          @click="$emit('open', current_path + '/' + file.name, file.isFile, file.id, file.name)"
        ).file-item
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

          td
            span {{ ISOToLocale(file.creationTime)[0] }}
            span.time  {{ ISOToLocale(file.creationTime)[1] }}
</template>

<script>
import { BIconFileEarmarkText } from "bootstrap-vue";
import { BIconFolderFill } from "bootstrap-vue";

export default {
  props: ["path", "files"],

  components: {
    BIconFileEarmarkText,
    BIconFolderFill
  },

  computed: {
    current_path() {
      return this.path[this.path.length - 1].path;
    },

    filesToShow() {
      return this.files.filter(
        file =>
          file.virtualPath ==
          this.current_path
            .split("/")
            .slice(2)
            .join("/")
      );
    },

    sortedFiles() {
      return [...this.filesToShow].sort((a, b) => {
        if (a.isFile == b.isFile) {
          return a.name > b.name;
        }

        return a.isFile - b.isFile;
      });
    }
  },

  methods: {
    ISOToLocale(date_string) {
      let date = new Date(date_string);
      return [
        date.toLocaleDateString(),
        date
          .toLocaleTimeString()
          .split(":")
          .slice(0, 2)
          .join(":")
      ];
    }
  }
};
</script>

<style lang="stylus" scoped>
.time
  visibility hidden

.file-item:hover .time
  visibility visible
</style>
