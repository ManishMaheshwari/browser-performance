function msg(){
    alert("Hello two.js");
}
function sleepFor( sleepDuration ){
    var now = new Date().getTime();
    while(new Date().getTime() < now + sleepDuration){ /* do nothing */ }
}

sleepFor(2000);
console.log("hello two.js sleep !");