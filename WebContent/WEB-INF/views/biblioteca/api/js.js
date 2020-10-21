function myfetch(url) {
    fetch(url).then(function(response) {
        response.json().then(function(data) {
           return data;
        }).catch(function(error) {
            return Error();
        })
    }).catch(function(error) {
        //document.getElementById('error').innerHTML += 'Qualcosa è andato storto:';
        //console.log(error);
        //console.log('test');
    })
}

function printLibro(url, htmlid) {
    let data = myfetch(url);
    document.getElementById(htmlid).innerHTML += data.title; 
}

function printLibri() {
    let data = myfetch('/OortSpring/api/libri');
    //document.getElementById(htmlid).innerHTML += data.title;
    console.log(data);
}