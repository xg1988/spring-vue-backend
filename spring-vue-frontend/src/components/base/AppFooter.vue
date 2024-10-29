<template>
  <footer class="app-footer">
    <button class="footer-button" @click="goPage('/')">🏠</button>
    <button class="footer-button" @click="goPage('/search')">🔍</button>
    <button class="footer-button" @click="goPage('/bookmark')">⭐</button>
    <button class="footer-button" @click="goPage('/settings')">⚙️</button>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
  methods:{
    goPage(path){
      this.$router.push(path); // 홈 페이지로 리디렉션
    }
  }
};
</script>

<style scoped>
.app-footer {
    display: flex;
    justify-content: space-around;
    padding: 10px 0;
    background-color: #f5f5f5;
    border-top: 1px solid #ddd;
    position: fixed; /* 고정 위치 */
    left: 0;
    bottom: 0;
    width: 100%; /* 전체 너비 */
}

.footer-button {
  background: none;
  border: none;
  font-size: 24px;
  cursor: pointer;
}
</style>
