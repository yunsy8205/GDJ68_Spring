 
const btn2 = document.getElementById("btn2");
const fileList = document.getElementById("fileList");
const deletes = document.getElementsByClassName("deletes");

//------------------------------------------
// 새로운 div 내에서
for(del of deletes){
    del.addEventListener("click", function(){
        let num = this.getAttribute("data-delete-num");
        let check = confirm("삭제시 복구 불가");

        if(check){
            fetch("./fileDelete?fileNum="+num, {method:"get"})
                .then((result)=>{return result.text()})
                .then((r)=>{
                    if(r.trim()=='1'){
                        console.log(this.previousSibling.previousSibling.remove());
                        //previousSibling 한번 올라간다는 의미
                        this.remove();
                        count--;
                    }
                })// 쉼표는 더하기
        }
    });
}


let max =5;

let count = 0;
if(deletes != null){
    count=deletes.length;
    max=3;
}

let idx=0;
// 부모한테 이벤트를 걸고 그 이벤트를 새로 생긴 자식한테 위임해 준다.
fileList.addEventListener("click", function(event){//event 객체를 받음
    let cl = event.target.classList; //대상에 어떤 클래스들이 있는지
    if(event.target.classList.contains("df")){// 클래스명에 df가 있는 경우라면
        let deleteId = event.target.getAttribute("data-id");// "data-id"속성의 값을 꺼냄
        document.getElementById(deleteId).remove(); //아이디로 부모 div를 선택해서 삭제
        count--;
    }
})

btn2.addEventListener("click", function(){
    if(count<max){
        let d = document.createElement("div");
        let t = document.createAttribute("class");
        let input = document.createElement("input");
        
        t.value="input-group mb-3";
        d.setAttributeNode(t);
        
        let e = document.createAttribute("id");
        e.value="file"+idx;
        d.setAttributeNode(e);
        
        t = document.createAttribute("type");
        t.value="file";
        input.setAttributeNode(t);
        t = document.createAttribute("name");
        t.value="photos";
        input.setAttributeNode(t);
        t = document.createAttribute("id");
        t.value="pic";
        input.setAttributeNode(t);
        t = document.createAttribute("class");
        t.value="form-control";
        input.setAttributeNode(t);
        d.appendChild(input);
        
        let s = document.createElement("span");
        let a = document.createTextNode("x");
        s.appendChild(a);
        t = document.createAttribute("class");
        t.value="df";
        s.setAttributeNode(t);
        t = document.createAttribute("data-id");
        t.value="file"+idx;
        s.setAttributeNode(t);
        d.appendChild(s);
        //span태그도 div태그와 비슷하지만 인라인타입이다.
        fileList.appendChild(d);
        
        idx++;
        count++;
    }else{
        if(deletes != null){
            alert("파일추가는 세개 이하로만 가능합니다.")
        }else{
            alert("파일추가는 다섯개 이하로만 가능합니다.")

        }
    }
})
