<template>
  <div class="news_categories">
    <div class="news_categories__title">Категорії блогу</div>
    <ul class="news_categories__list">
      <li v-for="item in categories" :key="item.id">
        <a href="/{{item.alias}}">{{item.name}}</a>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "NewsCategories",
  data() {
    return {
      categories: []
    }
  },
  mounted() {
    this.fetchCategories();
  },
  methods: {
    async fetchCategories() {
      try {
        const response = await axios.get('http://127.0.0.1:8080/api/categories');
        this.categories = response.data;
      } catch (error) {
        console.error('Error loading recruitment center data:', error);
      }
    }
  }
}
</script>

<style scoped>
  .news_categories{
    background: #FBB03B;
    margin-bottom: 32px;
  }
  .news_categories__title{
    font: 500 18px/20px 'Montserrat';
    color: #1B1B1B;
    border-bottom: 2px solid #0000001F;
    padding: 14px;
    text-transform: uppercase;
  }
  .news_categories__list{
    padding: 0 14px 5px;
  }
  .news_categories__list li a{
    font: 13px/24px 'Montserrat';
    color: #1B1B1B;
    border-bottom: 1px solid #0000001F;
    display: block;
    padding: 10px 0;
  }
  .news_categories__list li:last-child a{
    border-bottom: none;
  }
</style>