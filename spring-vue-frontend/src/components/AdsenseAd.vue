<template>
  <div class="adsense-container">
    <ins
      class="adsbygoogle"
      :style="{ display: 'block' }"
      :data-ad-client="adClient"
      :data-ad-slot="adSlot"
      :data-ad-format="adFormat"
      :data-ad-layout="adLayout"
    ></ins>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';

// Props를 통해 AdSense 속성을 받음
const props = defineProps({
  adClient: {
    type: String,
    required: true,
  },
  adSlot: {
    type: String,
    required: true,
  },
  adFormat: {
    type: String,
    default: "auto",
  },
  adLayout: {
    type: String,
    default: "in-article",
  },
});

// 광고를 로드하는 함수
const loadAds = () => {
  if (window.adsbygoogle) {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }
};

// 컴포넌트가 마운트될 때 광고를 로드
onMounted(() => {
  loadAds();
});
</script>

<style scoped>
.adsense-container {
  margin: 20px 0;
}
</style>
