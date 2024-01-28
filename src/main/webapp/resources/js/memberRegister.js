console.log("memberRegister.js in!");

document.getElementById('checkBtn').addEventListener('click', (e)=>{
    let email = document.getElementById('email').value
    console.log(email);
    getMemberListEmail().then(result=>{
        console.log("왜안됌?");
        console.log(result);
    })
})

async function getMemberListEmail(){

    try {
        const resp = await fetch("/member/email");
        const result = await resp.json();
        return result;
    } 
    catch (error) {
        console.log(error);
    }
}