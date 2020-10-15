function filter(field, inputBar){
    console.log("Filtering...")
    console.log(field + " " + inputBar);
    let input, filter, td;
    input = document.getElementById(inputBar.id);
    filter = input.value.toUpperCase();
    td = document.getElementsByClassName(field);

    console.log("Input: " + filter)

    for (let i = 0; i < td.length; i++) {
        console.log("Looping")
        if (td[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            td[i].parentElement.style.display = "";
        } else {
            td[i].parentElement.style.display = "none";
            console.log("Removing element.")
        }
    }
}
// Nota: Filtrare per più campi contemporaneamente apre le porte per infiniti bug e problemi