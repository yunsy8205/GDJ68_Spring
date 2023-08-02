let del = document.getElementById("del");

let bookNum;

//1.함수이용
function setBookNum(num){
    bookNum=num;
}

del. addEventListener("click", function(){
    let result = confirm("삭제하시겠습니까?");
    if(result){
        console.log(del.id);
        //console.log(del.data-delete-num);// 그냥 가져오면 에러 발생됨
        console.log(del.getAttribute("data-delete-num"));
        bookNum=del.getAttribute("data-delete-num");
        let parameterName=del.getAttribute("data-delete-name");

        location.href="./delete?"+parameterName+"="+bookNum;
    }
})