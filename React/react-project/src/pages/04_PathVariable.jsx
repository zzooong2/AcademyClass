import { useParams } from "react-router-dom";
import BackButton from "../components/common/BackButton";

function PathVariable() {
    const {value} = useParams();
    return (
        <>
            <p>경로 파라미터: {value}</p>
            <BackButton />
        </>
    )
}

export default PathVariable