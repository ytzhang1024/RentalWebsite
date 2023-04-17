<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 29/1/2022
  Time: 15:48
  House publish
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>
<link rel="stylesheet" href="/assets/plugins/bootstrap-fileinput/css/fileinput.min.css">


<!-- ============================ User Dashboard ================================== -->
<section class="p-0">
    <div class="container-fluid p-0">

        <div class="row">

            <%@ include file="../common/admin-left.jsp" %>


            <div class="col-lg-9 col-md-8 col-sm-12">


                <!-- ============================ Submit Property Start ================================== -->
                <section style="padding-top: 10px;">

                    <div class="container">
                        <div class="row">
                            <form action="" id="houseForm">
                                <input type="hidden" name="id" value="${house.id}">
                                <input type="hidden" id="key" name="key">
                                <!-- Submit Form -->
                                <div class="col-lg-12 col-md-12">

                                    <div class="submit-page form-simple">

                                        <!-- Basic Information -->
                                        <div class="frm_submit_block">
                                            <h3>Basic Info</h3>
                                            <div class="frm_submit_wrap">
                                                <div class="form-row">

                                                    <div class="form-group col-md-6">
                                                        <label>Rental Type</label>
                                                        <select name="rentType" class="form-control">
                                                            <option value="whole"
                                                                    <c:if test="${house.rentType == 'whole'}">selected</c:if>>
                                                                Whole rent
                                                            </option>
                                                            <option value="share"
                                                                    <c:if test="${house.rentType == 'share'}">selected</c:if>>
                                                                Shared rent
                                                            </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Monthly Rent<a href="#" class="tip-topdata"
                                                                     data-tip="Weekly rent = Monthly rent/4"><i class="ti-help"></i></a></label>
                                                        <input type="number" name="monthRent" value="${house.monthRent}"
                                                               class="form-control">
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>City</label>
                                                        <select name="city" class="form-control">
                                                            <option value="London"
                                                                    <c:if test="${house.city == 'London'}">selected</c:if>>
                                                                London
                                                            </option>
                                                            <option value="Newcastle"
                                                                    <c:if test="${house.city == 'Newcastle'}">selected</c:if>>
                                                                Newcastle
                                                            </option>
                                                            <option value="Edinburgh"
                                                                    <c:if test="${house.city == 'Edinburgh'}">selected</c:if>>
                                                                Edinburgh
                                                            </option>
                                                            <option value="Glasgow"
                                                                    <c:if test="${house.city == 'Glasgow'}">selected</c:if>>
                                                                Glasgow
                                                            </option>
                                                            <option value="Manchester"
                                                                    <c:if test="${house.city == 'Manchester'}">selected</c:if>>
                                                                Manchester
                                                            </option>
                                                            <option value="Sheffield"
                                                                    <c:if test="${house.city == 'Sheffield'}">selected</c:if>>
                                                                Sheffield
                                                            </option>
                                                            <option value="Birmingham"
                                                                    <c:if test="${house.city == 'Birmingham'}">selected</c:if>>
                                                                Birmingham
                                                            </option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>House title<a href="#" class="tip-topdata"
                                                                        data-tip="E.g. Unique Finca. Beautiful, calm nest!"><i
                                                                class="ti-help"></i></a></label>
                                                        <input type="text" name="title" value="${house.title}"
                                                               class="form-control">
                                                    </div>

                                                    <div class="form-group col-md-12">
                                                        <label>Address<a href="#" class="tip-topdata"
                                                                          data-tip="100 Hyde Park Gardens, Tyburnia, London W2 2LU"><i
                                                                class="ti-help"></i></a></label>
                                                        <input type="text" name="address" value="${house.title}"
                                                               class="form-control">
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>Latitude and longitude coordinates, <a href="https://www.maps.ie/coordinates.html"
                                                                target="_blank">Click here </a>to get it <a href="#" class="tip-topdata"
                                                                                           data-tip="Longitude and latitude used to display addresse. e.g. 54.9738474 -1.6131572 "><i
                                                                class="ti-help"></i></a></label>
                                                        <input type="text" name="longitudeLatitude"
                                                               value="${house.longitudeLatitude}"
                                                               class="form-control">
                                                    </div>


                                                </div>
                                            </div>
                                        </div>


                                        <div class="frm_submit_block">
                                            <h3>House Info</h3>
                                            <div class="frm_submit_wrap">
                                                <div class="form-row">

                                                    <div class="form-group col-md-6">
                                                        <label>Area<a href="#" class="tip-topdata"
                                                                    data-tip="How much space is available for tenants. e.g. 25㎡ for a shared room; 120㎡ for whole rent house"><i
                                                                class="ti-help"></i></a></label>
                                                        <input type="text" name="area" value="${house.area}"
                                                               class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Air conditioning</label>
                                                        <select name="hasAirConditioner" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.hasAirConditioner == 1}">selected</c:if>>
                                                                Yes
                                                            </option>
                                                            <option value="0"
                                                                    <c:if test="${house.hasAirConditioner == 0}">selected</c:if>>
                                                                No
                                                            </option>
                                                        </select>
                                                    </div>
<%--                                                    <div class="form-group col-md-6">--%>
<%--                                                        <label>WIFI</label>--%>
<%--                                                        <select name="hasWIFI" class="form-control">--%>
<%--                                                            <option value="1"--%>
<%--                                                                    <c:if test="${house.hasAirConditioner == 1}">selected</c:if>>--%>
<%--                                                                Yes--%>
<%--                                                            </option>--%>
<%--                                                            <option value="0"--%>
<%--                                                                    <c:if test="${house.hasAirConditioner == 0}">selected</c:if>>--%>
<%--                                                                No--%>
<%--                                                            </option>--%>
<%--                                                        </select>--%>
<%--                                                    </div>--%>


                                                    <div class="form-group col-md-6">
                                                        <label>Bedrooms</label>
                                                        <select name="bedroomNum" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.bedroomNum == 1}">selected</c:if>>
                                                                1
                                                            </option>
                                                            <option value="2"
                                                                    <c:if test="${house.bedroomNum == 2}">selected</c:if>>
                                                                2
                                                            </option>
                                                            <option value="3"
                                                                    <c:if test="${house.bedroomNum == 3}">selected</c:if>>
                                                                3
                                                            </option>
                                                            <option value="4"
                                                                    <c:if test="${house.bedroomNum == 4}">selected</c:if>>
                                                                4
                                                            </option>
                                                            <option value="5"
                                                                    <c:if test="${house.bedroomNum == 5}">selected</c:if>>
                                                                5
                                                            </option>
                                                            <option value="6"
                                                                    <c:if test="${house.bedroomNum == 6}">selected</c:if>>
                                                                6
                                                            </option>
                                                            <option value="7"
                                                                    <c:if test="${house.bedroomNum == 7}">selected</c:if>>
                                                                7
                                                            </option>
                                                            <option value="8"
                                                                    <c:if test="${house.bedroomNum == 8}">selected</c:if>>
                                                                8
                                                            </option>
                                                            <option value="9"
                                                                    <c:if test="${house.bedroomNum == 8}">selected</c:if>>
                                                                8
                                                            </option>
                                                            <option value="10"
                                                                    <c:if test="${house.bedroomNum == 8}">selected</c:if>>
                                                                8
                                                            </option>
                                                        </select>
                                                    </div>


                                                    <div class="form-group col-md-6">
                                                        <label>Livingrooms</label>
                                                        <select name="livingRoomNum" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.livingRoomNum == 1}">selected</c:if>>
                                                                1
                                                            </option>
                                                            <option value="2"
                                                                    <c:if test="${house.livingRoomNum == 2}">selected</c:if>>
                                                                2
                                                            </option>
                                                            <option value="3"
                                                                    <c:if test="${house.livingRoomNum == 3}">selected</c:if>>
                                                                3
                                                            </option>
                                                            <option value="4"
                                                                    <c:if test="${house.livingRoomNum == 4}">selected</c:if>>
                                                                4
                                                            </option>
                                                            <option value="5"
                                                                    <c:if test="${house.livingRoomNum == 4}">selected</c:if>>
                                                                5
                                                            </option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>Kitchens</label>
                                                        <select name="kitchenNum" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.kitchenNum == 1}">selected</c:if>>
                                                                1
                                                            </option>
                                                            <option value="2"
                                                                    <c:if test="${house.kitchenNum == 2}">selected</c:if>>
                                                                2
                                                            </option>
                                                            <option value="3"
                                                                    <c:if test="${house.kitchenNum == 3}">selected</c:if>>
                                                                3
                                                            </option>
                                                            <option value="4"
                                                                    <c:if test="${house.kitchenNum == 4}">selected</c:if>>
                                                                4
                                                            </option>
                                                            <option value="5"
                                                                    <c:if test="${house.kitchenNum == 5}">selected</c:if>>
                                                                5
                                                            </option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>Elevator</label>
                                                        <select name="hasElevator" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.hasElevator == 1}">selected</c:if>>
                                                                Yes
                                                            </option>
                                                            <option value="0"
                                                                    <c:if test="${house.hasElevator == 0}">selected</c:if>>
                                                                No
                                                            </option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>Bathrooms</label>
                                                        <select name="toiletNum" class="form-control">
                                                            <option value="1"
                                                                    <c:if test="${house.toiletNum == 1}">selected</c:if>>
                                                                1
                                                            </option>
                                                            <option value="2"
                                                                    <c:if test="${house.toiletNum == 2}">selected</c:if>>
                                                                2
                                                            </option>
                                                            <option value="3"
                                                                    <c:if test="${house.toiletNum == 3}">selected</c:if>>
                                                                3
                                                            </option>
                                                            <option value="4"
                                                                    <c:if test="${house.toiletNum == 4}">selected</c:if>>
                                                                4
                                                            </option>
                                                            <option value="5"
                                                                    <c:if test="${house.toiletNum == 4}">selected</c:if>>
                                                                4
                                                            </option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label>Year built</label>
                                                        <input type="number" name="buildYear" value="${house.buildYear}"
                                                               class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Floor</label>
                                                        <input type="number" name="floor" value="${house.floor}"
                                                               class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Total floors</label>
                                                        <input type="number" name="maxFloor" value="${house.maxFloor}"
                                                               class="form-control">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <!-- 联系人信息 -->
                                        <div class="frm_submit_block">
                                            <h3>Contact Info</h3>
                                            <div class="frm_submit_wrap">
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label>Landlord</label>
                                                        <input type="text" name="contactName"
                                                               value="${house.contactName}" class="form-control">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Phone Number</label>
                                                        <input type="text" name="contactPhone"
                                                               value="${house.contactPhone}" class="form-control">
                                                    </div>


                                                </div>
                                            </div>
                                        </div>

                                        <!-- Detailed Information -->
                                        <div class="frm_submit_block">
                                            <h3>Description</h3>
                                            <div class="frm_submit_wrap">
                                                <div class="form-row">

                                                    <div class="form-group col-md-12">
                                                        <textarea class="form-control h-120"
                                                                  name="content">${house.content}</textarea>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>

                                        <!-- Upload Pictures -->
                                        <div class="frm_submit_block">
                                            <h3>Upload Pictures</h3>
                                            <div class="frm_submit_wrap">
                                                <div class="form-row">
                                                    <div class="form-group col-md-12">
                                                        <input type="file" name="file" id="file" multiple
                                                               class="file-loading"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-lg-12 col-md-12">
                                                <button class="btn btn-theme bg-2" type="button"
                                                        onclick="submitHouse()">Publish
                                                </button>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>

                </section>
                <!-- ============================ Submit Property End ================================== -->

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
            allowedFileExtensions: ['png', 'jpeg', 'jpg', 'gif'],//接收的文件后缀
            showUpload: true, //显示批量上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: true,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
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
