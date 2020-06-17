<template lang="pug">
  Wrapper(:title="studyPlanSubject.name")
    SubjectGroupsExplorer(
      :subjectGroups="subjectGroups"
      :studyPlanSubject="studyPlanSubject"
      @open="openSubjectGroup"
      v-if="!path.length"
    )

    FilesExplorer(
      :path="path"
      :files="files"
      @open="open"
      v-if="path.length"
    )
</template>

<script>
import Wrapper from "../Wrapper";
import FilesExplorer from "./FilesExplorer";
import SubjectGroupsExplorer from "./SubjectGroupsExplorer";

import FileDownload from "js-file-download";

export default {
  mounted() {
    if (this.user_role != "student") {
      this.$router.push("/");
    }

    this.studyPlanSubject.id = this.$route.params.id;

    this.loadAllInfo();
  },

  data() {
    return {
      studyPlanSubject: {},
      subjectGroups: [],

      path: [],

      files: []
    };
  },

  methods: {
    async openSubjectGroup(sg) {
      await this.$http
        .get("http://localhost:8079/subject_groups/" + sg.id + "/documents")
        .then(response => {
          this.files = this.$jsog.decode(response.data);
          this.path = [
            { name: this.studyPlanSubject.name, path: "/" },
            { name: sg.name, path: "/" + sg.name }
          ];
        });
    },

    open(pathToOpen, isFile, id, fileName) {
      let splittedPath = pathToOpen.split("/");

      if (!isFile) {
        if (pathToOpen == "/") {
          this.files = [];
          this.path = [];
        } else if (splittedPath.length == 2) {
          for (let sg of this.subjectGroups) {
            if (sg.name == splittedPath[1]) {
              this.openSubjectGroup(sg);
              break;
            }
          }
        } else {
          let current_path = "";
          this.path = [{ name: this.studyPlanSubject.name, path: "/" }];
          for (let pathItem of pathToOpen.split("/").slice(1)) {
            current_path += "/" + pathItem;
            this.path.push({
              name: pathItem,
              path: current_path
            });
          }
        }
      } else {
        this.$http({
          method: "GET",
          url: "http://localhost:8079/documents/" + id,
          responseType: "blob"
        }).then(response => FileDownload(response.data, fileName));
      }
    },

    async loadStudyPlanSubjectInfo() {
      await this.$http
        .get(
          "http://localhost:8079/study_plan_subjects/" +
            this.studyPlanSubject.id
        )
        .then(
          response => (this.studyPlanSubject = this.$jsog.decode(response.data))
        );
    },

    async loadSubjectGroupsInfo() {
      await this.$http
        .get(
          "http://localhost:8079/subjects/" +
            this.studyPlanSubject.subject.id +
            "/students/" +
            this.user.id
        )
        .then(
          response => (this.subjectGroups = this.$jsog.decode(response.data))
        );
    },

    async loadAllInfo() {
      await this.loadStudyPlanSubjectInfo();
      await this.loadSubjectGroupsInfo();
    }
  },

  components: {
    Wrapper,
    FilesExplorer,
    SubjectGroupsExplorer
  },

  computed: {
    user_role() {
      return this.$store.getters.user_role;
    },

    user() {
      return this.$store.getters.user;
    }
  }
};
</script>
