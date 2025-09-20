<template>
  <nav class="pagination">
    <ul>
      <li>
        <a href="#" class="prev">
          <svg width="5" height="13" viewBox="0 0 5 13" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M4.10073 3.6821C4.14452 3.72589 4.16641 3.77624 4.16641 3.83317C4.16641 3.89009 4.14452 3.94044 4.10073 3.98423L1.51945 6.56551L4.10073 9.14679C4.14452 9.19058 4.16641 9.24094 4.16641 9.29786C4.16641 9.35479 4.14452 9.40514 4.10073 9.44893L3.77232 9.77734C3.72853 9.82112 3.67818 9.84302 3.62125 9.84302C3.56433 9.84302 3.51397 9.82112 3.47019 9.77734L0.409431 6.71658C0.365644 6.67279 0.34375 6.62244 0.34375 6.56551C0.34375 6.50859 0.365644 6.45823 0.409431 6.41445L3.47019 3.35369C3.51397 3.3099 3.56433 3.28801 3.62125 3.28801C3.67818 3.28801 3.72853 3.3099 3.77232 3.35369L4.10073 3.6821Z" fill="white"/>
          </svg>
      </a>
      </li>
      <li><a href="#">1</a></li>
      <li><a href="#" class="active">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li>
        <a href="#" class="next">
          <svg width="5" height="13" viewBox="0 0 5 13" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M4.2101 6.41445C4.25389 6.45823 4.27579 6.50859 4.27579 6.56551C4.27579 6.62244 4.25389 6.67279 4.2101 6.71658L1.14935 9.77734C1.10556 9.82112 1.0552 9.84302 0.998281 9.84302C0.941357 9.84302 0.891001 9.82112 0.847214 9.77734L0.518806 9.44893C0.475019 9.40514 0.453125 9.35479 0.453125 9.29786C0.453125 9.24094 0.475019 9.19058 0.518806 9.14679L3.10009 6.56551L0.518806 3.98423C0.475019 3.94044 0.453125 3.89009 0.453125 3.83317C0.453125 3.77624 0.475019 3.72589 0.518806 3.6821L0.847214 3.35369C0.891001 3.3099 0.941357 3.28801 0.998281 3.28801C1.0552 3.28801 1.10556 3.3099 1.14935 3.35369L4.2101 6.41445Z" fill="white"/>
          </svg>
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
name: "PaginationComponent"
}
</script>

<style scoped>
  .pagination ul{
    display: flex;
    align-items: center;
    margin-left: -4px;
    margin-right: -4px;
  }
  .pagination ul li{
    padding: 0 4px;
  }
  .pagination ul li a{
    height: 34px;
    width: 34px;
    border: 1px solid #FFFFFF33;
    display: flex;
    align-items: center;
    justify-content: center;
    font: 12px/12px 'Montserrat';
    color: #ffffff;
  }
  .pagination ul li a.active{
    background: #FBB03B;
  }
</style>