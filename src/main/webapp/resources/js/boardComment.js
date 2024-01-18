console.log("boardComment js in");
console.log("bno :", bnoVal);

document.getElementById("cmtAddBtn").addEventListener('click', ()=>{
    cmtText = document.getElementById('cmtText');
    console.log(cmtText.value);
    if(cmtText.value == null || cmtText.value == ''){
        alert("댓글을 입력해주세요");
        cmtText.focus();
        return false;
    }else{
        cmtData={
            bno : bnoVal,
            writer : document.getElementById('cmtWriter').innerText,
            content : cmtText.value
        };
        console.log("cvo :", cmtData);

        postCommentToServer(cmtData).then(result=>{
            if(result === '1'){
                alert("댓글 등록 성공");
                cmtText.value = '';
            }
        })
    };
})
async function postCommentToServer(cmtData){
    try {
        
        const url = "/comment/post";
        const config = {
            method : "post",
            headers : {
                'content-type':'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();

        return result;


    } catch (error) {
        console.log(error);
    }
}

async function getCommentListFromServer(bno){
    try {
        
        const resp = await fetch("/comment/"+bno);
        const result = await resp.json(); //commentList return
        console.log("list", result);
        return result;

    } catch (error) {
        console.log(error);
    }

}

function spreadCommentList(bno){
    getCommentListFromServer(bno).then(result=>{
        console.log(result);

 const div = document.getElementById('accordionExample');
        if(result.length > 0){
 
            for(let i=0; i<result.length; i++){
                let add = `<div class="accordion-item"> `;
                add += `<h2 class="accordion-header">`;
                add += ` <button class="accordion-button" type="button"`
                add += `data-bs-toggle="collapse" data-bs-target="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">`;
                add += `cno.${result[i].cno} 작성자 : ${result[i].writer}</button></h2>`;
                add += `<div id="collapse${i}" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">`;
                add += `<div class="accordion-body" data-cno="${result[i].cno}" data-writer="${result.writer}">`;
                add += `<input type="text" class="form-control cmtText" value="${result[i].content}"><br>`
                add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-success cmtModBtn" data-bs-toggle="modal" data-bs-target="#myModal">수정</button><span> | </span>`;
                add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">삭제</button>`
                add += `</div></div></div>`;
                div.innerHTML += add;
            }
        }else{
            div.innerHTML = `<div class="accordion-body">Comment List Empty</div>`;
        }
    })
}