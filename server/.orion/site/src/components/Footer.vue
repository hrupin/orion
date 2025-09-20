<template>
  <footer class="footer">
    <div class="footer_top">
      <div class="container_1200">
        <div class="footer_logo">
          <img src="@/assets/img/logo_dark.svg" alt="">
        </div>
        <div class="footer_info">
          <div class="footer_info__block">
            <div class="footer_info__title">Рекрутинг</div>
            <div class="footer_info__contact">м.Київ | 063 448 48 48</div>
            <div class="footer_info__email">recruting@orion.ua</div>
          </div>
          <div class="footer_info__block">
            <div class="footer_info__title">Рекрутинг</div>
            <div class="footer_info__contact">м.Київ | 063 448 48 48</div>
            <div class="footer_info__email">пресцентр</div>
          </div>
          <div class="footer_info__block">
            <div class="footer_info__title">приєднуйся</div>
            <div class="footer_soc_list">
              <a href="#" class="footer_soc_item">
                <span>
                  <svg width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M14.1182 13.1384H16.6182L17.6182 9.13837H14.1182V7.13837C14.1182 6.10837 14.1182 5.13837 16.1182 5.13837H17.6182V1.77837C17.2922 1.73537 16.0612 1.63837 14.7612 1.63837C12.0462 1.63837 10.1182 3.29537 10.1182 6.33837V9.13837H7.11816V13.1384H10.1182V21.6384H14.1182V13.1384Z" fill="white"/>
                </svg>
                </span>
              </a>
              <a href="#" class="footer_soc_item">
                <span>
                  <svg width="24" height="25" viewBox="0 0 24 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M10 14.6384L15.19 11.6384L10 8.63837V14.6384ZM21.56 6.80837C21.69 7.27837 21.78 7.90837 21.84 8.70837C21.91 9.50837 21.94 10.1984 21.94 10.7984L22 11.6384C22 13.8284 21.84 15.4384 21.56 16.4684C21.31 17.3684 20.73 17.9484 19.83 18.1984C19.36 18.3284 18.5 18.4184 17.18 18.4784C15.88 18.5484 14.69 18.5784 13.59 18.5784L12 18.6384C7.81 18.6384 5.2 18.4784 4.17 18.1984C3.27 17.9484 2.69 17.3684 2.44 16.4684C2.31 15.9984 2.22 15.3684 2.16 14.5684C2.09 13.7684 2.06 13.0784 2.06 12.4784L2 11.6384C2 9.44837 2.16 7.83837 2.44 6.80837C2.69 5.90837 3.27 5.32837 4.17 5.07837C4.64 4.94837 5.5 4.85837 6.82 4.79837C8.12 4.72837 9.31 4.69837 10.41 4.69837L12 4.63837C16.19 4.63837 18.8 4.79837 19.83 5.07837C20.73 5.32837 21.31 5.90837 21.56 6.80837Z" fill="white"/>
                  </svg>
                </span>
              </a>
              <a href="#" class="footer_soc_item">
                <span>
                  <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_23_4278)">
                      <path d="M19.4981 2.17775L1.27278 9.24219C0.539356 9.57117 0.291293 10.23 1.09551 10.5875L5.77109 12.0811L17.0761 5.05827C17.6933 4.61739 18.3252 4.73496 17.7815 5.21995L8.07203 14.0566L7.76704 17.7963C8.04953 18.3737 8.56679 18.3764 8.89674 18.0894L11.583 15.5345L16.1836 18.9973C17.2522 19.6332 17.8336 19.2229 18.0635 18.0574L21.0811 3.69477C21.3944 2.2602 20.8601 1.62811 19.4981 2.17775Z" fill="white"/>
                    </g>
                    <defs>
                      <clipPath id="clip0_23_4278">
                        <rect width="20.5714" height="20.5714" fill="white" transform="translate(0.59668 0.754028)"/>
                      </clipPath>
                    </defs>
                  </svg>
                </span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer_bottom">
      <div class="container_1200">
        All Rights Reserved. Orion © 2025
      </div>
    </div>
  </footer>
</template>

<script>
export default {
name: "FooterComponent"
}
</script>

<style scoped>
  .footer_top{
    background: url("../assets/img/bg_footer.jpg") no-repeat 0 0;
    background-size: cover;
    padding: 32px 0;
  }
  .footer_logo{
    text-align: center;
  }
  .footer_info{
    display: flex;
    align-items: center;
    gap: 32px;
  }
  .footer_info__block{
    flex-basis: 0;
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 220px;

  }
  .footer_info__title{
    font: 500 14px/15px 'Montserrat';
    color: #000000;
    margin-bottom: 10px;
    text-transform: uppercase;
  }
  .footer_info__contact{
    font: 600 24px/28px 'Montserrat';
    color: #000000;
    padding: 8px;
  }
  .footer_info__email{
    font: 600 14px/15px 'Montserrat';
    color: #000000;
  }
  .footer_soc_list{
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 20px;
  }
  .footer_soc_item{
    width: 68px;
    height: 68px;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .footer_soc_item:before{
    content: '';
    width: 48px;
    height: 48px;
    background: #000000;
    position: absolute;
    left: 50%;
    top: 50%;
    z-index: 0;
    transform: translate(-50%, -50%) rotate(45deg);
  }
  .footer_soc_item span{
    position: relative;
    z-index: 2;
  }

  .footer_bottom{
    background: #1B1B1B;
    text-align: center;
    font: 12px/24px 'Montserrat';
    color: #FFFFFF;
    padding: 7px 0;
  }
</style>