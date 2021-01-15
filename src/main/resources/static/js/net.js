

netFun=function(url,data,successCallback,errorCallback){
$.ajax({
    //几个参数需要注意一下
    type: "POST",//方法类型
    dataType: "json",//预期服务器返回的数据类型
    url: url,
    //data: $('#form1').serialize(),
    data:toJson(data),
    contentType: "application/json",
    success: function (result) {
        successCallback(result);
        // console.log(result);//打印服务端返回的数据(调试用)
        // if (result.resultCode == 200) {
        //     alert("SUCCESS");
        // }
        //
        // ;
        //
        //
        // console.log(result.msg);
        // window.location.href=result.msg;
    },
    error : function(result) {
        errorCallback(result);
        // console.log(result);
        // var my=result.responseText;
        // console.log(my);
        // //       window.location.href=my
        // // alert("异常！"+result);

    }
});
}

toJson=function (obj) {
   return JSON.stringify(obj);
}