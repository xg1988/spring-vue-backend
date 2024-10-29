<template>
  <div id="app-home">
    <Header />
    <main class="app-content">
      <!-- 여기에 메인 콘텐츠를 추가하세요 -->
       {{ result }}<button @click="test()">테스트</button>
    </main>
    <Footer />
  </div>
</template>

<script>
import axios from '../axios'; // Axios 인스턴스 가져오기
import Header from '../components/base/AppHeader.vue';
import Footer from '../components/base/AppFooter.vue';

export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },

  data() {
    return {
      result: 'default value'
    };
  },
  methods: {
    async test() {
      try {
        const response = await axios.get('/jwt-test', {
          
        });

        this.result = response.data; // 서버에서 받은 토큰
      } catch (error) {
        //console.error('로그인 실패:', error);
        alert(' 실패했습니다. 다시 시도해주세요.');
      }
    }
  }
};
</script>

<style>
#app-home {
  display: flex;
  flex-direction: column;
  height: 100vh;
}

.app-content {
  flex: 1;
  padding: 20px;
}
</style>