<template>
  <div class="page_title page_title__news">
    <div class="container_1200">
      <h1 class="page_title__h1">Новини</h1>
      <Breadcrumb :items="breadcrumb" />
    </div>
  </div>

  <section class="news_list">
    <div class="container_1200">
      <div class="news_content">
        <div class="news_content__left">
          <div class="news_items">
            <NewsItem :newsList="newsList" />
          </div>
          <Pagination />
        </div>
        <NewsSidebar />
      </div>
    </div>
  </section>
</template>

<script>
import Breadcrumb from "@/components/Breadcrumb";
import NewsItem from "@/components/news/NewsItem";
import Pagination from "@/components/Pagination";
import NewsSidebar from "@/components/news/NewsSidebar";
export default {
  name: "NewsPage",
  components: {NewsSidebar, Pagination, NewsItem, Breadcrumb},
  data() {
    return {
      breadcrumb: [
        { label: 'Новини' }
      ],
      newsList: [
        {
          id: 1,
          url: '/news/1',
          name: 'Останні здобутки підрозділу',
          category: 'Категорія 1',
          date: '15 Жовтня, 2025',
          anons: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porttitor sapien ut odio luctus, non lobortis quam eleifend. Nunc venenatis vestibulum nisl. Nullam eu enim feugiat, Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          image: './img/news_1.jpg'
        },
        {
          id: 2,
          url: '/news/1',
          name: 'Останні здобутки підрозділу',
          category: 'Категорія 2',
          date: '15 Жовтня, 2025',
          anons: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porttitor sapien ut odio luctus, non lobortis quam eleifend. Nunc venenatis vestibulum nisl. Nullam eu enim feugiat, Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          image: './img/news_2.jpg'
        },
        {
          id: 3,
          url: '/news/1',
          name: 'Останні здобутки підрозділу',
          category: 'Категорія 3',
          date: '15 Жовтня, 2025',
          anons: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porttitor sapien ut odio luctus, non lobortis quam eleifend. Nunc venenatis vestibulum nisl. Nullam eu enim feugiat, Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          image: './img/news_1.jpg'
        },
        {
          id: 4,
          url: '/news/1',
          name: 'Останні здобутки підрозділу',
          category: 'Категорія 4',
          date: '15 Жовтня, 2025',
          anons: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In porttitor sapien ut odio luctus, non lobortis quam eleifend. Nunc venenatis vestibulum nisl. Nullam eu enim feugiat, Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          image: './img/news_2.jpg'
        }
      ]
    }
  },
}
</script>

<style scoped>

</style>