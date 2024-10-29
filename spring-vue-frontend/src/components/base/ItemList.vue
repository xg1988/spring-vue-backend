<template>
  <div class="item-list">
    <div class="item" v-for="(item, index) in items" :key="index">
      <div class="item-image">
        <img v-if="item.image" :src="item.image" alt="대표 이미지" />
        <div v-else class="placeholder">{{ item.initial }}</div>
      </div>
      <div class="item-details">
        <h3 class="item-name">{{ item.name }}</h3>
        <p class="item-description">{{ item.description }}</p>
        <div class="item-info">
          <span class="item-distance">거리: {{ item.distance }}km</span>
          <span class="item-extra">{{ item.info }}</span>
        </div>
      </div>
      <button class="like-button" @click="toggleLike(item)">
        {{ item.liked ? '❤️' : '♡' }} 좋아요
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ItemList',
  data() {
    return {
      items: [
        { image: 'https://via.placeholder.com/50?text=Img1', name: '아이템 1', description: '설명 1', distance: 1.2, info: '정보 1', liked: false },
        { initial: 'A', name: '아이템 2', description: '설명 2', distance: 2.5, info: '정보 2', liked: false },
        { image: 'https://via.placeholder.com/50?text=Img3', name: '아이템 3', description: '설명 3', distance: 0.5, info: '정보 3', liked: false },
        { initial: 'B', name: '아이템 4', description: '설명 4', distance: 3.1, info: '정보 4', liked: false },
      ],
    };
  },
  methods: {
    toggleLike(item) {
      item.liked = !item.liked;
    },
  },
};
</script>

<style scoped>
.item-list {
  padding: 20px;
}

.item {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
  padding: 15px;
  border: 1px solid #e1e1e1;
  border-radius: 8px;
  background-color: #fff;
  transition: box-shadow 0.3s;
}

.item:hover {
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.item-image {
  margin-right: 15px;
}

.item-image img {
  width: 50px;
  height: 50px;
  border-radius: 5px;
}

.placeholder {
  width: 50px;
  height: 50px;
  background-color: #ccc;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 5px;
  font-weight: bold;
  color: white;
}

.item-details {
  flex: 1;
}

.item-name {
  font-size: 16px;
  margin: 0;
  font-weight: bold;
}

.item-description {
  margin: 5px 0;
  font-size: 14px;
  color: #666;
}

.item-info {
  display: flex;
  justify-content: space-between;
  font-size: 12px;
  color: #999;
}

.item-distance {
  margin-right: 10px;
}

.like-button {
  background: none;
  border: none;
  cursor: pointer;
  font-size: 16px;
  color: #ff4081;
}
</style>
