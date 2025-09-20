<template>
  <router-link :to="'/post/'+item.slug"  v-for="item in newsList" :key="item.id" class="news_item">
    <div class="news_item__img">
      <img :src="'/api/image/'+item.image" alt="">
    </div>
    <div class="news_item__info">
      <div class="news_item__category">{{ getNameByAlias(item.category) }}</div>
      <div class="news_item__name">{{ item.title }}</div>
      <div class="news_item__date">{{ item.publishedAt }}</div>
      <div class="news_item__anons">{{ item.description }}</div>
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
    },
    categories: {
      type: Array,
      required: true
    }
  },
  methods: {
    getNameByAlias(alias) {
      const category = this.categories.find(item => item.alias === alias)
      return category ? category.name : null
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