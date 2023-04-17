<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 2021/3/13
  Time: 5:37 下午
  房子详情
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ Property Detail Head Start ================================== -->
<div class="pt-5 pb-5 gray-simple">
    <div class="container">

        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10 col-sm-12">
                <div class="prt_detail_three_clicks">
                    <div class="pdt_clicks_price"><h4>￡ ${house.monthRent}/Month</h4></div>
                    <div class="pdt_clicks_title"><h3>${house.title}</h3></div>
                    <div class="pdt_clicks_location"><span><i class="ti-location-pin"></i></span>${house.address}</div>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- ============================ Property Detail Head End ================================== -->

<!-- ============================ Map & Gallery Part Start ================================== -->
<div class="pt-5 pb-5">
    <div class="container-fluid p-0">

        <div class="row">
            <div class="col-lg-12 col-md-12 mb-4">
                <div class="mapg_part_nav">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="gallery-tab" onclick="togglaeGallery()" role="tab"
                               aria-controls="gallery" aria-selected="true"><i class="ti-gallery mr-1"></i>Pictures</a>
                        </li>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" id="map-tab" onclick="toggleMap()" role="tab" aria-controls="map"--%>
<%--                               aria-selected="false"><i class="ti-map-alt mr-1"></i>地图</a>--%>
<%--                        </li>--%>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row justify-content-center no-flex">
            <div class="mapg_part_caption">
                <div class="tab-content" id="myTabContent">
                    <!-- Gallery -->
                    <div class="tab-pane active" id="gallery" role="tabpanel" aria-labelledby="gallery-tab">
                        <div class="featured_slick_gallery gray">
                            <div class="featured_slick_gallery-slide">
                                <c:forEach items="${house.slideImgList}" var="url">
                                    <div class="featured_slick_padd">
                                        <a href="${url}" class="mfp-gallery">
                                            <img style="height: 400px;width: 100%;" src="${url}"
                                                 class="img-fluid mx-auto" alt=""/></a></div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>


                    <!-- Map -->
                    <div class="tab-pane " id="map" role="tabpanel" aria-labelledby="map-tab">
                        <div class="map-container">
                            <iframe src="/house/map?id=1" width="100%" height="500px;"></iframe>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>
<!-- ============================ Map & Gallery Part End ================================== -->


<!-- ============================ Property Detail Start ================================== -->
<section class="gray-dark">
    <div class="container">
        <div class="row">

            <!-- property main detail -->
            <div class="col-lg-8 col-md-12 col-sm-12">

                <!-- Single Block Wrap -->
                <div class="property_block_wrap style-2">

                    <div class="property_block_wrap_header">
                        <a data-toggle="collapse" data-parent="#features" href="#clOne" aria-expanded="true"><h4
                                class="property_block_title">House Details</h4></a>
                    </div>
                    <div id="clOne" class="panel-collapse collapse show" aria-expanded="true">
                        <div class="block-body">
                            <ul class="deatil_features">
                                <li><strong>State:</strong>
                                    <c:choose>
                                        <c:when test="${house.status == 1}">Renting</c:when>
                                        <c:when test="${house.status == 0}">Rented</c:when>
                                        <c:when test="${house.status == -1}">Removed</c:when>
                                        <c:when test="${house.status == -2}">Pending review</c:when>
                                        <c:when test="${house.status == -3}">Review rejected</c:when>
                                        <c:otherwise>Unknown</c:otherwise>
                                    </c:choose>
                                </li>
                                <li><strong>Rent:</strong>￡ ${house.monthRent}/Month</li>
                                <li><strong>Rooms:</strong>${house.bedroomNum}</li>
                                <li><strong>Bathrooms:</strong>${house.toiletNum}</li>
                                <li><strong>Kitchens:</strong>${house.kitchenNum}</li>
                                <li><strong>Livingroom:</strong>${house.livingRoomNum}</li>
                                <li><strong>Area:</strong>${house.area}m²</li>
                                <li><strong>Floor:</strong>${house.floor}/${house.maxFloor}</li>
                                <li><strong>Elevator:</strong>
                                    <c:choose>
                                        <c:when test="${house.hasElevator == 1}">yes</c:when>
                                        <c:otherwise>no</c:otherwise>
                                    </c:choose>
                                </li>
                                <li><strong>Contact:</strong>${house.contactName}</li>
                                <li><strong>Tel:</strong>${house.contactPhone}</li>
                            </ul>
                        </div>
                    </div>

                </div>

                <!-- Single Block Wrap -->
                <div class="property_block_wrap style-2">

                    <div class="property_block_wrap_header">
                        <a data-toggle="collapse" data-parent="#dsrp" href="#clTwo" aria-expanded="true"><h4
                                class="property_block_title">Description</h4></a>
                    </div>
                    <div id="clTwo" class="panel-collapse collapse show" aria-expanded="true">
                        <div class="block-body">
                            ${house.content}
                        </div>
                    </div>
                </div>

                <div class="property_block_wrap style-2">

                    <div class="property_block_wrap_header">
                        <a data-toggle="collapse" data-parent="#loca" href="#clSix" aria-expanded="true"
                           class="collapsed"><h4 class="property_block_title">Location</h4></a>
                    </div>

                    <div id="clSix" class="panel-collapse collapse show" aria-expanded="true">
                        <div class="block-body">
                            <div class="map-container">
                                <iframe src="/house/map?id=${house.id}" width="100%" height="300px;"></iframe>
                            </div>

                        </div>
                    </div>

                </div>

                <!-- Single Block Wrap -->
                <div class="property_block_wrap style-2">

                    <div class="property_block_wrap_header">
                        <a data-toggle="collapse" data-parent="#gal" href="#clSev" aria-expanded="true"
                           class="collapsed"><h4 class="property_block_title">Gallery</h4></a>
                    </div>

                    <div id="clSev" class="panel-collapse collapse show" aria-expanded="true">
                        <div class="block-body">
                            <ul class="list-gallery-inline">
                                <c:forEach items="${house.slideImgList}" var="url">
                                    <li>
                                        <a href="${url}" class="mfp-gallery">
                                            <img src="${url}" class="img-fluid mx-auto" alt=""/>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>

            </div>

            <!-- property Sidebar -->
            <div class="col-lg-4 col-md-12 col-sm-12">
                <div class="property-sidebar">

                    <!-- Share & Like Button -->
                    <div class="like_share_wrap b-0">
                        <ul class="like_share_list">
                            <%--                            <li><a href="#" class="btn btn-likes" data-toggle="tooltip" data-original-title="Share"><i class="fas fa-share"></i>Share</a></li>--%>
                            <li><a href="javascript:void(0)" class="btn btn-likes" onclick="submitMark(${house.id})"><i
                                    class="fas fa-heart"></i>Favorite</a></li>
                        </ul>
                    </div>

                    <div class="agent-_blocks_wrap b-0">
                        <div class="side-booking-header">
                            <h3 class="price">
                                ￡ <fmt:formatNumber value="${house.monthRent }" pattern="#"
                                                    type="number"/>&nbsp;/Month</h3>
                        </div>
                        <div class="side-booking-body">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="form-group">
                                        <label>Check in date</label>
                                        <div class="cld-box">
                                            <i class="ti-calendar"></i>
                                            <input type="text" name="checkin" id="startDate" class="form-control" placeholder="MM/DD/YYYY"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <input type="hidden" id="houseId" value="${house.id}">
                                    <div class="form-group">
                                        <label>Check out date</label>
                                        <div class="cld-box">
                                            <i class="ti-calendar"></i>
                                            <input type="text" name="checkout" id="endDate" class="form-control" placeholder="MM/DD/YYYY"/>
<%--                                            <p>Please enter the following format: 1/30/2022</p>--%>
                                        </div>
                                    </div>
                                </div>

<%--                                <div class="side-booking-foot">--%>
<%--                                    <span class="sb-header-left">Total</span>--%>
<%--                                    <h3 class="price theme-cl" id="totalAmount"></h3>--%>
<%--                                </div>--%>

                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="stbooking-footer mt-1">
                                        <div class="form-group mb-0 pb-0">
                                            <c:choose>
                                                <c:when test="${house.status == 1}">
                                                    <a href="javascript:void(0)" onclick="createOrder()"
                                                       class="btn btn-md full-width btn-theme bg-2">Book</a>
                                                </c:when>
                                                <c:when test="${house.status == 0}">
                                                    <a href="javascript:void(0)" disabled
                                                       class="btn btn-md full-width btn-theme bg-red">Leased out</a>
                                                </c:when>
                                                <c:when test="${house.status == -1}">
                                                    <a href="javascript:void(0)" disabled
                                                       class="btn btn-md full-width btn-theme bg-red">Removed</a>
                                                </c:when>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Agent Detail -->
                    <div class="agent-_blocks_wrap b-0">
                        <div class="side-block-header">
                            <h3 class="title">Contact the landlord</h3>
                        </div>
                        <div class="side-block-body">
                            <form action="" id="contactForm">
                                <div class="row">
                                    <input type="hidden" name="houseId" value="${house.id}">
                                    <div class="col-lg-12 col-md-12 col-sm-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="name" placeholder="My name"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="email" placeholder="My Email"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="phone" placeholder="My Phone Number"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <textarea class="form-control" name="content"
                                                      placeholder="Contents"></textarea>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12">
                                        <div class="stbooking-footer mt-1">
                                            <div class="form-group mb-0 pb-0">
                                                <a href="javascript:void(0)" onclick="submitContact()"
                                                   class="btn btn-md full-width btn-theme bg-2">Sent</a>
                                                <p>Landlord's Email: ${owner.email}</p>
                                                <p>Phone Number: ${owner.phone}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>



                </div>
            </div>

        </div>
    </div>
</section>
<!-- ============================ Property Detail End ================================== -->


<%@ include file="../common/footer.jsp" %>
<!-- Date Booking Script -->
<script src="/assets/js/moment.min.js"></script>
<script src="/assets/js/bootstrap-datepicker.js"></script>
<script>
    //Check In & Check Out Date Script
    $(function () {
        $('input[name="checkin"]').datepicker({
        });
    })

    $(function () {
        $('input[name="checkout"]').datepicker({
        });
    });


</script>

</body>
</html>
