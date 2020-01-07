function msg(){
    alert("Hello three.js");
}

function sleepFor( sleepDuration ){
    var now = new Date().getTime();
    while(new Date().getTime() < now + sleepDuration){ /* do nothing */ }
}

sleepFor(1500);
console.log("hello three.js sleep !");