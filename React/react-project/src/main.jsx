import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
// jsx 파일 가져오기
import RouterPage from './pages/02_RouterPage.jsx'
import QueryString from './pages/03_QueryString.jsx'
import PathVariable from './pages/04_PathVariable.jsx'

// router 사용하기 위해 필요한 함수
import { createBrowserRouter, RouterProvider } from 'react-router-dom'

// 경로설정
const router = createBrowserRouter([
  {
    path: "/", // URL 경로
    element: <App />, // 해당 URL로 왔을 때 이동할 페이지}
  },
  {
    path: "/RouterPage", // URL 경로
    element: <RouterPage />, // 해당 URL로 왔을 때 이동할 페이지}
  },
  {
    path: "/QueryString", // URL 경로
    element: <QueryString />, // 해당 URL로 왔을 때 이동할 페이지}
  },
  {
    path: "/PathVariable/:value", // URL 경로
    element: <PathVariable />, // 해당 URL로 왔을 때 이동할 페이지}
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router}>
      <App />
    </RouterProvider>
  </React.StrictMode>,
)
