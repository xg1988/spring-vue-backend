<template>
  <div class="grid-container">
    <div class="grid-item" v-for="(item, index) in items" :key="index">
      <img :src="item.image" :alt="item.name" class="grid-image" />
      <p class="grid-title">{{ item.name }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ImageGrid',
  data() {
    return {
      items: [
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
        { image: 'https://via.placeholder.com/150?text=Image+1', name: '이미지 1' },
      ],
    };
  },
};
</script>

<style scoped>
.grid-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr); /* 4열 */
  gap: 20px; /* 아이템 사이 간격 */
  padding: 20px;
}

.grid-item {
  text-align: center; /* 이미지와 이름 중앙 정렬 */
}

.grid-image {
  width: 100%; /* 이미지 너비 100% */
  height: auto; /* 비율 유지 */
  border-radius: 8px; /* 모서리 둥글게 */
}

.grid-title {
  margin-top: 8px; /* 제목과 이미지 사이 여백 */
  font-size: 16px;
  font-weight: bold;
}
</style>
