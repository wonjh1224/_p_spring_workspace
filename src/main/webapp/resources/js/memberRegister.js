console.log("memberRegister.js in!");

document.getElementById('checkBtn').addEventListener('click', (e)=>{
    let email = document.getElementById('email');
    console.log(email);
    document.getElementById("hiddenEmail").value = email.value;
    
    validationEmail(email.value).then(result=>{
        if(result === "1"){
            alert("이미 존재하는 이메일 입니다.")
            email.value = "";
            email.focus();
       }else{
        alert("이메일 사용 가능")
       }
    })
})

async function validationEmail(email){
    try {
        const resp = await fetch("/member/"+email);
        const result = await resp.text();
        return result;
    } 
    catch (error) {
        console.log(error);
    }
}

document.getElementById('change').addEventListener('click',()=>{
    document.getElementById('regBtn').disabled = false;
})


document.addEventListener('input', (e) =>{
    let email = document.getElementById('hiddenEmail').value;
    let pwd = document.getElementById('pwd').value;
    let pwdCheck =document.getElementById("pwdCheck").value;
    let nickName = document.getElementById('nickName').value;


    console.log(email, pwd, pwdCheck, nickName);

    if(email.length > 0 && pwd.length >0 && nickName.length > 0 && pwd == pwdCheck){
        document.getElementById('regBtn').disabled = false;
    }else{
        document.getElementById('regBtn').disabled = true;
    }
})
