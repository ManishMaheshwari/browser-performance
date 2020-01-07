function msg(){
    alert("Hello one.js");
}

function sleepFor( sleepDuration ){
    var now = new Date().getTime();
    while(new Date().getTime() < now + sleepDuration){ /* do nothing */ }
}

sleepFor(500);
console.log("hello one.js sleep !");