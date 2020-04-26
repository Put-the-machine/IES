<template lang="pug">
.wrapper
  .d-flex
    .p-1.pr-3 Сортировка:
    b-button-group(size="sm")
      b-button(variant="outline-primary" :class="{ active: sortBy == 'code' }" @click="sortBy='code'") Код дисциплины
      b-button(variant="outline-primary" :class="{ active: sortBy == 'name' }" @click="sortBy='name'") Название дисциплины
      b-button(variant="outline-primary" :class="{ active: sortBy == 'number' }" @click="sortBy='number'") Номер семестра

  b-table.mt-2(hover :items="sortedSubjects" head-variant="dark")
    template(v-slot:cell(Название)="data")
      router-link(:to="'subject/' + data.value.code" v-if="logged") {{ data.value.name }}
      span(v-else) {{ data.value.name }}
</template>

<script>
export default {
  data() {
    return {
      curriculum_area: "Программная инженерия",
      sortBy: "code",
      subjects: [
        {
          Код: 1,
          Название: {
            name: "Игровые виды спорта",
            code: 1
          },
          Семестр: 2,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 2,
          Название: {
            name: "Программирование",
            code: 2
          },
          Семестр: 1,
          "Кол-во часов лекций / практики": "144 / 144"
        },
        {
          Код: 3,
          Название: {
            name: "Разработка WEB-документов",
            code: 3
          },
          Семестр: 1,
          "Кол-во часов лекций / практики": "80 / 80"
        },
        {
          Код: 4,
          Название: {
            name: "История",
            code: 4
          },
          Семестр: 1,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 5,
          Название: {
            name: "Алгебра логики",
            code: 5
          },
          Семестр: 4,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 6,
          Название: {
            name:
              "Современные технологии объектно-ориентированного программирования",
            code: 6
          },
          Семестр: 3,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 7,
          Название: {
            name:
              "Межкультурная и профессиональная коммуникация на иностранном языке",
            code: 7
          },
          Семестр: 2,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 8,
          Название: {
            name: "Теория вероятностей и математическая статистика",
            code: 8
          },
          Семестр: 4,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 9,
          Название: {
            name: "Базы данных",
            code: 9
          },
          Семестр: 3,
          "Кол-во часов лекций / практики": "32 / 32"
        },
        {
          Код: 10,
          Название: {
            name: "Разработка и анализ требований",
            code: 10
          },
          Семестр: 2,
          "Кол-во часов лекций / практики": "32 / 32"
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
        return [...this.subjects].sort((a, b) => a.Код - b.Код);
      } else if (this.sortBy == "name") {
        return [...this.subjects].sort((a, b) =>
          a.Название.name.localeCompare(b.Название.name)
        );
      } else {
        return [...this.subjects].sort((a, b) => a.Семестр - b.Семестр);
      }
    }
  },

  mounted() {
    this.$store.dispatch("pageTitle", this.curriculum_area);
  }
};
</script>
