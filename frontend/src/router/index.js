import Vue from "vue";
import VueRouter from "vue-router";

import Home from "./../components/Home/Home";
import Curriculum from "./../components/Curriculum/Curriculum";

Vue.use(VueRouter);

const routes = [
  { path: "/", component: Home },
  { path: "/curriculum/:id", component: Curriculum }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
