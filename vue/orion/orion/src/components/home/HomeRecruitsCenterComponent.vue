<template>
  <section class="recruits_center">
    <div class="recruits_center_overlay">
      <div class="container_1200">
        <h2 class="home_h2 text-center">Про підрозділ</h2>
        <div class="rc_hotline">
          <div class="rc_text">Гаряча лінія: <a href="#">0 800 454 45 45</a></div>
          <a href="#" class="btn_yellow">Передзвони мені</a>
        </div>
        <div class="rc_info">
          <div class="rc_info_item" v-for="item in recruitmentCenter" :key="item.name">
            <div class="rc_info_item__name">{{item.name}}</div>
            <div class="rc_info_item__center">
              <div class="rc_info_item__adress">{{item.address}}</div>
              <div class="rc_info_item__vr"></div>
              <div class="rc_info_item__phone">{{item.phone}}</div>
            </div>
            <div class="rc_info__shedule">{{item.workSchedule}}</div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "HomeRecruitsCenterComponent",
  data() {
    return {
      recruitmentCenter: [
        {
          name: 'центр “СТОЛИЧНИЙ”',
          address: 'м.Київ',
          phone: '063 448 48 48',
          workSchedule: 'Графік роботи 08:00 - 18:00'
        },
        {
          name: 'центр “СТОЛИЧНИЙ”',
          address: 'м.Київ',
          phone: '063 448 48 48',
          workSchedule: 'Графік роботи 08:00 - 18:00'
        },
        {
          name: 'центр “СТОЛИЧНИЙ”',
          address: 'м.Київ',
          phone: '063 448 48 48',
          workSchedule: 'Графік роботи 08:00 - 18:00'
        }
      ]
    }
  },
}
</script>

<style scoped>
.recruits_center{
  background: url("../../assets/img/bg_rc.jpg") no-repeat center center;
  background-size: cover;
}
.recruits_center_overlay{
  padding: 100px 0;
  background: #121211E5;
}
.rc_hotline{
  padding: 16px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #000000;
  gap: 40px;
}
.rc_text{
  font: 600 22px/35px 'Montserrat';
  color: #ffffff;
}
.rc_text a{
  color: #FBB03B;
}
.rc_info_item{
  padding: 60px 0;
  border-bottom: 1px solid #FFFFFF1A;
  text-align: center;
}
.rc_info_item:last-child{
  border-bottom: none;
}
.rc_info_item__name{
  font: 500 14px/16px 'Montserrat';
  color: #ffffff;
  margin-bottom: 10px;
  text-transform: uppercase;
}
.rc_info_item__center{
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}
.rc_info_item__adress{
  font: 24px/36px 'Montserrat';
  color: #ffffff;
}
.rc_info_item__vr{
  width: 2px;
  height: 24px;
  background: #ffffff;
  margin: 0 12px;
}
.rc_info_item__phone{
  font: 24px/36px 'Montserrat';
  color: #FBB03B;
}
.rc_info__shedule{
  font: 12px/24px 'Montserrat';
  color: #ffffff;
}
</style>