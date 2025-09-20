<template>
  <section class="contract_1824">
    <div class="container_1200">
      <h2 class="home_h2 home_h2__dark text-center">Про підрозділ</h2>
      <div class="c1824__block">
        <div class="c1824__left">
          <img src="@/assets/img/img_c24.png" alt="">
        </div>
        <div class="c1824__right">
          <div class="c1824__text">
            Контракт 18-24 — це твій 1 рік служби в контрактній армії.
            <br /><br />
            Від 18 до 24 років? Тоді це для тебе: чіткий термін служби, реальний досвід, гідний заробіток та підтримка від держави по завершенню.
          </div>
          <a href="#" class="btn_black">Заповнюй анкету</a>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
name: "HomeContractComponent"
}
</script>

<style scoped>
  .contract_1824{
    padding: 100px 0;
    background: url("../../assets/img/bg_c24.jpg") no-repeat center center;
    background-size: cover;
  }
  .c1824__block{
    display: flex;
    align-items: center;
  }
  .c1824__left{

  }
  .c1824__right{
    padding: 24px;
  }
  .c1824__text{
    font: 500 22px/34px 'Montserrat';
    margin-bottom: 24px;
    color: #1B1B1B;
  }
</style>