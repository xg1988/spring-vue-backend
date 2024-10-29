<template>
  <div class="loginbox">

 
  <div class="login-container">
        <h2>회원가입</h2>

        <!-- ID/Password 로그인 폼 -->
        <div v-if="!isOAuth">
        <label for="email">이메일</label>
            <input v-model="email" type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>

            <label for="password">비밀번호</label>
            <input v-model="password" type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required minlength="6">
        </div>

            <label for="nickname">닉네임</label>
            <input v-model="nickname" type="text" id="nickname" name="nickname" placeholder="닉네임 입력하세요" required>

            <button @click="signup()">회원가입</button>
            <span class="signup-link">로그인으로</span>

        <!-- 구분선 -->
        <!--<div class="divider">또는</div>-->

        <!-- OAuth 로그인 버튼들 -->
        <!--<div class="oauth-buttons">
            <a href="/oauth2/authorization/google" class="google">Google로 회원가입</a>
            <a href="/oauth2/authorization/naver" class="naver">Naver으로 회원가입</a>
            <a href="/oauth2/authorization/kakao" class="kakao">Kakao로 회원가입</a>
        </div>-->
    </div>
     </div>
</template>

<script>
import axios from '../axios'; // Axios 인스턴스 가져오기

export default {
  data() {
    return {
      email: '',
      password: '',
      nickname: '',
      isOAuth: false
    };
  },
  
  created() {
    const currentUrl = window.location.pathname;
    console.log('currentUrl : ' + currentUrl)
    if(currentUrl.includes('/oauth')){
        this.isOAuth = true
    }
  },

  methods: {
    async signup() {
      try {
        const response = await axios.post('/sign-up', {
          email: this.email,
          password: this.password,
          nickname: this.nickname,
          isOAuth: ((this.isOAuth)? 'Y': 'N'),
        }
        );
        if(response.data === '회원가입 성공'){
            alert('회원가입이 완료 되었습니다!')
            this.$router.push('/login?signUpYn=Y'); // 홈 페이지로 리디렉션
        }

        // 로그인 후 원하는 페이지로 이동
        //this.$router.push('/login'); // 홈 페이지로 리디렉션

      } catch (error) {
        console.error('회원가입 실패:', error);
        alert('회원가입 실패했습니다. 다시 시도해주세요.');
      }
    }
  }
};
</script>

<style>
*{
    box-sizing: border-box;
  margin: 0;
}
.loginbox{
  padding: 0;
  background-color: #f9f9f9;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.login-container {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 350px;
    text-align: center;
}

.login-container h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
}

.login-container form {
    margin-bottom: 15px;
}

.login-container label {
    display: block;
    font-size: 14px;
    margin-bottom: 5px;
    text-align: left;
}

.login-container input {
    width: 100%;
    padding: 12px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 16px;
}

.login-container button {
    width: 100%;
    padding: 14px;
    margin-bottom: 15px;
    background-color: #006eff;
    border: none;
    color: white;
    font-size: 16px;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.login-container button:hover {
    background-color: #45a049;
}

.oauth-buttons {
    display: flex;
    flex-direction: column;
}

.oauth-buttons a {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    padding: 12px;
    margin-bottom: 10px;
    font-size: 16px;
    color: white;
    text-decoration: none;
    border-radius: 8px;
    transition: background-color 0.3s ease;
}

.oauth-buttons a.google {
    background-color: #db4437;
}

.oauth-buttons a.google:hover {
    background-color: #c23321;
}

.oauth-buttons a.naver {
    background-color: #00c73c;
}

.oauth-buttons a.naver:hover {
    background-color: #00c73c;
}

.oauth-buttons a.kakao {
    background-color: #ffcd00;
    color: black;
}

.oauth-buttons a.kakao:hover {
    background-color: #e4b800;
}

.divider {
    margin: 20px 0;
    display: flex;
    align-items: center;
    text-align: center;
}

.divider::before, .divider::after {
    content: '';
    flex: 1;
    border-bottom: 1px solid #ddd;
}

.divider::before {
    margin-right: 10px;
}

.divider::after {
    margin-left: 10px;
}

@media (max-width: 600px) {
    .login-container {
        padding: 20px;
    }

    .login-container h2 {
        font-size: 22px;
    }

    .login-container input, .login-container button, .oauth-buttons a {
        padding: 10px;
        font-size: 14px;
    }
}
        .signup-link {
            display: block;
            margin-top: 10px;
            color: #007bff;
            text-decoration: none;
        }
</style>