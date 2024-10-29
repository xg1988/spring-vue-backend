// src/axios.js
import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: '/',
  timeout: 10000, // 요청 타임아웃 설정
  withCredentials: true
});

// 요청 인터셉터 추가 (예: 토큰 추가)
// refresh token 세팅하는 시점은 더 테스트 해봐야할 듯 (config.headers['Authorization-refresh'] = `Bearer ${rToken}`;)
axiosInstance.interceptors.request.use((config) => {
  //const token = localStorage.getItem('access_token'); // 로컬 스토리지에서 토큰 가져오기
  const token = getCookie('accessToken')
  console.log('token : ' + token)

  const rToken = getCookie('refreshToken');
  console.log('rToken : ' + rToken)

  if (token) {
    config.headers['Authorization'] = `Bearer ${token}`;
  }
  return config;
}, (error) => {
  return Promise.reject(error);
});

// 응답 인터셉터 추가 (예: 에러 처리)
axiosInstance.interceptors.response.use(response => {
  return response;
}, error => {
  // 에러 처리 로직 추가 가능
  return Promise.reject(error);
});

// 쿠키에서 값 가져오기
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

export default axiosInstance;