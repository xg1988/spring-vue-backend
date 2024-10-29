<template>
  <div class="menu-section">
    <h2>설정 메뉴</h2>
    <ul>
      <li @click="navigateTo('profile')">내 정보 확인</li>
      <li @click="navigateTo('change-password')">비밀번호 변경</li>
      <li @click="navigateTo('notifications')">알림</li>
      <li @click="logout">로그아웃</li>
      <li @click="navigateTo('customer-service')">고객센터 (QnA)</li>
    </ul>
  </div>
</template>

<script>
export default {
  methods: {
    navigateTo(page) {
      console.log(`Navigating to ${page}`);
    },
    logout() {
      console.log('Logging out...');
    }
  }
};
</script>

<style scoped>
.menu-section {
  padding: 20px;
  background-color: #ffffff;
  border: 1px solid #eaeaea;
  border-radius: 5px;
}
.menu-section ul {
  list-style-type: none;
  padding: 0;
}
.menu-section li {
  cursor: pointer;
  margin: 10px 0;
  color: #007aff;
}
.menu-section li:hover {
  text-decoration: underline;
}
</style>
