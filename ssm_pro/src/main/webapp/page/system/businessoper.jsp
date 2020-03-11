<%--
  Created by IntelliJ IDEA.
  User: yyyzl
  Date: 2020/2/27
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>数据列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/footable/footable.core.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/footable/footable.all.min.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-title">
                    <h5>商户列表</h5>
                </div>
                <div class="ibox-content">

                    <!--数据表顶部查询 开始
                        该区域可以将来存放 各种控件
                    -->

                    <!--数据表顶部查询 结束-->
                    <!--数据表开始-->
                    <div class="jqGrid_wrapper">
                        <table class="footable table table-stripped table-hover" data-page-size="8" data-filter=#filter>
                            <!--数据头 开始-->
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>登录名</th>
                                <th>商家名</th>
                                <th>商家法人</th>
                                <th>商家法人电话</th>
                                <th>查看视频</th>
                                <th>查看音频</th>
                                <th>冻结商户</th>
                            </tr>
                            </thead>
                            <!--数据头 结束-->
                            <!--数据体 开始-->
                            <tbody>
                            <c:forEach items="${list}" var="sysuser" varStatus="status">
                                <tr class="gradeX">
                                    <td>${sysuser.business_id}</td>
                                    <td>${sysuser.business_username}</td>
                                    <td>${sysuser.business_info_name}</td>
                                    <td class="center">${sysuser.business_info_legal_person}</td>
                                    <td class="center">${sysuser.business_info_legal_person_tel}</td>
                                    <td class="center"><!-- Large modal -->
                                        <!-- Button trigger modal -->
                                        <button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="selectvideo('${sysuser.business_id}')">查看视频</button>
                                    </td>
                                    <td class="center"><!-- Large modal -->
                                        <!-- Button trigger modal -->
                                        <button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="selectaudio('${sysuser.business_id}')">查看音频</button>
                                    </td>
                                    <td class="center"><!-- Large modal -->
                                        <!-- Button trigger modal -->
                                        <button  type="button" class="btn btn-primary" data-toggle="modal"  class="${sysuser.business_id}" onclick="updabusinessfreeze('${sysuser.business_id}','${sysuser.business_freeze}')">
                                                ${sysuser.business_freeze}
<%--${status.index+1}--%>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                            <!--数据体 结束-->
                            <!--数据分页 开始-->
                            <tfoot>
                            <tr>
                                <td colspan="5">
                                    <ul class="pagination pull-right"></ul>
                                </td>
                            </tr>
                            </tfoot>
                            <!--数据分页 结束-->
                        </table>
                    </div>
                    <p>&nbsp;</p>
                    <!--数据表结束-->
                </div>
            </div>
        </div>
    </div>
</div>

<%--<script>
    function changebutton(${sysuser.business_freeze} c,${sysuser.business_id} f) {
        alert(f);
        alert(c);
        if(c == "点击冻结"){
            var dongjie=document.getElementsByClassName(".f").innerHTML("点击解结");
        }else if(c){
            var dongjie="点击冻结";
            $(".xml").text(dongjie);
        }
        $.ajax({
            type: "POST",
            &lt;%&ndash;url: "${pageContext.request.contextPath}/systemUserController/updabusinessfreeze",&ndash;%&gt;
            // data: "business_freeze=1",
            success: function(msg){
                alert(c);
            }
        });
    }
</script>--%>
<script>
    function updabusinessfreeze(business_id,business_freeze) {
        if (business_freeze == "点击冻结"){
            business_freeze = 1;
            // alert(business_freeze);
        }else{
            business_freeze = 2;
            // alert(business_freeze);
        }
        window.location.href="${pageContext.request.contextPath}/SystemUserController/updabusinessfreeze?business_id="+business_id+"&business_freeze="+business_freeze;
    }
</script>
<script>
    function selectvideo(business_id) {
        window.location.href="${pageContext.request.contextPath}/SystemUserController/getAllVideoInfo?business_id="+business_id;
    }
</script>
<script>
    function selectaudio(business_id) {
        window.location.href="${pageContext.request.contextPath}/SystemUserController/getAllAudioInfo?business_id="+business_id;
    }
</script>
<!--
    &lt;!&ndash; Peity &ndash;&gt;
    <script src="../js/plugins/peity/jquery.peity.min.js"></script>
    &lt;!&ndash; jqGrid &ndash;&gt;
    <script src="../js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
    <script src="../js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>
-->



<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function() {
        $('.footable').footable();
        $('.footable2').footable();
    });

</script>

</body>

</html>