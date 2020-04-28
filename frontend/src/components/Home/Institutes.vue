<template lang="pug">
  b-container
    b-row.bg-dark.text-white.p-1.rounded
      b-col(cols="4" offset="2")
        .h6.pt-2.text-nowrap.font-weight-normal Список направлений

      b-col(cols="4").py-1
        b-form-input(v-model="text_to_search" placeholder="Поиск по направлениям" size="sm")

    b-row
      b-col.mx-auto.h6.mt-4.text-muted.text-center(v-if="searchPrograms.length == 0") Ничего не найдено

      b-col(cols="6").mt-4.pl-3(v-for="institute in searchPrograms" :key="institute.name")
        .text-theme.h5 {{ institute.name }} <br>
        .pl-3.pb-1(v-for="program in institute.programs" :key="program.id")
          router-link(:to="'curriculum/' + program.id").text-dark {{ program.name }}
        <br>
</template>

<script>
export default {
  data() {
    return {
      text_to_search: ""
    };
  },

  computed: {
    institutes() {
      return this.$store.getters.getInstitutes;
    },

    searchPrograms() {
      if (!this.text_to_search) return this.institutes;

      let result = [];

      for (var institute of this.institutes) {
        var programs = institute.programs.filter(
          program =>
            program.name
              .toLowerCase()
              .indexOf(this.text_to_search.toLowerCase()) >= 0
        );
        if (programs.length)
          result.push({
            name: institute.name,
            programs: programs
          });
      }

      return result;
    }
  }
};
</script>
