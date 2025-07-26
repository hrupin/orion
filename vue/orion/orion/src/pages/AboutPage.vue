<template>
  <div class="page_title page_title__about">
    <div class="container_1200">
      <h1 class="page_title__h1">Про нас</h1>
      <Breadcrumb :items="breadcrumb" />
    </div>
  </div>
  <section class="about_section">
    <div class="container_1200">
      <img class="about__img" src="@/assets/img/img_about.jpg" alt="">
      <h2>Підрозділ <span class="color_yellow">"Оріон"</span> — сучасна модель бойової готовності України</h2>
      <p>Підрозділ "Оріон" — це не просто військове формування, новий формат війська, створений з тих, хто готовий діяти жорстко, швидко та без компромісів. Ми несемо відповідальність за безпеку держави та збереження життя мирних громадян. Тут служать лише одні з найкращих — ті, хто щодня доводить свою відданість та професіоналізм не словами, а діями.</p>
      <blockquote>Безпека особового складу — наш пріоритет №1</blockquote>
      <p>У "Оріоні" ми не кидаємо своїх. Захист життя кожного бійця — основа нашої стратегії. Ми створюємо умови, в яких особовий склад не просто виконує бойові задачі, а працює з повною концентрацією, знаючи: тил надійний, підтримка — стійка, командування — поряд. Сильний боєць — це живий, захищений, мотивований боєць.</p>
    </div>
  </section>
  <section class="about_banner">
    <div class="container_1200">
      <div class="about_banner__logo">
        <img src="@/assets/img/logo_full.svg" alt="">
      </div>
      <div class="about_banner__text">
        Готові до будь-яких загроз — <span class="color_yellow">на суші,<br />
        у повітрі й на інформаційному фронті</span>
      </div>
    </div>
  </section>
  <section class="about_section">
    <div class="container_1200">
      <p>
        <span class="color_yellow">"Оріон"</span> — це оперативна міць, здатна знищити загрозу ще до того, як вона наблизиться. Ми працюємо у найскладніших умовах, на передових позиціях, де кожне рішення має вагу життя. Захист національної безпеки України — наша щоденна місія. Ми не чекаємо удару — ми його випереджаємо.
      </p>
      <blockquote>Нам потрібні ті, хто не боїться відповідальності</blockquote>
      <p class="color_yellow">
        Ми завжди у пошуку нових професіоналів — різних вікових категорій, різних професій у минулому житті, дисциплінованих та мотивованих. Якщо ти готовий або готова стати частиною підрозділу, де цінують дружбу, прогрес і реальний бойовий досвід — долучайся. В "Оріоні" ти отримаєш не тільки військову підготовку, а й реальний захист, підтримку побратимів та впевненість у завтрашньому дні.
      </p>
      <img class="about__img" src="@/assets/img/img_about_2.jpg" alt="">
    </div>
  </section>
  <section class="why_orion">
    <div class="container_1200">
      <h2 class="home_h2 text-center">Чому саме “Оріон” ?</h2>
      <div class="wth_block">
        <div class="wth_col">
          <div class="wth_item">
            <div class="wth_item__num"><span>1</span></div>
            <div class="wth_item__text">Високий рівень забезпечення для особового складу</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>2</span></div>
            <div class="wth_item__text">Безкомпромісний та сучасний підхід до виконання задач</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>3</span></div>
            <div class="wth_item__text">Професійна підтримка та соціальний захист</div>
          </div>
        </div>
        <div class="wth_col">
          <div class="wth_item">
            <div class="wth_item__num"><span>4</span></div>
            <div class="wth_item__text">Грошове забезпечення до 210 000 на місяць.</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>5</span></div>
            <div class="wth_item__text">Підтримка програми «Контракт 18-24»</div>
          </div>
          <div class="wth_item">
            <div class="wth_item__num"><span>6</span></div>
            <div class="wth_item__text">Реальна відсутність «совку»</div>
          </div>
        </div>
        <div class="wth_col_bottom">Команда, з молодих та професіональних військових</div>
      </div>
      <div class="why_bottom">Захисти себе — захищаючи Україну. <span class="color_yellow">Підрозділ "Оріон" чекає на рішучих.</span></div>
      <div class="why_btn">
        <a href="#" class="btn_yellow">Заповнюй анкету</a>
      </div>
    </div>
  </section>
</template>

<script>
import Breadcrumb from "@/components/Breadcrumb";
export default {
  name: "AboutPage",
  components: {Breadcrumb},
  data() {
    return {
      breadcrumb: [
        { label: 'Про нас' }
      ]
    }
  },
}
</script>

<style scoped>
  .about_section{
    padding: 60px 0 36px;
    font: 16px/26px 'Montserrat';
    color: #ffffff;
  }
  .about_section h2{
    font: 24px/24px 'Montserrat';
    color: #ffffff;
    margin: 0 0 32px;
    text-transform: uppercase;
  }
  .about_section p{
    margin-bottom: 24px;
  }
  .about__img{
    height: 370px;
    width: 100%;
    object-fit: cover;
    object-position: center;
    margin-bottom: 32px;
  }
  .about_section blockquote{
    margin-left: 48px;
    border-left: 2px solid #FBB03B;
    padding-left: 16px;
    position: relative;
    margin-bottom: 24px;
    font: 500 24px/26px 'Montserrat';
    color: #FBB03B;
  }
  .about_section blockquote:before{
    content: '';
    position: absolute;
    left: -48px;
    top: 0;
    width: 29px;
    height: 26px;
    background: url("../assets/img/icon_bq.svg") no-repeat 0 0;
    background-size: contain;
  }
  .about_banner{
    height: 410px;
    background: url("../assets/img/img_banner_about.jpg") no-repeat right center;
    background-size: cover;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .about_banner__logo{
    text-align: center;
    margin: 0 0 40px;
  }
  .about_banner__text{
    font: 600 42px/55px 'Montserrat';
    color: #ffffff;
    text-align: center;
  }
  .why_orion{
    padding: 100px 0;
    background: url("../assets/img/bg_wth.jpg") no-repeat center center;
    background-size: cover;
  }
  .why_bottom{
    font: 500 24px/26px 'Montserrat';
    color: #ffffff;
    font-style: italic;
    text-align: center;
    padding: 0 0 32px 0;
  }
  .why_btn{
    display: flex;
    justify-content: center;
  }
  @media (max-width: 767px){
    .about_section blockquote {
      font: 500 20px / 26px 'Montserrat';
    }
    .about_banner__text {
      font: 600 28px / 40px 'Montserrat';
      color: #ffffff;
      text-align: center;
    }
  }
</style>