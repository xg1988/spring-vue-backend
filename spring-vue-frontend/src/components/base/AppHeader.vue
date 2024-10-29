<template>
  <LoadingSpinner :isLoading="isLoading" />
  <header class="app-header">
    <div class="app-title">공통 서비스 템플릿</div>
    <div class="icon-container">
      <button class="icon-button">🔔</button>
      <button class="icon-button">☰</button>
    </div>
  </header>
</template>

<script>
import LoadingSpinner from './LoadingSpinner.vue';

export default {
  name: 'Header',
  components: {
    LoadingSpinner
  },

};
</script>

<style scoped>
.app-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #f5f5f5;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.app-title {
  font-size: 20px;
  font-weight: bold;
}

.icon-container {
  display: flex;
}

.icon-button {
  background: none;
  border: none;
  font-size: 24px;
  cursor: pointer;
  margin-left: 10px;
}
</style>
