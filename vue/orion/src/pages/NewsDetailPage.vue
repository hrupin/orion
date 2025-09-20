<template>
  <div class="page_title page_title__news">
    <div class="container_1200">
      <h1 class="page_title__h1">Останні здобутки підрозділу</h1>
      <Breadcrumb :items="breadcrumb" />
    </div>
  </div>
  <section class="news_list">
    <div class="container_1200">
      <div class="news_content">
        <div class="news_content__left">
          <div class="news_detail_page">
            <img class="news_detail__img" src="@/assets/img/img_big.jpg" alt="">
            <div class="news_detail__body">
              <div class="news_detail__category">Категорія 1</div>
              <h2>Останні здобутки підрозділу</h2>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu ante eget nisl convallis tempus. Phasellus ante lectus, tincidunt  tincidunt dui a, rhoncus interdum est. Sed molestie quis augue ac pulvinar. Pellentesque egoists sed tortor egestas pretium. Nam eget fermentum tellus, et fermentum diam. Mauris hendrerit, diam non commodo laoreet, est elit volutpat mauris, vel vehicula nisl orci id nibh. Pellentesque mollis convallis condimentum. Curabitur scelerisque tincidunt metus, non rutrum sem egestas etuisque.
              </p>
              <blockquote>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu ante eget nisl convallis tempus. Phasellus ante lectus, tincidunt  tincidunt dui a, rhoncus interdum est. Sed molestie quis augue ac pulvinar. Pellentesque egoists sed tortor egestas pretium. Nam eget fermentum tellus, et fermentum diam. Mauris hendrerit, diam non commodo laoreet, est elit volutpat mauris, vel vehicula nisl orci id nibh. Pellentesque mollis convallis condimentum. Curabitur scelerisque tincidunt metus, non rutrum sem egestas etuisque.
              </blockquote>
              <h3>Caveats Worth Mentioning</h3>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu ante eget nisl convallis tempus. Phasellus ante lectus, tincidunt  tincidunt dui a, rhoncus interdum est. Sed molestie quis augue ac pulvinar. Pellentesque egoists sed tortor egestas pretium. Nam eget fermentum tellus, et fermentum diam. Mauris hendrerit, diam non commodo laoreet, est elit volutpat mauris, vel vehicula nisl orci id nibh. Pellentesque mollis convallis condimentum. Curabitur scelerisque tincidunt metus, non rutrum sem egestas etuisque.
              </p>
              <h3>Caveats Worth Mentioning</h3>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu ante eget nisl convallis tempus. Phasellus ante lectus, tincidunt  tincidunt dui a, rhoncus interdum est. Sed molestie quis augue ac pulvinar. Pellentesque egoists sed tortor egestas pretium. Nam eget fermentum tellus, et fermentum diam. Mauris hendrerit, diam non commodo laoreet, est elit volutpat mauris, vel vehicula nisl orci id nibh. Pellentesque mollis convallis condimentum. Curabitur scelerisque tincidunt metus, non rutrum sem egestas etuisque.
              </p>

              <div class="news_detail__share">
                <div class="news_detail__share_title">Share This Post</div>
                <div class="news_detail__share_list">
                  <a href="#">
                    <svg width="9" height="15" viewBox="0 0 9 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M7.52499 1.03191V3.0549H6.32192C5.88259 3.0549 5.58629 3.14686 5.43303 3.33076C5.27978 3.51467 5.20315 3.79053 5.20315 4.15835V5.60663H7.44836L7.14951 7.87483H5.20315V13.6909H2.85832V7.87483H0.904297V5.60663H2.85832V3.93613C2.85832 2.98594 3.12396 2.24903 3.65525 1.7254C4.18654 1.20177 4.89408 0.93996 5.77786 0.93996C6.52882 0.93996 7.11119 0.970612 7.52499 1.03191Z" fill="white"/>
                    </svg>
                  </a>
                  <a href="#">
                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M12.7368 4.06628C12.3945 4.56692 11.9807 4.99349 11.4954 5.34598C11.5005 5.4175 11.5031 5.52478 11.5031 5.66782C11.5031 6.33193 11.406 6.99476 11.2119 7.65632C11.0178 8.31788 10.7227 8.95262 10.3268 9.56054C9.93091 10.1685 9.45965 10.7061 8.91303 11.1736C8.36641 11.641 7.70741 12.0139 6.93602 12.2923C6.16463 12.5708 5.33959 12.71 4.46092 12.71C3.0765 12.71 1.80958 12.3396 0.660156 11.5988C0.838956 11.6193 1.03819 11.6295 1.25786 11.6295C2.40728 11.6295 3.43155 11.277 4.33065 10.572C3.79426 10.5618 3.31405 10.3971 2.89004 10.0778C2.46603 9.75849 2.17484 9.35108 2.01648 8.85555C2.18506 8.8811 2.34087 8.89387 2.48391 8.89387C2.70358 8.89387 2.92069 8.86577 3.13525 8.80958C2.56309 8.69208 2.08928 8.40728 1.7138 7.95517C1.33832 7.50306 1.15058 6.97816 1.15058 6.38046V6.34981C1.49796 6.54393 1.87088 6.64866 2.26935 6.66398C1.93219 6.43921 1.66399 6.14547 1.46475 5.78276C1.26552 5.42005 1.1659 5.02669 1.1659 4.60268C1.1659 4.15313 1.27829 3.73678 1.50307 3.35364C2.1212 4.11481 2.87344 4.72401 3.75977 5.18123C4.64611 5.63844 5.59502 5.89259 6.60652 5.94368C6.56565 5.74955 6.54521 5.56054 6.54521 5.37663C6.54521 4.69208 6.78659 4.10843 7.26935 3.62567C7.75211 3.14291 8.33576 2.90153 9.02031 2.90153C9.73551 2.90153 10.3383 3.16207 10.8287 3.68314C11.3856 3.57586 11.9092 3.37663 12.3996 3.08544C12.2106 3.67292 11.8479 4.12759 11.3115 4.44942C11.7866 4.39834 12.2617 4.27063 12.7368 4.06628Z" fill="white"/>
                    </svg>
                  </a>
                  <a href="#">
                    <svg width="14" height="15" viewBox="0 0 14 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M6.05689 7.03958C6.05689 7.22348 6.13863 7.40356 6.30211 7.57981C6.46558 7.75605 6.66354 7.92974 6.89598 8.10088C7.12841 8.27202 7.35958 8.45976 7.58946 8.6641C7.81935 8.86844 8.01603 9.13409 8.1795 9.46103C8.34297 9.78798 8.42471 10.1507 8.42471 10.5492C8.42471 11.0089 8.30211 11.4508 8.05689 11.8748C7.68908 12.4981 7.15013 12.9566 6.44004 13.2503C5.72995 13.544 4.96877 13.6909 4.15651 13.6909C3.48218 13.6909 2.85255 13.5849 2.26762 13.3729C1.68269 13.1609 1.24463 12.8097 0.953447 12.3193C0.76443 12.0128 0.669922 11.6781 0.669922 11.3154C0.669922 10.9016 0.783587 10.5185 1.01092 10.166C1.23825 9.81352 1.54093 9.51978 1.91896 9.28479C2.58818 8.86589 3.62011 8.61046 5.01475 8.5185C4.85128 8.30395 4.72995 8.11493 4.65076 7.95145C4.57158 7.78798 4.53199 7.60152 4.53199 7.39207C4.53199 7.20816 4.58563 6.99105 4.69291 6.74073C4.45792 6.76116 4.28423 6.77138 4.17184 6.77138C3.41577 6.77138 2.77848 6.52489 2.25996 6.03191C1.74144 5.53894 1.48218 4.91442 1.48218 4.15835C1.48218 3.73945 1.57414 3.33332 1.75804 2.93996C1.94195 2.5466 2.19483 2.21199 2.51667 1.93613C2.91002 1.59896 3.37618 1.34865 3.91513 1.18517C4.45409 1.0217 5.00964 0.93996 5.5818 0.93996H8.78486L7.72739 1.61429H6.72356C7.10159 1.93613 7.38767 2.27585 7.5818 2.63345C7.77592 2.99105 7.87299 3.39973 7.87299 3.8595C7.87299 4.22732 7.81041 4.5581 7.68525 4.85184C7.56009 5.14558 7.40939 5.38313 7.23314 5.56448C7.05689 5.74584 6.87937 5.91186 6.70057 6.06257C6.52177 6.21327 6.36979 6.37036 6.24463 6.53383C6.11947 6.6973 6.05689 6.86589 6.05689 7.03958ZM4.93812 6.30395C5.13225 6.30395 5.33148 6.2618 5.53582 6.17751C5.74016 6.09322 5.90875 5.98211 6.04157 5.84417C6.31232 5.55299 6.4477 5.14686 6.4477 4.62578C6.4477 4.32949 6.40428 4.0102 6.31743 3.66793C6.23059 3.32566 6.1067 2.99488 5.94578 2.67559C5.78486 2.35631 5.56903 2.09194 5.29827 1.88249C5.02752 1.67304 4.72867 1.56831 4.40172 1.56831C4.18716 1.56831 3.97644 1.61812 3.76954 1.71774C3.56264 1.81736 3.39534 1.95146 3.26762 2.12004C3.02752 2.42144 2.90747 2.83013 2.90747 3.34609C2.90747 3.58108 2.93301 3.83013 2.9841 4.09322C3.03518 4.35631 3.11564 4.6194 3.22548 4.88249C3.33531 5.14558 3.46813 5.38185 3.62394 5.5913C3.77976 5.80075 3.97133 5.97189 4.19866 6.10471C4.42599 6.23753 4.67248 6.30395 4.93812 6.30395ZM4.95345 12.9936C5.24974 12.9936 5.53454 12.9604 5.80785 12.894C6.08116 12.8276 6.33403 12.728 6.56647 12.5951C6.79891 12.4623 6.98537 12.2758 7.12586 12.0357C7.26635 11.7956 7.33659 11.5172 7.33659 11.2005C7.33659 11.0728 7.31871 10.9476 7.28295 10.825C7.24719 10.7024 7.21015 10.5951 7.17184 10.5032C7.13352 10.4112 7.06456 10.3052 6.96494 10.1852C6.86532 10.0651 6.78997 9.97572 6.73889 9.91697C6.6878 9.85822 6.58946 9.7701 6.44387 9.6526C6.29827 9.53511 6.20504 9.46103 6.16417 9.43038C6.12331 9.39973 6.0173 9.3231 5.84617 9.2005C5.67503 9.07789 5.5818 9.01148 5.56647 9.00126C5.48474 8.99105 5.36213 8.98594 5.19866 8.98594C4.9279 8.98594 4.6597 9.00382 4.39406 9.03958C4.12841 9.07534 3.85383 9.13919 3.5703 9.23115C3.28678 9.3231 3.03902 9.4406 2.82701 9.58364C2.615 9.72668 2.44004 9.91697 2.30211 10.1545C2.16417 10.3921 2.09521 10.6615 2.09521 10.9629C2.09521 11.3205 2.18461 11.636 2.36341 11.9093C2.54221 12.1826 2.77592 12.3946 3.06456 12.5453C3.35319 12.696 3.65715 12.8084 3.97644 12.8825C4.29572 12.9566 4.62139 12.9936 4.95345 12.9936ZM11.1603 6.28096H12.7925V7.10854H11.1603V8.7867H10.3557V7.10854H8.73122V6.28096H10.3557V4.61812H11.1603V6.28096Z" fill="white"/>
                    </svg>
                  </a>
                  <a href="#">
                    <svg width="13" height="15" viewBox="0 0 13 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M7.95637 10.4724V12.0893C7.95637 12.4315 7.85676 12.6027 7.65752 12.6027C7.54003 12.6027 7.42508 12.5465 7.31269 12.4341V10.1276C7.42508 10.0152 7.54003 9.95899 7.65752 9.95899C7.85676 9.95899 7.95637 10.1301 7.95637 10.4724ZM10.5464 10.4801V10.8326H9.85676V10.4801C9.85676 10.1327 9.9717 9.95899 10.2016 9.95899C10.4315 9.95899 10.5464 10.1327 10.5464 10.4801ZM3.14411 8.80956H3.96404V8.08926H1.57323V8.80956H2.37783V13.1697H3.14411V8.80956ZM5.35101 13.1697H6.033V9.38427H5.35101V12.2808C5.19775 12.4954 5.05216 12.6027 4.91423 12.6027C4.82227 12.6027 4.76863 12.549 4.75331 12.4417C4.7482 12.4264 4.74564 12.337 4.74564 12.1735V9.38427H4.06365V12.3804C4.06365 12.6308 4.08409 12.8172 4.12495 12.9398C4.18626 13.1288 4.33441 13.2234 4.5694 13.2234C4.81461 13.2234 5.07515 13.0675 5.35101 12.7559V13.1697ZM8.63836 12.0356V10.526C8.63836 10.1531 8.61538 9.90024 8.5694 9.76742C8.48255 9.48134 8.3012 9.3383 8.02534 9.3383C7.76991 9.3383 7.53236 9.47623 7.31269 9.75209V8.08926H6.6307V13.1697H7.31269V12.8019C7.54258 13.0829 7.78013 13.2234 8.02534 13.2234C8.3012 13.2234 8.48255 13.0829 8.5694 12.8019C8.61538 12.664 8.63836 12.4085 8.63836 12.0356ZM11.2284 11.959V11.8594H10.5311C10.5311 12.1199 10.526 12.2757 10.5158 12.3268C10.48 12.5107 10.3778 12.6027 10.2092 12.6027C9.97425 12.6027 9.85676 12.4264 9.85676 12.0739V11.4073H11.2284V10.618C11.2284 10.2144 11.1594 9.91812 11.0215 9.7291C10.8223 9.46857 10.5515 9.3383 10.2092 9.3383C9.86186 9.3383 9.58856 9.46857 9.38932 9.7291C9.24628 9.91812 9.17476 10.2144 9.17476 10.618V11.9437C9.17476 12.3472 9.24884 12.6435 9.39699 12.8326C9.59622 13.0931 9.87208 13.2234 10.2246 13.2234C10.5924 13.2234 10.8682 13.088 11.0522 12.8172C11.1441 12.6793 11.1978 12.5414 11.2131 12.4034C11.2233 12.3575 11.2284 12.2093 11.2284 11.959ZM6.5694 4.96282V3.35362C6.5694 3.00113 6.45957 2.82489 6.2399 2.82489C6.02023 2.82489 5.9104 3.00113 5.9104 3.35362V4.96282C5.9104 5.32042 6.02023 5.49922 6.2399 5.49922C6.45957 5.49922 6.5694 5.32042 6.5694 4.96282ZM12.079 10.7176C12.079 11.913 12.0126 12.807 11.8797 13.3996C11.8082 13.701 11.6601 13.9539 11.4353 14.1582C11.2105 14.3626 10.95 14.4801 10.6537 14.5107C9.71372 14.618 8.29609 14.6716 6.40082 14.6716C4.50554 14.6716 3.08792 14.618 2.14794 14.5107C1.85165 14.4801 1.58983 14.3626 1.3625 14.1582C1.13517 13.9539 0.988301 13.701 0.92189 13.3996C0.789067 12.8274 0.722656 11.9334 0.722656 10.7176C0.722656 9.52221 0.789067 8.62821 0.92189 8.03562C0.99341 7.73421 1.14156 7.48134 1.36633 7.277C1.59111 7.07265 1.8542 6.9526 2.15561 6.91684C3.09047 6.81467 4.50554 6.76359 6.40082 6.76359C8.29609 6.76359 9.71372 6.81467 10.6537 6.91684C10.95 6.9526 11.2118 7.07265 11.4391 7.277C11.6665 7.48134 11.8133 7.73421 11.8797 8.03562C12.0126 8.60777 12.079 9.50177 12.079 10.7176ZM4.43147 0.939831H5.21308L4.28587 3.9973V6.07393H3.51959V3.9973C3.44807 3.61927 3.29226 3.07776 3.05216 2.37278C2.86314 1.8466 2.69711 1.36895 2.55407 0.939831H3.36633L3.9104 2.95516L4.43147 0.939831ZM7.26672 3.49155V4.83255C7.26672 5.24634 7.1952 5.54775 7.05216 5.73676C6.86314 5.9973 6.59239 6.12757 6.2399 6.12757C5.89762 6.12757 5.62943 5.9973 5.4353 5.73676C5.29226 5.54264 5.22074 5.24123 5.22074 4.83255V3.49155C5.22074 3.08287 5.29226 2.78402 5.4353 2.595C5.62943 2.33447 5.89762 2.2042 6.2399 2.2042C6.59239 2.2042 6.86314 2.33447 7.05216 2.595C7.1952 2.78402 7.26672 3.08287 7.26672 3.49155ZM9.83377 2.25018V6.07393H9.13645V5.65247C8.8657 5.9692 8.6026 6.12757 8.34718 6.12757C8.11218 6.12757 7.96148 6.03306 7.89507 5.84404C7.8542 5.72144 7.83377 5.52987 7.83377 5.26933V2.25018H8.53109V5.06244C8.53109 5.23102 8.53364 5.32042 8.53875 5.33064C8.55407 5.44302 8.60771 5.49922 8.69967 5.49922C8.8376 5.49922 8.98319 5.38938 9.13645 5.16971V2.25018H9.83377Z" fill="white"/>
                    </svg>
                  </a>
                  <a href="#">
                    <svg width="13" height="15" viewBox="0 0 13 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M3.28956 5.72913V13.323H0.760828V5.72913H3.28956ZM3.45048 3.3843C3.45559 3.75723 3.3266 4.06885 3.06351 4.31917C2.80042 4.56949 2.45431 4.69465 2.0252 4.69465H2.00987C1.59097 4.69465 1.2538 4.56949 0.998376 4.31917C0.742948 4.06885 0.615234 3.75723 0.615234 3.3843C0.615234 3.00627 0.74678 2.69337 1.00987 2.4456C1.27296 2.19784 1.61651 2.07396 2.04052 2.07396C2.46453 2.07396 2.80425 2.19784 3.05968 2.4456C3.31511 2.69337 3.44537 3.00627 3.45048 3.3843ZM12.3853 8.97051V13.323H9.86428V9.2617C9.86428 8.7253 9.76083 8.30512 9.55393 8.00116C9.34704 7.6972 9.02392 7.54522 8.58458 7.54522C8.26274 7.54522 7.99327 7.63334 7.77615 7.80959C7.55904 7.98583 7.39684 8.20422 7.28956 8.46476C7.23337 8.61802 7.20527 8.82491 7.20527 9.08545V13.323H4.6842C4.69442 11.2847 4.69953 9.63207 4.69953 8.36514C4.69953 7.09822 4.69697 6.34216 4.69186 6.09694L4.6842 5.72913H7.20527V6.83258H7.18995C7.29212 6.6691 7.39684 6.52606 7.50412 6.40346C7.6114 6.28085 7.75572 6.14803 7.93707 6.00499C8.11843 5.86195 8.34065 5.75084 8.60374 5.67166C8.86683 5.59247 9.1593 5.55288 9.48113 5.55288C10.3547 5.55288 11.0571 5.84279 11.5884 6.42262C12.1197 7.00244 12.3853 7.85173 12.3853 8.97051Z" fill="white"/>
                    </svg>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <NewsSidebar />
      </div>
    </div>
  </section>
</template>

<script>
import Breadcrumb from "@/components/Breadcrumb";
import NewsSidebar from "@/components/news/NewsSidebar";
import axios from "axios";

export default {
  name: "NewsDetailPage",
  components: {NewsSidebar, Breadcrumb},
  data() {
    return {
      breadcrumb: [
        { label: 'Новини', link: '/posts' },
        { label: 'Останні здобутки підрозділу' },
      ],
      categories: {
        type: Array,
        required: true
      },
      post: {}
    }
  },
  methods: {
    getNameByAlias(alias) {
      const category = this.categories.find(item => item.alias === alias)
      return category ? category.name : null
    },
    async fetchCategories() {
      try {
        const response = await axios.get('/api/categories');
        this.categories = response.data;
      } catch (error) {
        console.error('Error loading recruitment center data:', error);
      }
    }
  }
}
</script>

<style scoped>
.news_detail_page{
  font: 16px/26px 'Montserrat';
  color: #ffffff;
}
.news_detail_page p{
  margin-bottom: 24px;
}
.news_detail_page blockquote{
  margin-left: 48px;
  border-left: 2px solid #FBB03B;
  padding-left: 16px;
  position: relative;
  margin-bottom: 24px;
}
.news_detail_page h2{
  font: 24px/24px 'Montserrat';
  color: #ffffff;
  margin-bottom: 32px;
  text-transform: uppercase;
}
.news_detail_page h3{
  font: 14px/14px 'Montserrat';
  color: #ffffff;
  margin-bottom: 24px;
  text-transform: uppercase;
}
.news_detail_page blockquote:before{
  content: '';
  position: absolute;
  left: -48px;
  top: 0;
  width: 37px;
  height: 33px;
  background: url("../assets/img/icon_bq.svg") no-repeat 0 0;
}
.news_detail__img{
  height: 375px;
  width: 100%;
  object-fit: cover;
  object-position: center;
}
.news_detail__body{
  padding: 32px 64px;
  background: #1B1B1B;
}
.news_detail__category{
  font: 12px/24px 'Montserrat';
  color: #FBB03B;
  text-transform: uppercase;
  margin-bottom: 32px;
}
.news_detail__share{
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-top: 1px solid #FFFFFF1A;
  padding: 5px 0;
}
.news_detail__share_title{
  font: 500 14px/16px 'Montserrat';
  color: #666666;
  text-transform: uppercase;
}
.news_detail__share_list{
  display: flex;
  align-items: center;
}
.news_detail__share_list a{
  width: 32px;
  height: 32px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0 3px;
}
@media (max-width: 767px){
  .news_detail__body{
    padding: 32px 16px;
  }
}
</style>