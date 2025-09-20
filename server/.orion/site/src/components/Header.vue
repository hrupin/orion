<template>
  <header :class="['header', { scrolled: isScrolled }, { scrolled: isOpenMobileMenu }]">
    <div class="header_block">
      <router-link to="/" >
        <img src="@/assets/img/logo.svg" alt="">
      </router-link>
      <ul :class="['header_nav', { open: isOpenMobileMenu }]">
        <li>
          <router-link class="header_nav_link" to="/" @click="isOpenMobileMenu = false" >Головна</router-link>
        </li>
        <li>
          <router-link class="header_nav_link" to="/news" @click="isOpenMobileMenu = false" >Новини</router-link>
        </li>
        <li>
          <router-link class="header_nav_link" to="/video" @click="isOpenMobileMenu = false" >Відео</router-link>
        </li>
        <li>
          <router-link class="header_nav_link" to="/about" @click="isOpenMobileMenu = false" >Про Оріон</router-link>
        </li>
        <li>
          <a class="header_nav_link" href="#" @click="isOpenMobileMenu = false">Підтримати</a>
        </li>
        <li>
          <router-link class="header_nav_link" to="/faq" @click="isOpenMobileMenu = false" >FAQ</router-link>
        </li>
        <li>
          <a class="btn_secondary" href="#">Заповнюй анкету</a>
        </li>
      </ul>
      <button @click="toggleMobileMenu" class="btn_burger">
        <svg
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            fill="currentColor"
            viewBox="0 0 24 24"
        >
          <path d="M3 6h18M3 12h18M3 18h18" stroke="currentColor" stroke-width="2" stroke-linecap="round" fill="#ffffff"/>
        </svg>

      </button>
    </div>
  </header>
</template>

<script>

export default {
  name: "HeaderComponent",
  data() {
    return {
      isScrolled: false,
      isOpenMobileMenu: false
    }
  },
  methods: {
    handleScroll() {
      this.isScrolled = window.scrollY > 0
    },

    toggleMobileMenu() {
      this.isOpenMobileMenu = !this.isOpenMobileMenu
    }
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll)
  }
}
</script>

<style scoped>
  .header{
    padding: 12px 0;
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    transition: 0.2s;
    z-index: 999;
  }
  .header.scrolled{
    background: #0F0F0F;
  }
  .header_block{
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 60px;
  }
  .header_nav{
    display: flex;
    align-items: center;
  }
  .header_nav li{
    padding: 0 24px;
  }
  .header_nav_link{
    display: block;
    font: 18px/20px 'Montserrat';
    color: #ffffff;
    border-bottom: 2px solid transparent;
    padding: 6px 0;
  }
  .header_nav_link.router-link-active{
    border-color: #FBB03B;
  }
  .btn_burger{
    display: none;
  }
  @media (max-width: 1200px){
    .hero_section__container{
      padding: 0 30px;
    }
  }
  @media (max-width: 991px){
    .btn_burger{
      display: block;
      background: transparent;
      border: none;
      padding: 0;
    }
    .btn_burger svg{
      width: 36px;
      height: 36px;
    }
    .btn_burger svg path{
      stroke: #ffffff;
    }
    .header_nav{
      position: fixed;
      background: #0F0F0F;
      width: 100%;
      top: 98px;
      left: 0;
      flex-direction: column;
      display: none;
      padding: 0 32px 40px 32px;
    }
    .header_nav.open{
      display: flex;
    }
    .header_nav li {
      padding: 0 24px;
      margin-bottom: 24px;
    }
    .hero_section__container{
      padding: 0 30px;
    }
  }
  @media (max-width: 767px){
    .hero_section__container{
      padding: 0 15px;
    }
    .header_nav {
      padding: 0 16px 24px 16px;
    }
  }
</style>