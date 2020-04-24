<template lang="pug">
.wrapper
  b-img(:src="image" fluid)
  h4.mt-3.font-weight-normal Добро пожаловать  в информационно-образовательную среду СГТУ им. Гагарина
  p Информационно образовательная среда СГТУ предоставляет собой единый интерфейс общего доступа к данным, получаемым из разных источников и образовательных приложений.
  hr.my-5
  Institutes
</template>

<script>
import image from "../../assets/img/banner.jpg";
import Institutes from "./Institutes.vue";

export default {
  name: "Home",
  components: {
    Institutes
  },
  data() {
    return {
      image: image
    };
  }
};
</script>
