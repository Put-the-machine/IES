<template lang="pug">
  Wrapper(title="Учебный план")
    .pb-3.pl-1.text-secondary(v-if="!logged") Для доступа к учебным материалам, пожалуйста, авторизуйтесь.
    .d-flex.flex-wrap
      .p-1.pr-3 Сортировка:
      b-button-group.flex-wrap(size="sm")
        b-button(variant="outline-primary" :class="{ active: sortBy == 'code' }" @click="sortBy='code'") Код дисциплины
        b-button(variant="outline-primary" :class="{ active: sortBy == 'name' }" @click="sortBy='name'") Название дисциплины
        b-button(variant="outline-primary" :class="{ active: sortBy == 'number' }" @click="sortBy='number'") Номер семестра

    table.table.table-responsive.table-hover.mt-3
      thead
        tr.thead-dark
          th.font-weight-normal Код
          th.font-weight-normal Название
          th.font-weight-normal Семестр
          th.font-weight-normal.text-nowrap Часы лекций / практики

      tbody
        tr(
          v-for="subject in sortedSubjects"
          :key="subject.id"
        )
          td {{ subject.id }}

          td
            router-link(
              :to="'subject/' + subject.id"
              v-if="logged"
            ) {{ subject.name }}

            span(v-else) {{ subject.name }}

          td {{ subject.numSem }}

          td {{ subject.hours }}
</template>

<script>
import Wrapper from "../Wrapper";

export default {
  created: function() {
    window.scrollTo(0, 0);
  },

  data() {
    return {
      sortBy: "code",
      subjects: [
        {
          id: 1,
          name: "Игровые виды спорта",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 2,
          name: "Программирование",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 3,
          name: "Разработка WEB-документов",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 4,
          name: "История",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 5,
          name: "Алгебра логики",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 6,
          name:
            "Современные технологии объектно-ориентированного программирования",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 7,
          name:
            "Межкультурная и профессиональная коммуникация на иностранном языке",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 8,
          name: "Теория вероятностей и математическая статистика",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 9,
          name: "Базы жанных",
          numSem: 1,
          hours: "64 / 64"
        },
        {
          id: 10,
          name: "Разработка и анализ требований",
          numSem: 1,
          hours: "64 / 64"
        }
      ]
    };
  },

  computed: {
    logged() {
      return this.$store.getters.isLogged;
    },

    sortedSubjects() {
      if (this.sortBy == "code") {
        return [...this.subjects].sort((a, b) => a.id - b.id);
      } else if (this.sortBy == "name") {
        return [...this.subjects].sort((a, b) => a.name.localeCompare(b.name));
      } else {
        return [...this.subjects].sort((a, b) => a.numSem - b.numSem);
      }
    }
  },

  components: {
    Wrapper
  }
};
</script>
