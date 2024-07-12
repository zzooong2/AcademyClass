import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'

import router from './router/config/RouterContig.jsx'

// router 사용하기 위해 필요한 함수
import { RouterProvider } from 'react-router-dom'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router}>
      <App />
    </RouterProvider>
  </React.StrictMode>,
)
