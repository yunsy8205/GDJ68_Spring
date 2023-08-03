const id = document.getElementById("id");
const out = document.getElementById("out");
const pw = document.getElementById("pw");
const out2 = document.getElementById("out2");
const pw2 = document.getElementById("pw2");
const out3 = document.getElementById("out3");
const name1 = document.getElementById("name");
const out4 = document.getElementById("out4");
const email = document.getElementById("email");
const out5 = document.getElementById("out5");
const birth = document.getElementById("birth");
const out6 = document.getElementById("out6");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");


id.addEventListener("blur", function(){
    if(id.value==""){
        out.innerText=" ID를 입력해주세요.";
        out.className="f";
    }else if(id.value.length>10){
        out.innerText=" 아이디는 10글자까지만 가능합니다.";
        out.className="f";
    }else{
        out.innerText="사용가능합니다.";
        out.className="s";
    }

});

pw.addEventListener("blur", function(){
    if(pw.value==""){
        out2.innerText=" PW를 입력해주세요.";
        out2.className="f";
    }else if(pw.value.length<6||pw.value.length>11){
        out2.innerText=" 비밀번호는 6글자이상 12글자미만입니다.";
        out2.className="f";
    }else{
        out2.innerText="사용가능합니다.";
        out2.className="s";
    }

});

pw.addEventListener("keyup", function(){
    if(pw2.value!=""){
    
        if(pw2.value!=pw.value){
            out3.innerText=" 비밀번호가 다릅니다.";
            out3.className="f";
        }
    }
})

pw2.addEventListener("keyup", function(){
    if(pw2.value==pw.value){
        out3.innerText=" 비밀번호가 일치합니다.";
        out3.className="s";
    }else{
        out3.innerText=" 비밀번호가 다릅니다.";
        out3.className="f";
    }
});

name1.addEventListener("blur", function(){
    if(name1.value==""){
        out4.innerText=" 이름을 입력해주세요.";
    }else{
        out4.innerText="";
    }
});

email.addEventListener("blur", function(){
    if(email.value==""){
        out5.innerText=" 이메일을 입력해주세요.";
    }else{
        out5.innerText="";
    }
});

btn.addEventListener("click", function(){
    if(birth.value==""){
        out6.innerText=" 생일을 입력해주세요.";
    }else{
        out6.innerText="";
        frm.submit();
    }
});


