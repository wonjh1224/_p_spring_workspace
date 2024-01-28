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
                spreadCommentList(bnoVal);
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
 div.innerHTML='';
        if(result.length > 0){
 
            for(let i=0; i<result.length; i++){
                let add = `<div class="accordion-item"> `;
                add += `<h2 class="accordion-header">`;
                add += ` <button class="accordion-button" type="button"`
                add += `data-bs-toggle="collapse" data-bs-target="#collapse${i}" aria-expanded="true" aria-controls="collapse${i}">`;
                add += `cno.${result[i].cno} 작성자 : ${result[i].writer}</button></h2>`;
                add += `<div id="collapse${i}" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">`;
                add += `<div class="accordion-body" data-cno="${result[i].cno}" data-writer="${result[i].writer}">`;
                add += `<input type="text" class="form-control cmtText" value="${result[i].content}" readonly="readonly"><br>`
                add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-success cmtModBtn" data-bs-toggle="modal" data-bs-target="#myModal">수정</button><span> | </span>`;
                add += `<button type="button" data-cno="${result[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">삭제</button>`
                add += `</div></div></div>`;
                div.innerHTML += add;
            }
        }else{
            div.innerHTML += `<div class="accordion-body">Comment List Empty</div>`;
        }
    })
}

document.addEventListener('click', (e)=>{
    console.log(e.target);
    if(e.target.classList.contains('cmtModBtn')){
        let div = e.target.closest('div');
        let cmtText = div.querySelector(".cmtText").value;
        console.log(cmtText);

        document.getElementById('cmtTextMod').value = cmtText;

        document.getElementById('cmtModBtn').setAttribute("data-cno", div.dataset.cno);
        document.getElementById('cmtModBtn').setAttribute("data-writer", div.dataset.writer);
        document.querySelector(".modal-title").innerText="cno."+div.dataset.cno+" 작성자:"+div.dataset.writer;
    }else if(e.target.id=="cmtModBtn"){
        let cmtDataMod = {
            cno : e.target.dataset.cno,
            writer : e.target.dataset.writer,
            content : document.getElementById('cmtTextMod').value
        };
        console.log(cmtDataMod);

        updateCommentToServer(cmtDataMod).then(result=>{
            if(result === '1'){
                alert("댓글 수정 성공")
                document.querySelector(".btn-close").click();
                spreadCommentList(bnoVal);
            }
        })
    }else if(e.target.classList.contains('cmtDelBtn')){
        let cno = e.target.dataset.cno;
        deleteCommentToServer(cno).then(result=>{
            if(result === '1'){
                alert("삭제 성공");
                spreadCommentList(bnoVal);
            }
        })

    }
})

async function updateCommentToServer(cmtDataMod){
    try {
        const url = "/comment/update";
        const config = {
            method : "post",
            headers : {
                'content-type':'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtDataMod)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();

        return result;
    } catch (error) {
        console.log(error);
    }

}

async function deleteCommentToServer(cno){
    try {
        const url = "/comment/"+cno;
        const config = {
            method : 'delete'
        }
        const resp = await fetch(url, config);
        const result = await resp.text();

        return result
    } catch (error) {
        console.log(error);
    }
}