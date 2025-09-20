<template>
  <ul class="page_breadcrumb">
    <li>
      <router-link class="bc_link" to="/"><img src="@/assets/img/icon_home.svg" alt="">Головна</router-link>
    </li>
    <li v-for="(item, index) in items" :key="index">
      <router-link class="bc_link" v-if="item.link" :to="item.link">{{ item.label }}</router-link>
      <span v-else>{{ item.label }}</span>
    </li>
  </ul>
</template>

<script>

export default {
  name: "BreadCrumb",
  props: {
    items: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.page_breadcrumb{
  padding: 10px;
  background: #1B1B1B;
}
.page_breadcrumb li{
  display: inline-block;
  vertical-align: middle;
}
.bc_link{
  font: 12px/14px 'Montserrat';
  color: #FBB03B;
  vertical-align: middle;
}
.bc_link img{
  margin-right: 8px;
  vertical-align: middle;
}
.bc_link:after{
  content: '/';
  margin: 0 8px;
}
.page_breadcrumb span{
  font: 12px/15px 'Montserrat';
  color: #ffffff;
}
</style>