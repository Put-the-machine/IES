import Vue from "vue";
import VueRouter from "vue-router";

import Home from "./../components/Home/Home";
import Curriculum from "./../components/Curriculum/Curriculum";
import FilesStudent from "./../components/Files/FilesStudent";
import Messages from "./../components/Messages/Messages";

Vue.use(VueRouter);

const routes = [
  { path: "/", component: Home },
  { path: "/curriculum/:id", component: Curriculum },
  { path: "/curriculum/subject/:id", component: FilesStudent },
  { path: "/messages", component: Messages }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
