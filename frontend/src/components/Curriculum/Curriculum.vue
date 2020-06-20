<template lang="pug">
  b-overlay(:show="!courseProfile.name")
    Wrapper(:title="courseProfile.name")
      .pb-3.pl-1.text-secondary(v-if="!logged") Для доступа к учебным материалам, пожалуйста, авторизуйтесь.
      .d-flex.flex-wrap.flex-column.flex-md-row
        .sort.d-flex.flex-column.flex-md-row.ml-0.ml-lg-3.mt-3.mt-lg-0
          .p-1.pr-3 Сортировка:
          b-button-group(size="sm").d-none.d-md-flex
            b-button(variant="outline-primary" :class="{ active: sortBy == 'name' }" @click="sortBy='name'") Название дисциплины
            b-button(variant="outline-primary" :class="{ active: sortBy == 'semester' }" @click="sortBy='semester'") Номер семестра
          
          b-button-group(size="sm" vertical).d-md-none
            b-button(variant="outline-primary" :class="{ active: sortBy == 'name' }" @click="sortBy='name'") Название дисциплины
            b-button(variant="outline-primary" :class="{ active: sortBy == 'semester' }" @click="sortBy='semester'") Код дисциплины

      table.table.table-hover.mt-3
        thead.min-w-100
          tr.thead-dark
            th.font-weight-normal Код
            th.font-weight-normal Название
            th.font-weight-normal Семестр

        tbody
          tr(v-if="studyPlanSubjects.length == 0")
            td(colspan="2")
              .text-muted.text-center Ничего не найдено

          tr(
            v-for="subject in studyPlanSubjects"
            :key="subject.id"
          )
            td {{ subject.subject.id }}

            td
              router-link(
                :to="'subject/' + subject.id"
                v-if="logged"
              ) {{ subject.subject.name }}
            
              span(v-else) {{ subject.subject.name }}
            
            td {{ subject.semester }}
</template>

<script>
import Wrapper from "../Wrapper";

export default {
  created: function() {
    window.scrollTo(0, 0);
  },

  mounted() {
    this.courseProfile.id = this.$route.params.id;

    this.loadCourseProfileInfo();
    this.loadStudyPlanSubjects();

    this.$store.dispatch("navActiveLink", "/studyplan");
  },

  data() {
    return {
      courseProfile: {
        id: null,
        name: null
      },

      sortBy: "name",

      studyPlanSubjects: []
    };
  },

  methods: {
    async loadCourseProfileInfo() {
      await this.$http
        .get("/course_profiles/" + this.courseProfile.id)
        .then(
          response => (this.courseProfile = this.$jsog.decode(response.data))
        );
    },

    async loadStudyPlanSubjects() {
      await this.$http
        .get(
          "/courses/" +
            this.courseProfile.id +
            "/study_plan_subjects"
        )
        .then(
          response =>
            (this.studyPlanSubjects = this.$jsog.decode(response.data))
        );
    }
  },

  computed: {
    logged() {
      return this.$store.getters.isLogged;
    },

    user() {
      return this.$store.getters.user;
    },

    sortedSubjects() {
      if (this.sortBy == "semester") {
        return [...this.studyPlanSubjects].sort((a, b) => a.id - b.id);
      } else {
        return [...this.studyPlanSubjects].sort((a, b) =>
          a.name.localeCompare(b.name)
        );
      }
    }
  },

  components: {
    Wrapper
  }
};
</script>
