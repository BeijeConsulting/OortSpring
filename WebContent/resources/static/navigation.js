let user = null;

function navTo(selector){
	switch(selector){
        case "books":
            loadBooks();
            break;
        case "authors":
            loadAuthors();
            break;
        case "loans":
            loadLoans();
            break;
        case "publishers":
            loadPublishers();
            break;
        case "users":
            loadUsers();
            break;
        case "login":
            loadLogin();
            break;
        case "register":
            loadRegister();
            break;
        default:
            console.log("Something went wrong.");
    }
}

function loadBooks() {
    let content = document.getElementById("content");
    content.innerHTML = "";
    if(user == null) {
        content.innerHTML = "You have to login first!";
    }
    console.log("books");
}
function loadAuthors() {
    let content = document.getElementById("content");
    content.innerHTML = "";
    if(user == null) {
        content.innerHTML = "You have to login first!";
    }
    console.log("authors");
}
function loadLoans() {
    let content = document.getElementById("content");
    content.innerHTML = "";
    if(user == null) {
        content.innerHTML = "You have to login first!";
    }
    console.log("loans");
}
function loadPublishers() {
    let content = document.getElementById("content");
    content.innerHTML = "";
    if(user == null) {
        content.innerHTML = "You have to login first!";
    }
    console.log("publishers");
}
function loadUsers() {
    console.log("users");
}
function loadRegister() {
    console.log("register");
}
function loadLogin() {
    let content = document.getElementById("content");
    content.innerHTML = "";
    if(user == null) {
        let form = document.createElement("form");
        let email_label = document.createElement("label");
        let pswd_label = document.createElement("label");
        email_label.setAttribute("for","email");
        email_label.innerHTML = "E-mail:";
        pswd_label.setAttribute("for","password");
        pswd_label.innerHTML = "Password:";
        let email_field = document.createElement("input");
        email_field.setAttribute("type","email");
        email_field.setAttribute("name","email");
        let pswd_field = document.createElement("input");
        pswd_field.setAttribute("type","password");
        pswd_field.setAttribute("name","password");
        let submit = document.createElement("button");
        submit.setAttribute("onclick","login(" + email_field.value + "," + pswd_field.value +")");

        form.appendChild(email_label);
        form.appendChild(email_field);
        form.appendChild(pswd_label);
        form.appendChild(pswd_field);
        form.appendChild(submit);

        content.appendChild(form);
    } else {
        updateLogin();
    }
    console.log("login");
}

function updateLogin() {
    let content = document.getElementById("content");
    content.innerHTML = "Hello " + user.name + "!<br><br>";
    content.innerHTML += "Here there is your data:<br>";
    content.innerHTML += "First name:" + user.name + "<br>";
    content.innerHTML += "Last name:" + user.surname + "<br>";
    content.innerHTML += "E-mail:" + user.email + "<br>";
    content.innerHTML += "Phone n°:" + user.phone + "<br>";
    content.innerHTML += "Address:" + user.address + "<br>";
}

function check(email, pswd) {
    fetch("http://localhost:8080/OortSpring/login", {
        method: 'POST',
        header : {
            'content-type':'application/json'
        },
        body: JSON.stringify({
            'email': email,
            'password': pswd
        })
    })
        .then(response => response.json())
        .then(json => {user = json;})
        .then( () => updateLogin());
}