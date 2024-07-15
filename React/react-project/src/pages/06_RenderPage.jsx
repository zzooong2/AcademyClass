import Rendering from "../components/06_Rendering"

export default function RenderPage() {
    // const animals = ["dog", "cat", "pig"];
    const animals = [
        {name:"dog", age:3},
        {name:"cat", age:2}, 
        {name:"pig", age:1},
    ];

    return <Rendering animals={animals}></Rendering>
}