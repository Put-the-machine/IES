<template lang="pug">
  Wrapper(title="Учебные материалы")
    FilesExplorer(
      :path="path",
      :files="files"
      @open="open"
    )
</template>

<script>
import Wrapper from "../Wrapper";
import FilesExplorer from "./FilesExplorer";

export default {
  data() {
    return {
      path: "Игровые виды спорта/Учебные материалы",

      files: [
        {
          name: "Учебные материалы",
          isFile: false,
          creationDate: "02.04.2020 22:32"
        },
        {
          name: "Контрольные материалы",
          isFile: false,
          creationDate: "02.04.2020 22:32"
        },
        {
          name: "План занятий.docx",
          isFile: true,
          creationDate: "03.04.2020 21:31"
        },
        {
          name: "Критерии экзамена.docx",
          isFile: true,
          creationDate: "03.04.2020 20:13"
        }
      ]
    };
  },

  methods: {
    open(obj) {
      let pathToOpen = this.path + "/" + obj.name;
      alert(pathToOpen);
    }
  },

  components: {
    Wrapper,
    FilesExplorer
  }
};
</script>
