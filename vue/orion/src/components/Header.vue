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
<!--        <li>-->
<!--          <a class="header_nav_link" href="#" @click="isOpenMobileMenu = false">Підтримати</a>-->
<!--        </li>-->
        <li>
          <router-link class="header_nav_link" to="/faq" @click="isOpenMobileMenu = false" >FAQ</router-link>
        </li>
        <li>
          <a class="btn_secondary" href="#" @click="isModalOpen = true">Заповнюй анкету</a>
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

    <ModalComponent :visible="isModalOpen" @close="isModalOpen = false">
      <form class="anketa" @submit.prevent="handleFormSubmit">
        <input v-model="form.name" type="text" placeholder="Ім'я" required />
        <input v-model="form.lastName" type="text" placeholder="Прізвище" required />

        <div class="date-input-wrapper">
          <label
              class="placeholder-label"
              :class="{ 'is-hidden': form.birthday }"
              for="birthday"
          >
            Дата народження
          </label>
          <input
              id="birthday"
              v-model="form.birthday"
              type="date"
              name="birthday"
              required
              :class="{ 'has-value': form.birthday }"
          />
        </div>

        <input
            v-model="form.phone"
            required
            v-mask="'+38 (###) ###-##-##'"
            type="tel"
            placeholder="+38 (___) ___-__-__"
        />
        <input v-model="form.email" type="email" placeholder="Email" required />
        <label style="display: flex; align-items: center; gap: 10px; margin-top: 10px;">
          <input type="checkbox" name="isCurrentlyInArmy" v-model="showMilitaryBranchSelect" style="width: 24px; height: 24px;"/>
          <p>Чи є ви чинним військовослужбовцем?</p>
        </label>
        <select v-if="showMilitaryBranchSelect" name="militaryBranch" v-model="form.militaryBranch">
          <option disabled value="">Виберіть рід військ</option>
          <option value="ЗСУ">ЗСУ</option>
          <option value="ТрО">ТрО</option>
          <option value="НГУ">НГУ</option>
          <option value="ДПСУ">ДПСУ</option>
          <option value="МП">МП</option>
          <option value="ДШВ">ДШВ</option>
          <option value="ССО">ССО</option>
          <option value="ІНШЕ">ІНШЕ</option>
        </select>
        <textarea v-model="form.comment" placeholder="Ваш коментар" rows="5" required></textarea>
        <div v-if="isSubmitting" class="loader">Зачекайте...</div>
        <button v-else type="submit">Відправити</button>
        <p v-if="submitResult" :class="{ success: submitSuccess, error: !submitSuccess }">
          {{ submitResult }}
        </p>
      </form>
    </ModalComponent>

  </header>
</template>

<script>
import axios from 'axios'
import emitter from '../eventBus';
import ModalComponent from './home/ModalComponent.vue';

export default {
  name: "HeaderComponent",
  components: {
    ModalComponent
  },
  data() {
    return {
      isScrolled: false,
      isOpenMobileMenu: false,
      isModalOpen: false,
      isSubmitting: false,
      submitResult: '',
      submitSuccess: false,
      showMilitaryBranchSelect: false,
      form: {
        id: "0",
        firstName: '',
        lastName: '',
        birthday: '',
        phone: '',
        email: '',
        comment: '',
        militaryBranch: ''
      }
    }
  },
  methods: {
    handleScroll() {
      this.isScrolled = window.scrollY > 0
    },

    toggleMobileMenu() {
      this.isOpenMobileMenu = !this.isOpenMobileMenu
    },

    async handleFormSubmit() {
      this.isSubmitting = true
      this.submitResult = ''
      this.submitSuccess = false

      if (!this.showMilitaryBranchSelect) {
        this.form.militaryBranch = ''
      }

      const date = new Date(this.form.birthday);
      const timestamp = date.getTime();

      this.form.birthday = timestamp

      try {
        await axios.post('http://127.0.0.1:8080/api/questionnaire', this.form)
        this.submitSuccess = true
        this.submitResult = 'Форма успішно відправлена!'
        this.resetForm()
      } catch (error) {
        console.error('Помилка при відправці форми:', error)
        this.submitSuccess = false
        this.submitResult = 'Сталася помилка. Спробуйте ще раз.'
      } finally {
        this.isSubmitting = false
      }
    },
    resetForm() {
      this.form = {
        name: '',
        lastName: '',
        birthDate: '',
        phone: '',
        email: '',
        comment: '',
        militaryBranch: ''
      }
      this.showMilitaryBranchSelect = false
    }

  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
    emitter.on('open-modal', () => {
      this.isModalOpen = true;
    });
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

















  .date-input-wrapper {
    position: relative;
    display: inline-block;
  }

  .placeholder-label {
    position: absolute;
    top: 50%;
    left: 12px;
    transform: translateY(-50%);
    color: #888;
    pointer-events: none;
    transition: 0.2s ease;
  }

  input[type="date"] {
    padding: 10px 12px;
    font-size: 16px;
    color: transparent;
  }

  .is-hidden {
    opacity: 0;
    visibility: hidden;
  }

  input[type="date"].has-value,
  input[type="tel"],
  input[type="text"],
  input[type="email"] {
    color: gray;
  }
</style>