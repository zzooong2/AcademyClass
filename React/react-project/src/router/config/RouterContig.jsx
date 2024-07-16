import { createBrowserRouter } from "react-router-dom";

// jsx 파일 가져오기
import App from "../../App.jsx";
import RouterPage from '../../pages/02_RouterPage.jsx'
import QueryString from '../../pages/03_QueryString.jsx'
import PathVariable from '../../pages/04_PathVariable.jsx'
import JSX from"../../pages/05_JSX.jsx";

import AboutPage from "../../pages/training/Ex01_AboutPage.jsx";
import AddrPage from "../../pages/training/Ex01_AddrPage.jsx";
import NamePage from "../../pages/training/Ex01_NamePage.jsx";

import InlinePage from "../../pages/training/Ex2_InlinePage.jsx";
import OutStyle from "../../pages/training/Ex2_OutStyleSheetPage.jsx";
import PropsPage from "../../pages/06_PropsPage.jsx";
import Rendering from "../../pages/06_RenderPage.jsx"
import Event from "../../pages/07_EventPage.jsx"

// 경로설정
const router = createBrowserRouter([
    {
      path: "/", // URL 경로
      element: <App />, // 해당 URL로 왔을 때 이동할 페이지}
    },
    {
      path: "/RouterPage",
      element: <RouterPage />,
    },
    {
      path: "/QueryString",
      element: <QueryString />,
    },
    {
      path: "/PathVariable/:value",
      element: <PathVariable />,
    },

    // Ex1 실습 문제
    {
      path: "/Training/AboutPage",
      element: <AboutPage />,
    },
    {
      path: "/Training/AddrPage",
      element: <AddrPage />,
    },
    {
      path: "/Training/NamePage/:value",
      element: <NamePage />,
    },
    
    // JSX
    {
      path: "/JSX",
      element: <JSX />,
    },
    
    // Ex2 실습 문제
    {
      path: "/InlinePage",
      element: <InlinePage />,
    },
    {
      path: "/OutStyle",
      element: <OutStyle />,
    },
    
    // props
    {
      path: "/PropsPage",
      element: <PropsPage />,
    },
    {
      path: "/RenderPage",
      element: <Rendering />,
    },
    {
      path: "/Event",
      element: <Event />,
    },
    
  ]);


export default router;
  