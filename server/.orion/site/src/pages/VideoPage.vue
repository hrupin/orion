<template>
  <div class="page_title page_title__news">
    <div class="container_1200">
      <h1 class="page_title__h1">Відео</h1>
      <Breadcrumb :items="breadcrumb" />
    </div>
  </div>
  <section class="video_section">
    <div class="container_850">
      <div class="video_list">
        <div class="video_item">
          <vue-plyr :options="playerOptions">
            <video controls crossorigin playsinline>
              <source src="/video/1.mp4" type="video/mp4" />
            </video>
          </vue-plyr>
          <div class="video_item__info">
            <div class="video_item__name">відео з навчань дронів</div>
            <div class="video_item__date">15 Жовтня, 2025</div>
          </div>
        </div>
        <div class="video_item">
          <vue-plyr :options="playerOptions">
            <video controls crossorigin playsinline>
              <source src="/video/1.mp4" type="video/mp4" />
            </video>
          </vue-plyr>
          <div class="video_item__info">
            <div class="video_item__name">військове злагодження</div>
            <div class="video_item__date">15 Жовтня, 2025</div>
          </div>
        </div>
      </div>
      <PaginationComponent/>
    </div>
  </section>
</template>

<script>
import Breadcrumb from "@/components/Breadcrumb";
import PaginationComponent from "@/components/Pagination";

export default {
  name: "VideoPage",
  components: {PaginationComponent, Breadcrumb},
  data() {
    return {
      breadcrumb: [
        { label: 'Відео' }
      ],
      playerOptions: {
        controls: ['play-large', 'play', 'progress', 'current-time', 'mute', 'volume', 'fullscreen'],
        autoplay: false
      }
    }
  },
}
</script>

<style scoped>
.video_item__info{
  padding: 20px;
  background: #1B1B1B;
}
.video_item__name{
  font: 24px/24px 'Montserrat';
  color: #ffffff;
  margin-bottom: 12px;
  text-transform: uppercase;
}
.video_item__date{
  font: 12px/24px 'Montserrat';
  color: #ffffff;
}
</style>