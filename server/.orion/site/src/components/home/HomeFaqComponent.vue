<template>
  <section class="home_faq">
    <div class="container_1200">
      <h2 class="home_h2 text-center">відповіді на питання</h2>
      <div class="faq_list">
        <div class="faq_item" v-for="item in faqList" :key="item.id" :class="{opened: item.isOpen}">
          <div class="faq_item__left">{{item.id}}</div>
          <div class="faq_item__right">
            <a href="#" class="faq_item__top" @click.prevent="item.isOpen = !item.isOpen">
              <div class="faq_item__question">
                {{item.question}}
              </div>
              <span class="faq_item__btn">+</span>
            </a>
            <div v-if="item.isOpen" class="faq_answer">
              {{item.answer}}
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "HomeFaqComponent",
  data: () => ({
    faqList: [
      {
        id: '01',
        question: 'Список питань про які треба подумати?',
        answer: 'Lorem ipsum dolor sit amet consectetur. Cursus eget libero eget pellentesque elementum nisl libero purus consectetur. Eu turpis praesent ut imperdiet purus quis magna. Velit sit feugiat tortor condimentum. Interdum egestas adipiscing viverra odio vestibulum egestas lacus.',
        isOpen: false
      },
      {
        id: '02',
        question: 'Список питань про які треба подумати?',
        answer: 'Lorem ipsum dolor sit amet consectetur. Cursus eget libero eget pellentesque elementum nisl libero purus consectetur. Eu turpis praesent ut imperdiet purus quis magna. Velit sit feugiat tortor condimentum. Interdum egestas adipiscing viverra odio vestibulum egestas lacus.',
        isOpen: false
      },
      {
        id: '03',
        question: 'Список питань про які треба подумати?',
        answer: 'Lorem ipsum dolor sit amet consectetur. Cursus eget libero eget pellentesque elementum nisl libero purus consectetur. Eu turpis praesent ut imperdiet purus quis magna. Velit sit feugiat tortor condimentum. Interdum egestas adipiscing viverra odio vestibulum egestas lacus.',
        isOpen: false
      },
      {
        id: '04',
        question: 'Список питань про які треба подумати?',
        answer: 'Lorem ipsum dolor sit amet consectetur. Cursus eget libero eget pellentesque elementum nisl libero purus consectetur. Eu turpis praesent ut imperdiet purus quis magna. Velit sit feugiat tortor condimentum. Interdum egestas adipiscing viverra odio vestibulum egestas lacus.',
        isOpen: false
      },
      {
        id: '05',
        question: 'Список питань про які треба подумати?',
        answer: 'Lorem ipsum dolor sit amet consectetur. Cursus eget libero eget pellentesque elementum nisl libero purus consectetur. Eu turpis praesent ut imperdiet purus quis magna. Velit sit feugiat tortor condimentum. Interdum egestas adipiscing viverra odio vestibulum egestas lacus.',
        isOpen: false
      }
    ]
  }),
}
</script>

<style scoped>
.home_faq{
  background: url("../../assets/img/bg_faq.jpg") no-repeat right center;
  background-size: cover;
  padding: 140px 0;
}
.faq_item{
  background: #FBB03B0D;
  padding: 24px;
  display: flex;
}
.faq_item__left{
  width: 80px;
  font: 700 32px/48px 'Montserrat';
  color: #ffffff;
}
.faq_item__right{
  flex-grow: 1;
  flex-basis: 0;
}
.faq_answer{
  font: 22px/35px 'Montserrat';
  color: #1B1B1B;
  padding-top: 24px;
}
.faq_item__top{
  display: flex;
}
.faq_item__question{
  padding-top: 7px;
  flex-grow: 1;
  flex-basis: 0;
  font: 700 28px/34px 'Montserrat';
  color: #FBB03B;
}
.faq_item__btn{
  width: 48px;
  height: 48px;
  background: #ffffff;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #000000;
  font-size: 30px;
}
.faq_item.opened{
  background: #FBB03B;
}
.faq_item.opened .faq_item__question{
  color: #000000;
}
.faq_item.opened .faq_item__left{
  color: #000000;
}
.faq_item.opened .faq_item__btn{
  background: #000000;
  color: #ffffff;
  transform: rotate(45deg);
}
</style>