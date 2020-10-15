"use strict";

function getQueryField(selector){
    let selection = selector.value;
    console.log(selection);

    if (selection === 'titolo' || selection === 'autore' || selection === 'editore'){
        document.getElementById("query").type = 'text';
    } else if (selection === 'annoPubblicazione'){
        document.getElementById("query").type = 'date';
    } else if (selection === 'id'){
        document.getElementById("query").type = 'number';
    }
    document.getElementById('queryDiv').style.removeProperty('display');
}

function isValidText(query){
    return /^[a-zA-Z0-9_. -]*$/.test(query);
}

function validateForm(){
    console.log("Validating...")
    let queryForm = document.getElementById('query').type;
    if (queryForm.type === 'text'
        && !isValidText(queryForm.value)){
        document.getElementById('queryErr').innerHTML = "Hai inserito caratteri non validi.";
        console.log("Not valid...")
        return false;
    } else{
        console.log("Valid")
        return true
    }
}

function cleanErrors(){
    document.getElementById('queryErr').innerHTML = null;
}