<template>
  <div class="hero_section">
    <div class="hero_section__container">
      <h1 class="hero_h1">Підрозділ <span>ОРІОН</span> Бригади гвардії наступу <span>"Помста"</span></h1>
      <div class="hero_text_1">ставай частиною</div>
      <img class="img_orion" src="@/assets/img/orion.svg" alt="">
      <a href="#" class="btn_yellow">Заповнюй анкету</a>
    </div>
  </div>
</template>

<script>
export default {
name: "HeroComponent"
}
</script>

<style scoped>
  .hero_section{
    min-height: 100vh;
    background: url("../../assets/img/hero_bg.jpg") no-repeat center center;
    background-size: cover;
    padding-top: 100px;
    display: flex;
    align-items: center;
  }
  .hero_section__container{
    width: 1100px;
    max-width: 100%;
    margin: 0 auto;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 48px 0;
  }
  .hero_h1{
    font: 24px/26px 'Montserrat';
    color: #ffffff;
    padding: 12px;
    border: 1px solid #ffffff;
    text-transform: uppercase;
    margin-bottom: 48px;
  }
  .hero_h1 span{
    color: #FBB03B;
  }
  .hero_text_1{
    font: 600 70px/70px 'Montserrat';
    color: #ffffff;
    text-transform: uppercase;
    margin-bottom: 48px;
    text-align: center;
  }
  .img_orion{
    margin-bottom: 48px;
  }
  @media (max-width: 1200px){
    .hero_section__container{
      padding: 0 30px;
    }
  }
  @media (max-width: 991px) {
    .hero_section__container {
      padding: 0 30px;
    }
  }
  @media (max-width: 767px){
    .hero_section__container{
      padding: 0 15px;
    }
    .hero_h1 {
      font: 20px / 26px 'Montserrat';
    }
    .hero_text_1 {
      font: 600 36px / 48px 'Montserrat';
      text-align: center;
      margin-bottom: 24px;
    }
  }
</style>