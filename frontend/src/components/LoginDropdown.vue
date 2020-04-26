<template lang="pug">
div
  b-dropdown#dropdown-form.m-2(text='Авторизация', ref='dropdown', variant="primary", size="sm" right)
    b-dropdown-form.p-2
      b-form-group(label='Логин', label-for='dropdown-form-login', @submit.stop.prevent='')
        b-form-input#dropdown-form-login(size='sm', placeholder='Введите логин', v-model="form.login")

      b-form-group(label='Пароль', label-for='dropdown-form-password')
        b-form-input#dropdown-form-password(type='password', size='sm', placeholder='Введите пароль', v-model="form.password")

      b-form-checkbox.mb-3.text-nowrap.pr-2(v-model="form.remember") Запомнить меня
      b-button(variant='primary', size='sm', @click='onFormSubmit' block) Авторизоваться

</template>

<script>
export default {
  data() {
    return {
      form: {
        login: "",
        password: "",
        remember: false
      }
    };
  },
  methods: {
    onFormSubmit() {
      //
    }
  }
};
</script>
