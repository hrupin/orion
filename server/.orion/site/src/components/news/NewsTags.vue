<template>
  <div class="news_tags">
    <div class="news_tags__title"><span>Теги</span></div>
    <div class="news_tags_list">
      <a href="#" class="news_tag">Lorem ispum</a>
      <a href="#" class="news_tag">Lorem ispum</a>
      <a href="#" class="news_tag">Lorem ispum</a>
      <a href="#" class="news_tag">Lorem ispum</a>
    </div>
  </div>
</template>

<script>
export default {
name: "NewsTags"
}
</script>

<style scoped>
.news_tags{
  margin-bottom: 32px;
}
.news_tags__title{
  font: 18px/24px 'Montserrat';
  color: #666666;
  border-bottom: 1px solid #2B2B2B;
  padding: 14px 10px;
  text-transform: uppercase;
}
.news_tags__title span{
  position: relative;
}
.news_tags__title span:before{
  content: '';
  position: absolute;
  left: 0;
  right: 0;
  bottom: -16px;
  background: #FBB03B;
  height: 1px;
}
.news_tags_list{
  padding: 32px 0;
  display: flex;
  flex-wrap: wrap;
}
.news_tag{
  border: 1px solid  #FFFFFF33;
  background: #1B1B1B;
  font: 12px/17px 'Montserrat';
  color: #9C9C9C;
  margin: 0 8px 8px 0;
  padding: 5px 14px;
  transition: 0.2s all;
}
.news_tag:hover{
  color: #FBB03B;
}
</style>