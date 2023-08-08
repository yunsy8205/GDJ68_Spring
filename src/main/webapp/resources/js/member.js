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

let checkResults=[false,false,false,false,false,false,false];//배열을 이용할 수도있다.

id.addEventListener("blur", function(){
  
    fetch("./idtest?id="+id.value, {
        method:"get"
    })
    .then((response)=>{return response.text()
    })
    .then((r)=>{
        if(r.trim()=='1'){
        	out.innerHTML="이미 사용중인 아이디입니다.";
            out.className="f";
            checkResults[6]=false;
        }else{
        	alert("중복아님");
            if(id.value==""){
                out.innerText=" ID를 입력해주세요.";
                out.className="f";
                checkResults[0]=false;
                checkResults[6]=true;
            }else if(id.value.length>10){
                out.innerText=" 아이디는 10글자까지만 가능합니다.";
                out.className="f";
                checkResults[0]=false;
                checkResults[6]=true;
            }else{
                out.innerText="사용가능합니다.";
                out.className="s";
                checkResults[0]=true;
                checkResults[6]=true;
                
            }
        }
    })
    

});


pw.addEventListener("blur", function(){
    if(pw.value==""){
        out2.innerText=" PW를 입력해주세요.";
        out2.className="f";
        checkResults[1]=false;
    }else if(pw.value.length<6||pw.value.length>11){
        out2.innerText=" 비밀번호는 6글자이상 12글자미만입니다.";
        out2.className="f";
        checkResults[1]=false;
    }else{
        out2.innerText="사용가능합니다.";
        out2.className="s";
        checkResults[1]=true;
    }

});

pw.addEventListener("change", function(){
    //강제로 다 지우고, 입력하게 함
    pw2.value="";
    checkResults[2]=false;
    out3.innerText="";
    
})

pw2.addEventListener("keyup", function(){
    if(pw2.value==pw.value){
        out3.innerText=" 비밀번호가 일치합니다.";
        out3.className="s";
        checkResults[2]=true;
    }else{
        out3.innerText=" 비밀번호가 다릅니다.";
        out3.className="f";
        checkResults[2]=false;
    }
});

function emptyCheck(element){
    if(element.value==""){
        return true;
    }else{
        return false;
    }
}
name1.addEventListener("blur", function(){
    let check = emptyCheck(name1);

    if(check){
        out4.innerText=" 이름을 입력해주세요.";
        out4.className="f";
        checkResults[3]=false;
    }else{
        out4.innerText="";
        checkResults[3]=true;
    }
});

email.addEventListener("blur", function(){
    if(email.value==""){
        out5.innerText=" 이메일을 입력해주세요.";
        out5.className="f";
        checkResults[4]=false;
    }else{
        out5.innerText="";
        checkResults[4]=true;
    }
});

// 생일 체크
birth.addEventListener("blur",function(){
    let check = emptyCheck(birth);
    if(check){
        out6.innerText=" 생일을 입력해주세요.";
        out6.className="f";
        checkResults[5]=false;
    }else{
        out6.innerText="";
        checkResults[5]=true;
    }
})

btn.addEventListener("click", function(){
    let c = checkResults.includes(false);
    if(!c){
        //form 전송
        console.log("form 전송해");
       //frm.submit();
    }else{
        alert("필수 항목은 입력해");
    }
});


