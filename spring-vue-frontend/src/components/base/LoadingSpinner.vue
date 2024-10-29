<template>
  <div v-if="isLoading" class="loading-spinner">
    <img :src="spinnerSrc" alt="Loading..." />
  </div>
</template>

<script>
export default {
  props: {
    isLoading: {
      type: Boolean,
      required: true
    },
    spinnerSrc: {
      type: String,
      default: 'https://i.gifer.com/4V7u.gif' // 기본 로딩 이미지 URL
    }
  }
};
</script>

<style scoped>
.loading-spinner {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 9999;
}

.loading-spinner img {
  width: 100px; /* 로딩 이미지 크기 조정 */
}
</style>
