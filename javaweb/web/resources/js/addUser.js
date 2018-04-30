$(function(){
})
function openAdduser(){
    document.getElementById('adduser').style.display='block';
    document.getElementById('fade').style.display='block'
}
function closeAdduser(){
    document.getElementById('adduser').style.display='none';
    document.getElementById('fade').style.display='none'
}
function deleteuser(){
    if(confirm("确定删除")){
        return true;
    }else{
        return false;
    }
}
