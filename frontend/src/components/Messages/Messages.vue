<template lang="pug">
  Wrapper(title="Отправка сообщений")
    b-form
      b-form-select(
        v-model="toTeacherEmail"
        :options="teachersSelect"
      )

      b-form-textarea.mt-3(
        v-model="message"
        placeholder="Введите текст сообщения"
        rows="8"
      )

      b-form-file.mt-3.overflow-hidden(
        v-model="files"
        :state="Boolean(files)"
        placeholder="Выберите файлы"
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
      teachers: [],
      toTeacherEmail: null,
      message: "",
      files: []
    };
  },

  computed: {
    fromStudent: function() {
      return this.$store.getters.user;
    },

    teachersSelect: function() {
      var items = [
        { value: null, text: "Выберите преподавателя" },
        { value: "xramirezx@outlook.com", text: "Яндыбаев Даниил Игоревич" }
      ];

      for (let teacher of this.teachers) {
        items.push({ value: "xramirezx@outlook.com", text: teacher.fullName });
      }

      return items;
    }
  },

  methods: {
    async loadTeatchers() {
      // await this.$http.get("/teachers")
      // .then(response => this.teachers = this.$jsog.decode(response.data));
    },

    async messageSubmit() {
      let body = {
        receiver: "xramirezx@outlook.com",
        from: "student@mail.ru",
        title: "Message From IES",
        text: this.message
      }


      let formBody = [];

      for (var property in body) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(body[property]);
        formBody.push(encodedKey + "=" + encodedValue);
      }

      await this.$http.post("/sendUserEmailMessage",
        {
          body: formBody.join("&"),
          headers: { "Content-Type": "application/x-www-form-urlencoded" }
        }
      );

      this.toTeacherEmail = null;
      this.message = "";
    }
  },

  components: {
    Wrapper
  },

  beforeCreate() {
    if (this.$store.getters.user_role != "student") {
      this.$router.push("/");
    }
  },

  mounted() {
    this.$store.dispatch("navActiveLink", "/messages");
    this.loadTeatchers();
  }
};
</script>
