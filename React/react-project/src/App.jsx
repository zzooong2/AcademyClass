// import PrintWorld from "./components/01_PrintWorld";
import { Link } from "react-router-dom";

function App() {
  return (
    // 태그는 무조건 하나만 사용가능 
    // React Fragment: 태그 안에 빈칸으로 사용 가능 <div> -> <>
    <div>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/RouterPage">02_RouterPage</Link>
        </li>
        <li>
          <Link to="/QueryString">03_QueryString</Link>
        </li>
        <li>
          <Link to="/PathVariable">04_PathVariable</Link>
        </li>
      </ul>
    </div>
  );
}

export default App
