<template>

  <HeroComponent />

  <HomeAboutComponent />

  <HomeYourWayComponent />

  <HomeRecruitsCenterComponent />

  <HomeContractComponent />

  <HomeNavComponent />

  <HomeFaqComponent />

</template>

<script>
import HeroComponent from "@/components/home/HeroComponent";
import HomeAboutComponent from "@/components/home/HomeAboutComponent";
import HomeYourWayComponent from "@/components/home/HomeYourWayComponent";
import HomeRecruitsCenterComponent from "@/components/home/HomeRecruitsCenterComponent";
import HomeContractComponent from "@/components/home/HomeContractComponent";
import HomeNavComponent from "@/components/home/HomeNavComponent";
import HomeFaqComponent from "@/components/home/HomeFaqComponent";

export default {
name: "HomePage",
  components: {
    HomeFaqComponent,
    HomeNavComponent,
    HomeContractComponent,
    HomeRecruitsCenterComponent, HomeYourWayComponent, HomeAboutComponent, HeroComponent}
}
</script>

<style scoped>

</style>