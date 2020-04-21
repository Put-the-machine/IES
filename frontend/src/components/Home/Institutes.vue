<template lang="pug">
b-container
  b-row.bg-dark.text-white.p-1.rounded
    b-col(cols="4" offset="2")
      .h6.pt-2.text-nowrap.font-weight-normal Список направлений
    b-col(cols="4").py-1
      b-form-input(v-model="text_to_search" placeholder="Поиск по направлениям" size="sm")
  b-row
    b-col.mx-auto.h6.mt-4.text-muted.text-center(v-if="institutes_to_show.length == 0") Ничего не найдено
    b-col(cols="6").mt-4.pl-3(v-for="institute in institutes_to_show" :key="institute.name")
      .text-theme.h5 {{ institute.name }} <br>
      b-link.pl-3.py-2(v-for="program in institute.programs" :key="program.id")
        b-link.text-dark {{ program.name }} <br>
    
</template>

<script>
export default {
  name: "Institutes",
  data() {
    return {
      text_to_search: "",
      institutes: [
        {
          name: "ИнПИТ",
          programs: [
            { id: 0, name: "Программная инженерия" },
            { id: 1, name: "Информатика и вычислительная техника" },
            { id: 2, name: "Прикладная информатика" },
            { id: 3, name: "Реклама" },
            { id: 4, name: "Дизайн" },
            { id: 5, name: "Информационная безопасность" }
          ]
        },
        {
          name: "АутПИТ",
          programs: [
            { id: 6, name: "Истерика программистов" },
            { id: 7, name: "Апатия разработчиков" },
            { id: 8, name: "Депрессия фронтендеров" },
            { id: 9, name: "Комментирование некомментиуемого" },
            { id: 10, name: "JavaScript-комьюнити беспощадно" }
          ]
        },
        {
          name: "Ну и еще для теста",
          programs: [
            { id: 11, name: "Искусство изучения десятки технологий за ночь" },
            { id: 12, name: "Мастерство не умереть после этого" },
            { id: 13, name: "Чертова самоизоляция" },
            { id: 14, name: "Как я тебя ненавижу" },
            { id: 15, name: "Пойду я спать" }
          ]
        }
      ]
    };
  },
  computed: {
    institutes_to_show: function() {
      if (!this.text_to_search) return this.institutes;

      var to_show = [];
      for (var institute of this.institutes) {
        var programs = institute.programs.filter(
          program =>
            program.name
              .toLowerCase()
              .indexOf(this.text_to_search.toLowerCase()) >= 0
        );
        if (programs.length)
          to_show.push({
            name: institute.name,
            programs: programs
          });
      }

      return to_show;
    }
  }
};
</script>
