<template lang="pug">
  b-nav-item-dropdown#dropdown-form.m-2(text='Авторизация' ref='dropdown' variant="primary" size="sm" right)
    b-dropdown-form.p-2
      b-form-group(label='Логин' label-for='dropdown-form-login')
        b-form-input#dropdown-form-login(size='sm' placeholder='Введите логин' v-model="form.login")

      b-form-group(label='Пароль' label-for='dropdown-form-password')
        b-form-input#dropdown-form-password(type='password' size='sm' placeholder='Введите пароль' v-model="form.password")

      b-form-checkbox.mb-3.text-nowrap.pr-2(v-model="form.remember") Запомнить меня
      
      b-button(variant='primary' size='sm' @click='onFormSubmit' block :disabled="logging")
        span(:class="{'d-none': logging}") Авторизоваться
        b-icon-three-dots(animation="cylon" :class="{'d-none': !logging}")
          
      
      div(v-if="error").text-danger.mt-2.text-nowrap Ошибка авторизации
</template>

<script>
import { BIconThreeDots } from "bootstrap-vue";

export default {
  data() {
    return {
      form: {
        login: "",
        password: "",
        remember: false
      },
      logging: false,
      error: false
    };
  },

  methods: {
    async onFormSubmit() {
      try {
        this.error = false;
        this.logging = true;
        await this.$store.dispatch("auth", this.form);
      } catch {
        this.error = true;
        this.logging = false;
      }
    }
  },

  components: {
    BIconThreeDots
  }
};
</script>
