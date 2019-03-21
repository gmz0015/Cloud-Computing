function getUserNameList(){
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState==4){
            //接受XML数据
            var x = xmlhttp.responseXML;
            var admin = x.getElementsByTagName('admin');
            for(var i=0;i<admin.length;i++){
                var user = admin[i].
                getElementsByTagName('name')[0].innerHTML;//不管DOM树是否标准，都是DOM
                document.getElementById('d').innerHTML += user+'<br>';
            }
        }
    }
    xmlhttp.open("GET","HelloWorld",true);
    xmlhttp.send();
}

function getUserInfo(userid){
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            console.log(xmlhttp.responseText);
            var jsonobj= eval('(' + xmlhttp.responseText + ')');
            document.getElementById("username").innerHTML=jsonobj.username;
            document.getElementById("email").innerHTML=jsonobj.email;
            document.getElementById("birthday").innerHTML=jsonobj.birthday;
        }
    }
    xmlhttp.open("GET","getUserInfo?type=find&userid="+userid,true);
    xmlhttp.send();

}