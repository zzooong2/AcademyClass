// import PrintWorld from "./components/01_PrintWorld";
import { Link } from "react-router-dom";

// CSS
import "./styles/App.css";

function App() {
  return (
    // 태그는 무조건 하나만 사용가능 
    // React Fragment: 태그 안에 빈칸으로 사용 가능 <div> -> <>
    <div>
      <ul>
        <li>
          <Link to="/" className="erase-underline">Home</Link>
        </li>
        <li>
          <Link to="/RouterPage" className="erase-underline">02_RouterPage</Link>
        </li>
        <li>
          <Link to="/QueryString?name=김현중&age=19" className="erase-underline">03_QueryString</Link>
        </li>
        <li>
          <Link to="/PathVariable/김현중" className="erase-underline">04_PathVariable</Link>
        </li>
        <li>
          <Link to="/JSX" className="erase-underline">05_JSX</Link>
        </li>
        <li>
          <Link to="/PropsPage" className="erase-underline">06_Props</Link>
        </li>
        <li>
          <Link to="/RenderPage" className="erase-underline">06_Rendering</Link>
        </li>
        <li>
          <Link to="/Event" className="erase-underline">07_Event</Link>
        </li>
      </ul>

      <hr />
      <h1>Ex1 실습 문제 </h1>
      <ul>
        <li>
          <Link to="/Training/AboutPage" className="erase-underline">Ex01_AboutPage</Link>
        </li>
        <li>
          <Link to="/Training/AddrPage?addr=안양" className="erase-underline">Ex01_AddrPage</Link>
        </li>
        <li>
          <Link to="/Training/NamePage/김현중" className="erase-underline">Ex01_NamePage</Link>
        </li>
      </ul>

      <hr />
      <h1>Ex2 실습 문제 </h1>
      <ul>
        <li>
          <Link to="/InlinePage" className="erase-underline">Ex02_InlinePage</Link>
        </li>
        <li>
          <Link to="/OutStyle" className="erase-underline">Ex02_OutStyleSheetPage</Link>
        </li>
      </ul>

    </div>
  );
}

export default App
