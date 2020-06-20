<template lang="pug">
  .wrapper
    span / 
    span.text-primary {{ studyPlanSubject.subject.name }}
    table.table.table-responsive.table-hover.border.mt-2.d-md-block.d-md-table
      thead
        tr.thead-dark
          th.font-weight-normal Название
          th.font-weight-normal Тип
          th.font-weight-normal Преподаватель
          th.font-weight-normal Часы
      
      tbody.pointer
        tr(v-if="subjectGroups.length == 0")
            td(colspan="4")
              .text-muted.text-center Ничего не найдено

        tr(
          v-for="subjectGroup in subjectGroups"
          :key="subjectGroup.id"
          @click="$emit('open', subjectGroup)"
        ).text-nowrap
          td
            b-icon-folder-fill(
              variant="primary"
            )

            span.ml-2 {{ subjectGroup.name }}

          td {{ subjectGroup.type.replace("PRACTICE", "Практика").replace("LECTURE", "Лекция") }}
          td {{ subjectGroup.teacher ? subjectGroup.teacher.fullName : "Неизвестно" }}
          td {{ subjectGroup.hours }}
</template>

<script>
import { BIconFolderFill } from "bootstrap-vue";

export default {
  props: ["subjectGroups", "studyPlanSubject"],

  components: {
    BIconFolderFill
  }
};
</script>
