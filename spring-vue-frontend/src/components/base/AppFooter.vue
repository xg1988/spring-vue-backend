<template>
  <footer class="app-footer">
    <button class="footer-button">🏠</button>
    <button class="footer-button">🔍</button>
    <button class="footer-button">⭐</button>
    <button class="footer-button">⚙️</button>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
};
</script>

<style scoped>
.app-footer {
  display: flex;
  justify-content: space-around;
  padding: 10px 0;
  background-color: #f5f5f5;
  border-top: 1px solid #ddd;
}

.footer-button {
  background: none;
  border: none;
  font-size: 24px;
  cursor: pointer;
}
</style>
