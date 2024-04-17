    function checkNumber() {
        const inputNumber = document.getElementById("number").value;
        const showText = document.getElementById("string");

        if(inputNumber == 0 || inputNumber >= 12){
            showText.innerText = "값이 너무 크거나 작습니다."
        } else {
            showText.innerText = inputNumber;
        }
    }

    function checkSeason() {
        const inputSeason = document.getElementById("season").value;
        const stringShow = document.getElementById("show");

        if(inputSeason >= 3 && inputSeason <= 5){
            stringShow.innerText = "spring";
            stringShow.style.color = "white";
            stringShow.style.backgroundColor = "green";
        } else if(inputSeason >= 6 && inputSeason <= 8){
            stringShow.innerText = "summer";
            stringShow.style.color = "white";
            stringShow.style.backgroundColor = "skyblue";
        } else if(inputSeason >= 9 && inputSeason <= 11){
            stringShow.innerText = "fall";
            stringShow.style.color = "white";
            stringShow.style.backgroundColor = "#795548";
        } else if(inputSeason == 12 || inputSeason == 2 || inputSeason == 1){
            stringShow.innerText = "winter";
            stringShow.style.color = "white";
            stringShow.style.backgroundColor = "gray";
        } else {
            stringShow.innerText = "해당하는 계절이 없습니다.";
        }
    }