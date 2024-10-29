<template>
  <div>
    <div class="header">전체 메뉴</div>
    <button class="close-button" @click="closeSettings">X</button>

    <div class="settings-container">
      <SettingsCategory
        v-for="(category, index) in settingsCategories"
        :key="index"
        :title="category.title"
        :items="category.items"
      />
    </div>
  </div>
</template>

<script>
import SettingsCategory from '../components/base/SettingCategory.vue';

export default {
  name: 'Settings',
  components: {
    SettingsCategory,
  },
  methods: {
    closeSettings() {
      location.href = '/'
    }
  },
  data() {
    return {
      settingsCategories: [
        {
          title: '계정 설정',
          items: [
            {
              icon: 'https://via.placeholder.com/30',
              title: '프로필 수정',
              description: '프로필 사진과 정보를 업데이트합니다.',
              link: '#',
            },
            {
              icon: 'https://via.placeholder.com/30',
              title: '비밀번호 변경',
              description: '계정의 비밀번호를 변경합니다.',
              link: '#',
            },
          ],
        },
        /*{
          title: '알림 설정',
          items: [
            {
              icon: 'https://via.placeholder.com/30',
              title: '푸시 알림',
              description: '푸시 알림 설정을 관리합니다.',
              link: '#',
            },
            {
              icon: 'https://via.placeholder.com/30',
              title: '이메일 알림',
              description: '이메일 알림 설정을 관리합니다.',
              link: '#',
            },
          ],
        },
        {
          title: '개인정보 보호',
          items: [
            {
              icon: 'https://via.placeholder.com/30',
              title: '데이터 관리',
              description: '저장된 데이터를 관리합니다.',
              link: '#',
            },
            {
              icon: 'https://via.placeholder.com/30',
              title: '차단 사용자',
              description: '차단한 사용자를 관리합니다.',
              link: '#',
            },
          ],
        },
        {
          title: '앱 설정',
          items: [
            {
              icon: 'https://via.placeholder.com/30',
              title: '언어 설정',
              description: '앱의 표시 언어를 변경합니다.',
              link: '#',
            },
            {
              icon: 'https://via.placeholder.com/30',
              title: '테마 설정',
              description: '앱의 테마를 변경합니다.',
              link: '#',
            },
          ],
        },*/
      ],
    };
  },
};
</script>

<style scoped>
.header {
  background-color: #fff; /* 당근마켓의 대표 색상 */
  color: #000000;
  padding: 15px;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
}

.settings-container {
  max-width: 800px;
  margin: 20px auto;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

.close-button {
  position: absolute; /* 닫기 버튼을 우측 상단에 고정 */
  top: 17px;
  right: 15px;
  background: none;
  border: none;
  color: #000000;
  font-size: 20px;
  cursor: pointer;
  transition: color 0.3s;
}
</style>
