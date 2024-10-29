import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/': {
        target: 'http://localhost:8080', // 실제 API 서버 URL
        changeOrigin: true,
        //rewrite: (path) => path.replace(/^\/api/, ''), // 필요에 따라 경로 재작성
      },
    },
  },
})
