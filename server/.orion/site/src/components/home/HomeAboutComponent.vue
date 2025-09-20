<template>
  <section class="home_about">
    <div class="container_1200">
      <h2 class="home_h2">Про підрозділ</h2>
      <div class="home_about_text">
        <p>Ми — реформований підрозділ з історією, що почалася у 2014 році, коли країна опинилася на межі.</p>
        <p>Сотні боїв, десятки населених пунктів і тисячі важливих рішень.<br />
          Наше завдання — захищати Україну в найскладніші часи, бути на передовій боротьби за мир і свободу. </p>
      </div>
      <div class="home_about__text_imp">
        Наш шлях — це шлях героїзму, відваги і невтомної боротьби заради майбутнього нашої країни
      </div>
    </div>
  </section>
</template>

<script>
export default {
name: "HomeAboutComponent"
}
</script>

<style scoped>
.home_about{
  padding: 200px 0;
  background: url("../../assets/img/bg_ha.jpg") no-repeat right center;
  background-size: cover;
}
.home_about__text_imp{
  padding: 16px 24px;
  background: #FBB03B;
  font: 700 22px/35px 'Montserrat';
  color: #1B1B1B;
}
</style>