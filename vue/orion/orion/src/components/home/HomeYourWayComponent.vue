<template>
  <section class="way_to_hell">
    <div class="container_1200">
      <div class="home_pretitle">заповнюй анкету</div>
      <h2 class="home_h2">твій шлях до підрозділу</h2>
      <div class="wth_block">
        <div class="wth_col">
          <div class="wth_item">
            <div class="wth_item__num"><span>1</span></div>
            <div class="wth_item__text">заповнити анкету</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>2</span></div>
            <div class="wth_item__text">Пройти співбесіду в рекрутинговому центрі або онлайн</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>3</span></div>
            <div class="wth_item__text">У разі успішного проходження співбесіди, подати необхідні документи</div>
          </div>
        </div>
        <div class="wth_col">
          <div class="wth_item">
            <div class="wth_item__num"><span>4</span></div>
            <div class="wth_item__text">Пройти ВЛК</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>5</span></div>
            <div class="wth_item__text">У визначений день прибути на збір рекрутів для відправки</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>6</span></div>
            <div class="wth_item__text">Після оформлення пройти базовий курс бойової підготовки</div>
          </div>
        </div>
      </div>
      <a href="#" class="btn_yellow">Заповнюй анкету</a>
    </div>
  </section>
</template>

<script>
export default {
name: "HomeYourWayComponent"
}
</script>

<style scoped>
.way_to_hell{
  padding: 140px 0;
  background: url("../../assets/img/bg_wh.jpg") no-repeat right center;
  background-size: cover;
}
.home_pretitle{
  font: 500 24px/24px 'Montserrat';
  color: #FBB03B;
  margin-bottom: 16px;
  text-transform: uppercase;
}

</style>