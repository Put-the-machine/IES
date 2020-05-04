<template lang="pug">
  Wrapper(title="Информационно-образовательная среда СГТУ им. Гагарина")
    b-img(:src="image" fluid)
    h4.mt-3.font-weight-normal Добро пожаловать  в информационно-образовательную среду СГТУ им. Гагарина
    p Информационно образовательная среда СГТУ предоставляет собой единый интерфейс общего доступа к данным, получаемым из разных источников и образовательных приложений.
    hr.my-4
    Institutes
</template>

<script>
import Wrapper from "../Wrapper";
import image from "../../assets/img/banner.jpg";
import Institutes from "./Institutes";

export default {
  created: function() {
    window.scrollTo(0, 0);
  },

  components: {
    Institutes,
    Wrapper
  },

  data() {
    return {
      image: image
    };
  },

  mounted() {
    this.$store.dispatch("navActiveLink", "/");
  }
};
</script>
