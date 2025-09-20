<template>

  <div class="page_title">
    <div class="container_1200">
      <h1 class="page_title__h1">FAQ</h1>
      <Breadcrumb :items="breadcrumb" />
    </div>
  </div>

  <HomeFaqComponent />

</template>

<script>
import HomeFaqComponent from "@/components/home/HomeFaqComponent";
import Breadcrumb from "@/components/Breadcrumb";

export default {
name: "HomePage",
  components: {
    HomeFaqComponent, Breadcrumb
  },
  data() {
    return {
      breadcrumb: [
        {label: 'FAQ'}
      ],
    }
  }
}
</script>

<style scoped>

</style>