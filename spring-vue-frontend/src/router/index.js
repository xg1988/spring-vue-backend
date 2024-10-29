import { createRouter, createWebHistory } from 'vue-router'

// 연결할 각 컴포넌트 import (src/views폴더 아래 컴포넌트들 생성해둠)
import MainView from '../views/Main.vue'
import LoginView from '../views/Login.vue'
import HomeView from '../views/Home.vue'
import SignUpView from '../views/SignUp.vue'
import SettingsView from '../views/Settings.vue'

// 라우터 설계
const routes = [
    { path: '/', component:HomeView},
    { path: '/main', component:MainView},
    { path: '/login', component:LoginView},
    { path: '/oauth/sign-up', component:SignUpView},
    { path: '/sign-up', component:SignUpView},
    { path: '/settings', component:SettingsView}
]

// 라우터 생성
const router = createRouter({
    history: createWebHistory(),
    routes
});

// 라우터 추출 (main.js에서 import)
export {router}