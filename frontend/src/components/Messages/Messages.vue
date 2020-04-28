<template lang="pug">
  Wrapper(title="Отправка сообщений")
    b-form
      b-form-select(
        v-model="toTeacherId"
        :options="teachers"
      )

      b-form-textarea.mt-3(
        v-model="message"
        placeholder="Введите текст сообщения"
        rows="8"
      )

      b-form-file.mt-3(
        v-model="files"
        :state="Boolean(files)"
        placeholder="Выберите файлы или переместите их сюда"
        drop-placeholder="Переместите файлы сюда"
        multiple
      )

      .text-right
        b-button.mt-3.px-4(
          variant="primary"
          size="sm"
          @click="messageSubmit"
        ) Отправить

</template>

<script>
import Wrapper from "../Wrapper";

export default {
  data() {
    return {
      toTeacherId: null,
      message: "",
      files: [],

      teachers: [
        { value: null, text: "Выберите преподавателя" },
        { value: 1, text: "Иван Иванович Иван" },
        { value: 2, text: "Надежда Алексеевна Алексеева" },
        { value: 3, text: "Алексей Андреевич Андреев" },
        { value: 4, text: "Анастасия Максимовна Фролова" }
      ]
    };
  },

  computed: {
    fromStudent: function() {
      return this.$store.getters.user;
    },

    fromStudentId: function() {
      return this.fromStudent.id;
    }
  },

  methods: {
    messageSubmit() {
      let request = {
        POST: {
          url: "/api/messages.sendToTeacher",
          data: {
            fromStudentId: this.fromStudentId,
            toTeacherId: this.toTeacherId,
            message: this.message,
            files: this.files
          }
        }
      };

      alert(JSON.stringify(request, null, "    "));
    }
  },

  components: {
    Wrapper
  },

  mounted() {
    this.$store.dispatch("navActiveLink", "/messages");
  }
};
</script>
