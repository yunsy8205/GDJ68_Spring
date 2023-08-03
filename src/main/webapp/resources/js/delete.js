const del = document.getElementById("del");
const c1 = document.getElementsByClassName("c1");
const frm = document.getElementById("frm");

for(c of c1){
    c.addEventListener("click", function(){
        let url = this.getAttribute("data-url");
        if(url=='delete'){
            let result = confirm("삭제하시겠습니까?");
            if(!result){
                return;//함수종료
            }

            frm.method='post';
        }

        frm.action=url;
        frm.submit(); //강제로 전송
    });
}

let bookNum;

//1.함수이용
function setBookNum(num){
    bookNum=num;
}

// del. addEventListener("click", function(){
//     let result = confirm("삭제하시겠습니까?");
//     if(result){
//         console.log(del.id);
//         //console.log(del.data-delete-num);// 그냥 가져오면 에러 발생됨
//         console.log(del.getAttribute("data-delete-num"));
//         //bookNum=del.getAttribute("data-delete-num");
//         //let parameterName=del.getAttribute("data-delete-name");
//         //location.href="./delete?"+parameterName+"="+bookNum;
//         frm.setAttribute("action","./delete");
//         console.log(frm.action);
//     }
// })