<template>
   <swiper
    :slides-per-view="1"
    :space-between="30"
    :pagination="{ clickable: true }"
    :modules="modules"
    :loop="true"
    :autoplay="{ delay: 3000, disableOnInteraction: false }"
    class="mySwiper"
  >
    <swiper-slide v-for="(slide, index) in slides" :key="index">
      <img :src="slide.image" :alt="`Image ${index + 1}`" />
    </swiper-slide>
  </swiper>
</template>

<script>
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';
import 'swiper/css/pagination';
  // import required modules
  import { Pagination } from 'swiper/modules';

export default {
  name: 'SwiperComponent',
  components: {
    Swiper,
    SwiperSlide,
    Pagination,
  },
  data() {
    return {
      slides: [
        { image: 'https://via.placeholder.com/600x300?text=Image+1' },
        { image: 'https://via.placeholder.com/600x300?text=Image+2' },
        { image: 'https://via.placeholder.com/600x300?text=Image+3' },
        { image: 'https://via.placeholder.com/600x300?text=Image+4' },
        { image: 'https://via.placeholder.com/600x300?text=Image+5' },
      ],
    };
  },
  setup() {
      return {
        modules: [Pagination],
      };
    },
};
</script>

<style scoped>
.mySwiper {
  width: 100%;
  height: 230px; /* 원하는 높이로 조정 */
}

.mySwiper img {
  width: 100%;
  height: auto; /* 이미지 비율 유지 */
}
</style>
