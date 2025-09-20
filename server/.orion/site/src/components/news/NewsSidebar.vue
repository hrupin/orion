<template>
  <button class="btn_open_sidebar" @click="isOpenFilter = true">
    <svg
        xmlns="http://www.w3.org/2000/svg"
        width="24"
        height="24"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
        stroke-width="2"
        stroke-linecap="round"
        stroke-linejoin="round"
    >
      <polygon points="3 4 21 4 14 12.5 14 19 10 21 10 12.5 3 4" />
    </svg>

  </button>
  <div :class="['news_sidebar', { open: isOpenFilter }]">
    <div class="btn_close_sidebar_block">
      <button class="btn_close_sidebar" @click="isOpenFilter = false">
        <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
        >
          <line x1="18" y1="6" x2="6" y2="18" />
          <line x1="6" y1="6" x2="18" y2="18" />
        </svg>
      </button>
    </div>
    <NewsCategories />
    <NewsArchive />
    <NewsTags />
  </div>
</template>

<script>
import NewsCategories from "@/components/news/NewsCategories";
import NewsArchive from "@/components/news/NewsArchive";
import NewsTags from "@/components/news/NewsTags";

export default {
  name: "NewsSidebar",
  data() {
    return {
      isOpenFilter: false
    }
  },
  components: {NewsTags, NewsArchive, NewsCategories},
}
</script>

<style scoped>

</style>