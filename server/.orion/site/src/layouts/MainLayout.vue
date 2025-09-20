<template>
  <div class="page">
    <HeaderComponent />
    <main>
      <router-view />
    </main>
    <FooterComponent />
  </div>
</template>


<script>
import HeaderComponent from "@/components/Header";
import FooterComponent from "@/components/Footer";
export default {
name: "MainLayout",
  components: {FooterComponent, HeaderComponent},
  computed: {
    currentRoute() {
      return this.$route.path

    }
  },
  watch: {
    '$route'(to) {
      if(to.name != 'Home'){
        document.body.classList.add('dark');
      }else{
        document.body.classList.remove('dark');
      }
    }
  },
  mounted() {
  console.log(this.$route.name);
    console.log('aaa', this.$route.name);
    if(this.$route.name != 'Home'){
      document.body.classList.add('dark');
    }else{
      document.body.classList.remove('dark');
    }
  }
}
</script>

<style scoped>

</style>