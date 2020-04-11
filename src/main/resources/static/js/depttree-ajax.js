function getdept() {
    $("#dept-get-tree").click(function () {
     $.ajax({
         url:"/dept/getdeptlist.json",
         type:"Get",
         success:function (result) {
             if (!result==null) {
                 alert(result.length)
                 return ;
             }
         }
     })
    })
}