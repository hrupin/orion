<template>
  <div class="news_archive">
    <div class="news_archive__title"><span>Архів</span></div>
    <a href="#" class="news_archive__link">
      <span class="news_archive__calendar"></span>Травень 2025
    </a>
    <a href="#" class="news_archive__link">
      <span class="news_archive__calendar"></span>Травень 2025
    </a>
    <a href="#" class="news_archive__link">
      <span class="news_archive__calendar"></span>Травень 2025
    </a>
    <a href="#" class="news_archive__link">
      <span class="news_archive__calendar"></span>Травень 2025
    </a>
    <a href="#" class="news_archive__link">
      <span class="news_archive__calendar"></span>Травень 2025
    </a>
  </div>
</template>

<script>
export default {
name: "NewsArchive"
}
</script>

<style scoped>
.news_archive{
  margin-bottom: 32px;
}
.news_archive__title{
  font: 18px/24px 'Montserrat';
  color: #666666;
  border-bottom: 1px solid #2B2B2B;
  padding: 14px 10px;
  text-transform: uppercase;
}
.news_archive__title span{
  position: relative;
}
.news_archive__title span:before{
  content: '';
  position: absolute;
  left: 0;
  right: 0;
  bottom: -16px;
  background: #FBB03B;
  height: 1px;
}
.news_archive__link{
  font: 18px/24px 'Montserrat';
  color: #666666;
  border-bottom: 1px solid #2B2B2B;
  padding: 14px 10px;
  display: flex;
  align-items: center;
  transition: 0.2s;
}
.news_archive__link:hover{
  color: #999999;
}
.news_archive__calendar{
  height: 15px;
  width: 15px;
  background: url("../../assets/img/icon_calendar.svg") no-repeat center center;
  margin-right: 8px;
}
</style>