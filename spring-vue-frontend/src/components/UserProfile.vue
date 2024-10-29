<template>
  <div class="profile-section">
    <h2>프로필 정보</h2>
    <p>이름: {{ user.name }}</p>
    <p>이메일: {{ user.email }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {
        name: '홍길동',
        email: 'honggildong@example.com'
      }
    };
  }
};
</script>

<style scoped>
.profile-section {
  padding: 20px;
  background-color: #ffffff;
  margin-bottom: 20px;
  border: 1px solid #eaeaea;
  border-radius: 5px;
}
</style>
