<template>
  <router-link :to="item.url"  v-for="item in newsList" :key="item.id" class="news_item">
    <div class="news_item__img">
      <img :src="item.image" alt="">
    </div>
    <div class="news_item__info">
      <div class="news_item__category">{{ item.category }}</div>
      <div class="news_item__name">{{ item.name }}</div>
      <div class="news_item__date">{{ item.date }}</div>
      <div class="news_item__anons">{{ item.anons }}</div>
    </div>
  </router-link>
</template>

<script>
export default {
  name: "NewsItem",
  props: {
    newsList: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
.news_item{
  display: block;
  margin-bottom: 32px;
}
.news_item__img img{
  display: block;
  width: 100%;
  height: 375px;
  object-fit: cover;
  object-position: center;
}
.news_item__info{
  padding: 20px;
  background: #1B1B1B;
}
.news_item__category{
  font: 12px/24px 'Montserrat';
  color: #FBB03B;
  text-transform: uppercase;
  margin-bottom: 2px;
}
.news_item__name{
  font: 24px/24px 'Montserrat';
  color: #ffffff;
  text-transform: uppercase;
  margin-bottom: 12px;
}
.news_item__date{
  font: 12px/24px 'Montserrat';
  color: #ffffff;
  margin-bottom: 12px;
}
.news_item__anons{
  font: 12px/24px 'Montserrat';
  color: #ffffff;
}
</style>