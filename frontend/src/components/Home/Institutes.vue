<template lang="pug">
  b-overlay(:show="!full_info.length")
    b-container
      b-row.bg-dark.text-white.p-1.rounded
        b-col(cols="12" md="6" lg="4" offset="0" offset-lg="2")
          .h6.pt-1.pt-md-2.text-nowrap.font-weight-normal Профили обучения

        b-col(cols="12" md="6" lg="4").pb-1.pt-0.pt-md-1
          b-form-input(v-model="text_to_search" placeholder="Поиск по профилям" size="sm")

      b-row
        b-col(cols="12" lg="6").mx-auto.mt-4.text-muted.text-center(v-if="filtered_profiles.length == 0") Ничего не найдено

        b-col.mt-3(cols="12" lg="6" v-for="institute in filtered_profiles" :key="institute.id")
          .h5.text-primary {{ institute.name }}

          div(v-for="department in institute.departments" :key="department.id")

            div.ml-3(v-for="course in department.courses" :key="course.id")
              .text-dark {{ course.name }}

              div.ml-3(
                v-for="courseProfile in course.courseProfiles"
                :key="courseProfile.id"
              )
                router-link(
                  v-if="!courseProfile.default"
                  :to="'/curriculum/' + courseProfile.id"
                ).text-primary {{ courseProfile.name }}
</template>

<script>
export default {
  data() {
    return {
      text_to_search: ""
    };
  },

  computed: {
    full_info() {
      return this.$store.getters.getInstitutes;
    },

    filtered_profiles() {
      if (!this.text_to_search) return this.full_info;

      let result = [];

      for (let institute of this.full_info) {
        let ds = [];

        if (institute.departments) {
          for (let department of institute.departments) {
            let cs = [];

            if (department.courses) {
              for (let course of department.courses) {
                if (course.courseProfiles) {
                  let cps = course.courseProfiles.filter(
                    cp =>
                      cp.name
                        .toLowerCase()
                        .indexOf(this.text_to_search.toLowerCase()) >= 0
                  );

                  if (cps.length) {
                    cs.push({
                      name: course.name,
                      courseProfiles: cps
                    });
                  }
                }
              }
            }

            if (cs.length) {
              ds.push({
                name: department.name,
                courses: cs
              });
            }
          }
        }

        if (ds.length) {
          result.push({
            name: institute.name,
            departments: ds
          });
        }
      }

      return result;
    }
  }
};
</script>
