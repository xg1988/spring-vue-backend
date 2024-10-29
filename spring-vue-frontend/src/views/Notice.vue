<template>
  <div class="notification">
    <h2>알림</h2>
    <div v-for="(item, index) in notifications" :key="index" class="notification-item">
      <div class="notification-title" @click="toggle(index)">
        <span>{{ item.title }}</span>
        <span class="arrow">{{ isOpen[index] ? '▲' : '▼' }}</span>
      </div>
      <div v-if="isOpen[index]" class="notification-content">
        {{ item.content }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      notifications: [
        { title: '알림 제목 1', content: '알림 내용 1입니다.' },
        { title: '알림 제목 2', content: '알림 내용 2입니다.' },
        { title: '알림 제목 3', content: '알림 내용 3입니다.' },
      ],
      isOpen: [], // 각 항목의 열림 상태를 관리하는 배열
    };
  },
  methods: {
    toggle(index) {
      this.$set(this.isOpen, index, !this.isOpen[index]); // 해당 인덱스의 상태 토글
    },
  },
};
</script>

<style scoped>
.notification {
  width: 100%;
  max-width: 600px;
  margin: auto;
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 16px;
  background-color: #f9f9f9;
}

.notification-item {
  border-bottom: 1px solid #eee;
}

.notification-title {
  display: flex;
  justify-content: space-between;
  cursor: pointer;
  padding: 10px 0;
}

.notification-content {
  padding: 10px 0 20px 0;
  background-color: #f1f1f1;
}
.arrow {
  font-size: 14px;
}
</style>
