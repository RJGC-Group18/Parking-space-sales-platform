<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.group18.po.Chat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>客服聊天</title>
    <link rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>

<body>


<!--聊天-->
<div class="tstart_toolbar">
    <div class="ico_nav">
        <div class="item_box item_box_01">
            <a href="javascript:void(0);" class="speak_btn" id="person_show_btn"><i class="i_ico"></i></a>
        </div>
        <div class="item_box">
            <a href="javascript:void(0);" class="goto_top" id="gototop_btn"><i class="i_ico"></i></a>
        </div>
    </div>

</div>

<!--客服列表-->
<div class="speak_person_list_box">
    <div class="speak_person_hd" id="speak_person_hd">
        <div class="personlist_title"><a href="javascript:void(0);" class="i_ico close_btn" id="close_personlist_btn"></a>联系客服</div>
        <div class="speak_personlist">
            <ul>
                <%  ArrayList<String> users =new ArrayList();
                    String userName = "root";//这里是你最开始刚下载mysql是输入的账号
                    String password = "123456";//这里是你最开始mysql设置的密码，
                    String url = "jdbc:mysql://localhost:3306/parkingsafesdb?useSSL=false&serverTimezone=Asia/Shanghai";
                    try {
                        //这里不用更改，如果你要连的不是mysql的话再换这个括号内的代码
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        System.out.println("驱动加载成功！");
                        Connection conn = DriverManager.getConnection(url, userName, password);
                        System.out.println("数据库连接成功！");

                        Statement statement = conn.createStatement();
                        ResultSet result1 = statement.executeQuery("select * from client where client.cid in(select DISTINCT cid from dealing where pay = 0) ORDER BY cid");
                        while (result1.next()) {
                            users.add(result1.getString("username"));
                        }
                        result1.last();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("驱动失败！");
                        System.out.println("数据库连接失败！");
                    }
                %>
                <%  for (int i = 0; i <users.size(); i++) {
                %>
                <li><i class="i_ico"></i><span><%=users.get(i)%></span></li>
                <%}%>

            </ul>
        </div>
    </div>
</div>
<!--聊天框-->
<div class="tool_speak_box">
    <div class="personlist_title" id="personlist_title_top" onselectstart="return false"><i class="i_ico person_ico"></i><a href="javascript:void(0);" class="i_ico close_btn close_btn2" id="tool_speak_box_close"></a> <span class="person_name" id="person_name_id"></span><em class="zt_txt"></em></div>
    <div class="tool_s_box_content">
        <div class="tool_s_b_l">
            <div class="tool_talkhistory">
                <ul>






                </ul>
            </div>




            <form name="frmApp" action="a.jsp" id="frmAppId" mothed="post"/>
            <input id="test" type="hidden" name="test">
            </form>




            <div class="tool_talkbar"><span class="talk_more"><a href="javascript:myfunction1()">聊天记录</a></span><a href="javascript:void(0)" id="biaoqing_more_btn"><i class="i_ico i_biaoqing"></i></a>
                <div class="biaoqing_box" id="biaoqing_box"> <i class="i_biaoqing"><img src="images/biaoqing/01.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/02.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/03.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/04.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/05.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/06.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/07.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/08.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/09.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/10.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/11.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/12.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/13.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/14.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/15.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/16.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/17.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/18.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/19.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/20.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/21.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/22.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/23.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/24.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/25.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/26.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/27.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/28.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/29.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/30.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/31.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/32.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/33.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/34.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/35.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/36.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/37.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/38.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/39.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/40.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/41.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/42.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/43.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/44.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/45.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/46.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/47.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/48.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/49.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/50.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/51.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/52.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/53.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/54.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/55.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/56.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/57.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/58.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/59.png" /></i> <i class="i_biaoqing"><img src="images/biaoqing/60.png" /></i> </div>
            </div>
            <div class="tool_talkinput" id="tool_talkinput">
                <div contentEditable ="true" class="textarea" data-content="" onclick="javascript:getCursortPosition(this)"></div>
                <!-- <textarea></textarea>-->
            </div>
            <div class="tool_talkfoot"> <span><a href="#">帮助?</a></span> <a href="javascript:void(0)" class="tool_talkbar goto_talk" id="goto_talk_btn">发送</a> </div>
        </div>
        <div class="tool_s_b_r">
            <div class="tool_s_b_r_box">
                <p><b>jingqixin</b><br />
                    来自：襄阳<br />
                    性别：保密<br />
                    注册时间：2010-6-12<br />
                    上次登录：2014-12-24<br />
                    卖家：卖家信用积分<br />
                    买家：买家信用积分</p>
            </div>
        </div>

    </div>
</div>


</div>
</body>
</html>
<script>
    //数据 分页
    var newlist1={
        id:Array("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"),
        tiele:Array("1新闻标题","2新闻标题","3新闻标题","4新闻标题","5新闻标题","6新闻标题","7新闻标题","8新闻标题","9新闻标题","10新闻标题","11新闻标题","12新闻标题","13新闻标题","14新闻标题","15新闻标题"),
        content:Array("1内容","2内容","3内容","4内容","5内容","6内容","7内容","8内容","9内容","10内容","11内容","12内容","13内容","14内容","15内容")
    }

    var newlist2={
        id:Array("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"),
        tiele:Array("1艺名消息","2艺名消息","3艺名消息","4艺名消息","5艺名消息","6艺名消息","7艺名消息","8艺名消息","9艺名消息","10艺名消息","11艺名消息","12艺名消息","13艺名消息","14艺名消息","15艺名消息"),
        content:Array("1内容","2内容","3内容","4内容","5内容","6内容","7内容","8内容","9内容","10内容","11内容","12内容","13内容","14内容","15内容")
    }



    var newlist=eval("newlist1");

    function Datatypelist(send){
        newlist=(eval(send));
        Datalist(count,zise,page);
    }

    var count=newlist.id.length-1;//总条数
    var zise=4;//分页条数
    var page=0;//页面索引

    Datalist(count,zise,page);

    function myfunction1(){

        $.ajax({
            type: "GET", //请求的方式，默认get请求
            url: "HandlerServlet", //请求地址，后台提供的
            data: {name:$("#person_name_id").text()},//data是传给后台的字段，后台需要哪些就传入哪些
            dataType: "text", //json格式，如果后台返回的数据为json格式的数据，那么前台会收到Object
            success: function(result){
                var j=0;
                var arr=result.split(/{/);
                for(j = 1; j < arr.length; j++) {
                    var arr1=arr[j].split(/"sender":"|","message":"|","receiver":"|","time":"|"}/);
                    if(arr1[2].substring(0,1) =="\\" ){
                        myfunction(arr1[1],arr1[4],Replace_img(arr1[2]));
                    }else{
                        myfunction(arr1[1],arr1[4],arr1[2]);
                    }
            }
            }
        })
    }
    window.boo=0;
function myfunction(name,time,message){
        var talk_li= "<li class=\"item_li\">"+
            "<p class=\"p_tit\"><span class=\"talk_name\">"+name+"</span><span class=\"talk_time\">"+time+"         </span></p>"+
            "<p class=\"p_content\">"+message+"</p></li>";
        $(".tool_talkhistory ul").append(talk_li);
    }






























    //分页函数
    function Datalist(count,zise,page)
    {

        if(page==0)
        {
            $(".pageFirst").addClass("pageFirst2");
            $(".pagePrev").addClass("pagePrev2");
        }
        else
        {
            $(".pageFirst").removeClass("pageFirst2");
            $(".pagePrev").removeClass("pagePrev2");
        }
        if(page==parseInt(count/zise))
        {
            $(".pageNext").addClass("pageNext2");
            $(".pageLast").addClass("pageLast2");
        }
        else
        {
            $(".pageNext").removeClass("pageNext2");
            $(".pageLast").removeClass("pageLast2");
        }

        var newliststr="";
        //alert(newlist.id.length);
        for(var i=page*zise; i<page*zise+zise;i++)
        {
            if(newlist.id[i]!=undefined)
            {
                newliststr+="<li><a href=\"javascript:void(0);\" data-id='"+newlist.id[i]+"'>"+newlist.tiele[i]+"</a></li>";
            }
        }
        $("#HsNewList ul").first().html(newliststr);
    }
    //luoyiming


    var ww=$(window).width();
    var wh=$(window).height();

    //返回顶部
    $("#gototop_btn").click(function(){
        $("html,body").animate({scrollTop:"0px"},400);
    });

    //艺名业务

    $(".quanbing_btn").click(function(){
        $(".hs_newslist").css({"width":ww-2,"height":wh,"top":0,"left":0});
        $(".hs_new_content").width(ww-4-141-230);
        $(".hs_new_type").height(wh-32);
        $(".hs_new_list").height(wh-32);
        $(".hs_new_content_box").height(wh-32);
        $(this).hide();
        $(".fangxiao_btn").show();
    });

    $(".fangxiao_btn").click(function(){
        var lt=ww*0.5-490; //326为聊天框宽度的一半
        var tp=wh*0.5-215;//210为聊天框高度的一半
        if(tp<0)
        {tp=0}
        $(".hs_newslist").css({"width":980,"height":432,"top":lt,"left":tp});
        $(".hs_new_content").width(608);
        $(".hs_new_type").height(400);
        $(".hs_new_list").height(400);
        $(".hs_new_content_box").height(380);
        $(this).hide();
        $(".quanbing_btn").show();
    });
    //
    $("#HsNewType_ul li a").click(function(){
        page=0;
        Datatypelist("newlist"+($(this).parent("li").index()+1));
        //alert(newlist2);
        $(this).addClass("select_a").parent().siblings("li").children("a").removeClass("select_a");
        var num=$(this).parent("li").index();
        //$("#HsNewList ul").hide().eq(num).show();
        $("#HsNewList .type_title").text($(this).text()+"列表");
        $("#HsNewsType").text($(this).text()+"-");
        $("#HsNew_title").text($("#HsNewList ul").eq(num).find("li").first().children("a").text());
    });



    //
    var nx,ny;
    var ndraging=false;
    $("#HsNew_title_top").mousedown(function(e){
        ndraging=true;
        e=e||window.event;
        nx=e.clientX-$(".hs_newslist").position().left;
        ny=e.clientY-$(".hs_newslist").position().top;
        return false;
    });

    //表情区域
    $("#biaoqing_more_btn").click(function(){

        $("#biaoqing_box").show();
    });

    $("#tool_talkinput .textarea").click(function(){
        $("#biaoqing_box").hide();
    });
    $("#biaoqing_box i").click(function(){
        var num=$(this).index()+1;

        //var clsname=$(this).attr("class");
        var str=$(this).html();
        var textareastr=$("#tool_talkinput .textarea").html();

        $("#tool_talkinput .textarea").html(textareastr+str);
        $("#biaoqing_box").hide();
    });
    //表情区域

    //拖动
    var msx, msy;
    var dragging = false;

    $("#personlist_title_top").mousedown(function(e){
        dragging = true;
        e = e||window.event;
        msx=e.clientX-$(".tool_speak_box").position().left;
        msy=e.clientY-$(".tool_speak_box").position().top;
        return false;

    });

    document.onmousemove = function(e)
    {
        if(ndraging)
        {
            var xx=e.clientX-nx;
            var yy=e.clientY-ny;
            if(xx<-960)
            {
                xx=-960;
            }
            if(xx>ww-30)
            {
                xx=ww-30;
            }
            if(yy< 0)
            {
                yy=0;
            }
            if(yy>wh-30)
            {
                yy=wh-30;
            }
            $(".hs_newslist").css({"left":xx+"px","top":yy+"px"});
            return false;
        }
        if (dragging) {
            var xx=e.clientX-msx;
            var yy=e.clientY-msy;
            if(xx<-562)
            {
                xx=-562;
            }
            if(xx>ww-30)
            {
                xx=ww-30;
            }
            if(yy<0)
            {
                yy=0;
            }
            if(yy>wh-30)
            {
                yy=wh-30;
            }
            $(".tool_speak_box").css({"left":xx+"px","top":yy+"px"});
            return false;
            //alert("e.clientX="+e.clientX);
        }
    };
    $(document).mouseup(function(e) {
        dragging = false;
        ndraging = false;
        $(".tool_speak_box")[0].releaseCapture();
        $(".hs_newslist")[0].releaseCapture();
        e.cancelBubble = true;
    })

    //层级
    $(".tool_speak_box").click(function(){
        $(this).css({"z-index":99});
        $(".hs_newslist").css({"z-index":98});
    });
    $(".hs_newslist").click(function(){
        $(this).css({"z-index":99});
        $(".tool_speak_box").css({"z-index":98});
    });

    //拖动 结束

    //用户区域
    $("#person_show_btn").click(function(){
        if($(".speak_person_list_box").is(":hidden"))
        {
            $(".speak_person_list_box").show();
            $("#speak_person_hd").show();
            $("#speak_person_hd").animate({"bottom":0,"left":0},400);
        }
        else
        {

            $("#speak_person_hd").animate({"bottom":-302+"px","left":0},400,function(){$(".speak_person_list_box").hide();});


        }


    });

    $("#close_personlist_btn").click(function(){
        $("#speak_person_hd").animate({"bottom":-302+"px","left":0},400,function(){$(".speak_person_list_box").hide();});
    });

    $(".speak_personlist ul li").click(function(){
        $(".tool_talkhistory ul").html("");
        var person=$(this).find("span").text();
        $("#person_name_id").text(person);
        var lt=ww*0.5-326; //326为聊天框宽度的一半
        var tp=wh*0.5-210;//210为聊天框高度的一半
        if(tp<0)
        {tp=0}
        $(".tool_speak_box").show();
        $(".tool_speak_box").css({"left":lt+"px","top":tp+"px"});

    });
    //用户区域

    //聊天区域
    $("#tool_speak_box_close").click(function(){

        $(this).parents(".tool_speak_box").hide();

    });

    //字符串替换为图片函数
    function Replace_img(str)
    {
        var num=str.replace(".png\"\u003e","");

        var numStr = num.replace(/[^0-9]/ig, "");
        var numS=numStr.substring(6,8);
        //var reg =new RegExp("\\[(.| )+?\\]","igm");
        var s = '<i class="i_biaoqing"><img src="images/biaoqing/'+numS+'.png"></i>';
        //var reg = /\[[^\)]+\]/g;
        return s;

    }



    $("#goto_talk_btn").click(function(){

        var imgnum;
        var talktxt=$("#tool_talkinput").find(".textarea").html();
        var myname=$("#person_name_id").text();
        var mmyname="user4";
        var zz=/<IMG src=\"([^\"]*?)\">/gi;
        //var reg =new RegExp("\\<(.| )+?\\>","igm");
        var arr= talktxt.match(zz);

        if(arr!=null)
        {
            for(i=0;i<arr.length;i++)
            {

                var src="src=\"";
                var name=".png";
                var s=arr[i].indexOf(src)+5;
                var s2=arr[i].indexOf(name)+4;
                var fullpath = arr[i].substring(s,s2);//talktxt2.replace(arr[i],"["+i+"]");
                var filename = fullpath.match(/\/(\w+\.(?:png|jpg|gif|bmp))$/i)[1];
                //var test = /\/([^\/]*?\.(jpg|bmp|gif))"\/>/;
                var num=filename.replace(".png","");
                if(num.toString().length==1)
                {
                    num="00"+num;
                }
                else if(num.toString().length==2)
                {
                    num="0"+num;
                }
                var talktxt2="["+num+"]";
                talktxt=talktxt.replace(arr[i],talktxt2);
            }

            //alert(talktxt);//图片转成数字数据
        }
        else
        {
            //alert(talktxt);
        }

        if($("#tool_talkinput .textarea").html()==""){
            alert("没有消息内容")}
        else
        {
            // boo=1;

            talktxt=$("#tool_talkinput").find(".textarea").html();
            var talk_li= "<li class=\"item_li\">"+
                "<p class=\"p_tit\"><span class=\"talk_name\">"+mmyname+"</span><span class=\"talk_time\">"+currentTime()+"         </span></p>"+
                "<p class=\"p_content\">"+talktxt+"</p></li>";
            $.ajax({
                type: "post", //请求的方式，默认get请求
                url: "myServlet", //请求地址，后台提供的
                data: {name:$("#person_name_id").text(),sender:mmyname,message:talktxt},//data是传给后台的字段，后台需要哪些就传入哪些
                dataType: "text", //json格式，如果后台返回的数据为json格式的数据，那么前台会收到Object
                success: function(result){
                    console.println("finished")
                }
            })
            $(".tool_talkhistory ul").append(talk_li);
            $("#tool_talkinput .textarea").html("");

        }

        $(".tool_talkhistory").scrollTop($(".tool_talkhistory ul").height());
    });

    //当前时间
    function currentTime(){
        var d = new Date(),str = '';
        str += d.getFullYear()+'-';
        str  += d.getMonth() + 1+'-';
        str  += d.getDate()+' ';
        str += d.getHours()+':';
        str  += d.getMinutes()+':';
        str+= d.getSeconds()+'';
        return str;
    }
    //



</script>
