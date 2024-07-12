function jsx() {
    return(
        // React.Fragment: 렌더링 X
        <>
            <h1 className="className">Todo List</h1>
            <ul style={{ backgroundColor: "black", color:"pink"}}>
                <li>Bus</li>
                <li>Metro</li>
                <li>Walk</li>
            </ul>
        </>          
    );
}

export default jsx