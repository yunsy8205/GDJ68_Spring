
const list = document.getElementById("list");

list.addEventListener("click", function(){
    let xhttp = new XMLHttpRequest(); // 생성자 호출

    //open("메서드형식", "url")
    xhttp.open("GET", "./list?page=1");

    //send
    xhttp.send();

    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            console.log(this.responseText)//응답 데이터를 resposeText에 담음
        }
    }
    //상태번호(200,500,400)가 바뀔때
    //4wayhandshaking 클라이언트와 서버간에 4번 요청과 응답을 주고 받음
    //statechange가 4번 발생


})