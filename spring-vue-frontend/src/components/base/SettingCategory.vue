<template>
  <div class="settings-category">
    <h2>{{ title }}</h2>
    <a
      v-for="(item, index) in items"
      :key="index"
      :href="item.link"
      class="settings-item"
    >
      <img :src="item.icon" alt="아이콘" />
      <div class="text">
        <h3>{{ item.title }}</h3>
        <p>{{ item.description }}</p>
      </div>
      <div class="arrow">&#9654;</div>
    </a>
  </div>
</template>

<script>
export default {
  name: 'SettingsCategory',
  props: {
    title: {
      type: String,
      required: true,
    },
    items: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.settings-category {
  margin-bottom: 20px;
}

.settings-category h2 {
  margin: 0 0 10px;
  font-size: 20px;
  color: #333;
  border-bottom: 2px solid #000000;
  padding-bottom: 5px;
}

.settings-item {
  display: flex;
  align-items: center;
  padding: 15px 0;
  border-bottom: 1px solid #ddd;
  text-decoration: none;
  color: #333;
  transition: background-color 0.3s;
}

.settings-item:last-child {
  border-bottom: none;
}

.settings-item:hover {
  background-color: #f9f9f9;
}

.settings-item img {
  width: 30px;
  height: 30px;
  margin-right: 15px;
}

.settings-item .text {
  flex: 1;
}

.settings-item .text h3 {
  margin: 0;
  font-size: 16px;
}

.settings-item .text p {
  margin: 5px 0 0;
  font-size: 14px;
  color: #666;
}

.settings-item .arrow {
  font-size: 18px;
  color: #999;
}
</style>
