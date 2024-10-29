<template>
  <button class="login-button" @click="handleLogin">
    로그인 해보세요
  </button>
</template>

<script>
export default {
  name: 'LoginButton',
  methods: {
    handleLogin() {
      // 로그인 처리 로직을 여기에 추가하세요.
      this.$router.push('/login')
    },
  },
};
</script>

<style scoped>
.login-button {
  background-color: #0080ff; /* 버튼 배경색 */
  color: white; /* 글자색 */
  border: none; /* 테두리 없음 */
  padding: 10px 20px; /* 상하 좌우 여백 */
  text-align: center; /* 텍스트 중앙 정렬 */
  text-decoration: none; /* 텍스트 장식 없음 */
  display: inline-block; /* 인라인 블록 */
  font-size: 0.98rem; /* 글자 크기 */
  margin: 4px 2px; /* 여백 */
  cursor: pointer; /* 커서 모양 */
  border-radius: 5px; /* 모서리 둥글게 */
  transition: background-color 0.3s; /* 배경색 변화 애니메이션 */
  width: 100%;
}

.login-button:hover {
  background-color: #1d8eff; /* 마우스 오버 시 배경색 */
}
</style>
