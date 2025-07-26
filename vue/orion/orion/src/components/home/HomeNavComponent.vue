<template>
  <section class="home_nav">
    <div class="home_nav__list">
      <a href="#" class="home_nav__item">
        <img src="@/assets/img/homenav1.jpg" alt="">
        <div class="home_nav__info">Відео</div>
      </a>
      <a href="#" class="home_nav__item">
        <img src="@/assets/img/homenav2.jpg" alt="">
        <div class="home_nav__info">Про нас</div>
      </a>
      <a href="#" class="home_nav__item">
        <img src="@/assets/img/homenav1.jpg" alt="">
        <div class="home_nav__info">Новини</div>
      </a>
    </div>
  </section>
</template>

<script>
export default {
name: "HomeNavComponent"
}
</script>

<style scoped>
.home_nav{
  background: #000000;
}
.home_nav__list{
  display: flex;
}
.home_nav__item{
  flex-basis: 0;
  flex-grow: 1;
  height: 425px;
  position: relative;
  z-index: 1;
}
.home_nav__item img{
  object-fit: cover;
  object-position: center;
  width: 100%;
  height: 100%;
}
.home_nav__info{
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  font: 600 32px/32px 'Montserrat';
  color: #FBB03B;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #000000CC;
}
</style>