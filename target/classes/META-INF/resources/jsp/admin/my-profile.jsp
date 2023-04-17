<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 22/12/2021
  Time: 11:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>
<link rel="stylesheet" href="/assets/plugins/bootstrap-fileinput/css/fileinput.min.css">


<!-- ============================ User Dashboard ================================== -->
<section class="gray p-0">
    <div class="container-fluid p-0">

        <div class="row">

            <%@ include file="../common/admin-left.jsp" %>


            <div class="col-lg-9 col-md-8 col-sm-12">
                <div class="dashboard-body">

                    <div class="dashboard-wraper">

                        <!-- Basic Information -->
                        <div class="frm_submit_block">
                            <h4>Profile</h4>
                            <div class="frm_submit_wrap">
                                <form action="" id="profileForm">
                                    <input type="hidden" id="key" name="key">
                                    <div class="user-avatar">
                                        <img width="100" height="100" src="${user.userAvatar}" alt="/">
                                    </div>
                                    <div class="form-row" >
                                        <div class="form-group col-md-12" id="uploadAvatar">
                                            <div class="frm_submit_wrap" >
                                                <div class="form-row">
                                                    <div class="form-group col-md-12">
                                                        <input type="file" name="file" id="file" class="file-loading"/>
                                                    </div>
                                                </div>
                                            </div>
<%--                                            <input type="file" name="file"/>--%>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Username</label>
                                            <input type="text" class="form-control" name="userName" value="${user.userName}" disabled>
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Nickname</label>
                                            <input type="text" class="form-control" name="userDisplayName" value="${user.userDisplayName}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Email</label>
                                            <input type="email" class="form-control" name="email" value="${user.email}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Phone number</label>
                                            <input type="text" class="form-control" name="phone" value="${user.phone}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>ID card / Passport number</label>
                                            <input type="text" class="form-control" name="idCard" value="${user.idCard}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Monthly budget</label>
                                            <input type="text" class="form-control" name="budget" value="${user.budget}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Nationality</label>
                                            <input type="text" class="form-control" name="nationality" value="${user.nationality}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>City that you want to live in</label>
                                            <input type="text" class="form-control" name="wantcity" value="${user.wantcity}">
                                        </div>

                                        <div class="form-group col-md-6">
                                            <label>Gender</label>
                                            <select name="gender" class="form-control">
                                                <option value="Null" <c:if test="${user.gender == 'Null'}">selected</c:if>>
                                                    Null
                                                </option>
                                                <option value="Male" <c:if test="${user.gender == 'Male'}">selected</c:if>>
                                                    Male
                                                </option>
                                                <option value="Female" <c:if test="${user.gender == 'Female'}">selected</c:if>>
                                                    Female
                                                </option>
                                            </select>
                                        </div>


                                        <div class="form-group col-md-12">
                                            <label>About me</label>
                                            <textarea class="form-control" name="userDesc">${user.userDesc}</textarea>
                                        </div>

                                        <div class="form-group col-lg-12 col-md-12">
                                            <button class="btn btn-theme bg-2" type="button" onclick="submitProfile()">
                                                Save
                                            </button>
                                        </div>


                                    </div>
                                </form>
                            </div>
                        </div>


                    </div>

                </div>
            </div>

        </div>
    </div>
</section>
<!-- ============================ User Dashboard End ================================== -->


<%@ include file="../common/footer.jsp" %>
<script src="/assets/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="/assets/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
<script>
    $(function () {
        var timestamp = Date.parse(new Date());
        $('#key').val(timestamp);
        var control = $("#file");
        var uploadUrl = "/file/upload?key=" + timestamp;
        control.fileinput({
            language: 'en', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['png', 'jpeg', 'jpg'],//接收的文件后缀
            showUpload: true, //显示批量上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            // maxImageWidth: 500,//图片的最大宽度
            // maxImageHeight: 500,//图片的最大高度
            maxFileSize: 10000,//单位为kb，如果为0表示不限制文件大小
            minFileCount: 0,
            maxFileCount: 100,
            enctype: 'multipart/form-data',
            validateInitialCount: true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        });
        //导入文件上传完成之后的事件
        $("#file").on("fileuploaded", function (event, data, previewId, index) {
            // alert('上传成功');
        });
    });
</script>
</body>
</html>
