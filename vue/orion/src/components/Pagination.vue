<template>
  <nav class="pagination" v-if="totalPages > 1">
    <ul>
      <!-- Кнопка назад -->
      <li>
        <a
            href="#"
            class="prev"
            :class="{ disabled: currentPage === 1 }"
            @click.prevent="goToPage(currentPage - 1)"
        >
          ‹
        </a>
      </li>

      <!-- Первая страница -->
      <li v-if="pages[0] !== 1">
        <a href="#" @click.prevent="goToPage(1)">1</a>
      </li>
      <li v-if="pages[0] > 2">
        <span class="dots">...</span>
      </li>

      <!-- Динамические страницы -->
      <li v-for="page in pages" :key="page">
        <a
            href="#"
            :class="{ active: currentPage === page }"
            @click.prevent="goToPage(page)"
        >
          {{ page }}
        </a>
      </li>

      <!-- Последняя страница -->
      <li v-if="pages[pages.length - 1] < totalPages - 1">
        <span class="dots">...</span>
      </li>
      <li v-if="pages[pages.length - 1] < totalPages">
        <a href="#" @click.prevent="goToPage(totalPages)">{{ totalPages }}</a>
      </li>

      <!-- Кнопка вперед -->
      <li>
        <a
            href="#"
            class="next"
            :class="{ disabled: currentPage === totalPages }"
            @click.prevent="goToPage(currentPage + 1)"
        >
          ›
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "PaginationComponent",
  props: {
    currentPage: { type: Number, required: true },
    totalPages: { type: Number, required: true },
    maxVisible: { type: Number, default: 5 } // сколько страниц показывать вокруг
  },
  computed: {
    pages() {
      const half = Math.floor(this.maxVisible / 2)
      let start = Math.max(2, this.currentPage - half)
      let end = Math.min(this.totalPages - 1, this.currentPage + half)

      // корректируем если сдвигается начало или конец
      if (this.currentPage <= half) {
        end = Math.min(this.totalPages - 1, this.maxVisible)
      }
      if (this.currentPage > this.totalPages - half) {
        start = Math.max(2, this.totalPages - this.maxVisible + 1)
      }

      const pages = []
      for (let i = start; i <= end; i++) {
        pages.push(i)
      }
      return pages
    }
  },
  methods: {
    goToPage(page) {
      if (page < 1 || page > this.totalPages) return
      this.$emit("page-change", page)
    }
  }
}
</script>

<style scoped>
  .pagination ul{
    display: flex;
    align-items: center;
    margin-left: -4px;
    margin-right: -4px;
  }
  .pagination ul li{
    padding: 0 4px;
  }
  .pagination ul li a{
    height: 34px;
    width: 34px;
    border: 1px solid #FFFFFF33;
    display: flex;
    align-items: center;
    justify-content: center;
    font: 12px/12px 'Montserrat';
    color: #ffffff;
  }
  .pagination ul li a.active{
    background: #FBB03B;
  }
</style>