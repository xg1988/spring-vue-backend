<template>
  <div id="app-home">
    <Header />
    <main class="app-content">
      <!-- 여기에 메인 콘텐츠를 추가하세요 -->
       <!--{{ result }}<button @click="test()">테스트</button>-->
      <div v-if="!isLogin">
        <login-button-component/>
      </div>
      <div v-else>
        <span> {{ userInfo.nickname }} 님 환영합니다.</span>
      </div>
      
      <divider/>
        
       <h3>메인 화면 배너 리스트</h3>
       <SwiperComponent/>
       
       <divider/>
       <h3>메인 화면 카테고리 리스트</h3>
       <image-grid-component/>
       <divider/>
       <h3>메인 화면 아이템 리스트</h3>
       <item-list-component/>
    </main>
    <Footer />
  </div>
</template>

<script>
import axios from '../axios'; // Axios 인스턴스 가져오기
import Header from '../components/base/AppHeader.vue';
import Footer from '../components/base/AppFooter.vue';
import SwiperComponent from '../components/base/Swiper.vue'
import ImageGridComponent from '../components/base/ImageGrid.vue'
import ItemListComponent from '../components/base/ItemList.vue'
import LoginButtonComponent from '../components/base/LoginButton.vue'
import AdsenseAd from '../components/AdsenseAd.vue';
import {checkLogin} from '../util/login';
import Divider from '../components/base/Divider.vue'
import {isEmptyObject} from '../util/common'


export default {
  name: 'App',
  components: {
    Header,
    Footer,
    SwiperComponent,
    ImageGridComponent,
    ItemListComponent,
    LoginButtonComponent,
    AdsenseAd,
    Divider
  },

  data() {
    return {
      result: 'default value'
      , userInfo: {}
      , isLogin: false
      , isLoading: false
    };
  },
  methods: {
    async getUserInfo(){
      this.isLoading = true;
      this.userInfo = await checkLogin()
      if(!isEmptyObject(this.userInfo)){
        this.isLogin = true
      }
      this.isLoading = false;
    }
  },
  mounted(){
    this.getUserInfo()
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

h3{
  margin-bottom: 10px;
  margin-top: 10px;
}
</style>