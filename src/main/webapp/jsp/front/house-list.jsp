<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 2021/3/13
  Time: 5:37 下午
  首页JSP文件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ All Property ================================== -->
<section class="gray-simple">

    <div class="container">

        <div class="row">

            <!-- property Sidebar -->
            <div class="col-lg-4 col-md-12 col-sm-12">
                <div class="hidden-md-down">

                    <div class="page-sidebar">

                        <!-- Find New Property -->
                        <div class="sidebar-widgets" data-select2-id="28">

                            <form action="/house" method="get">

                                <div class="form-group">
                                    <div class="simple-input">
                                        <select id="city" name="city" class="form-control">
                                            <option value="">&nbsp;</option>
                                            <option value="London"
                                                    <c:if test="${houseSearchVO.city == 'London'}">selected</c:if>>
                                                London
                                            </option>
                                            <option value="Newcastle"
                                                    <c:if test="${houseSearchVO.city == 'Newcastle'}">selected</c:if>>
                                                Newcastle
                                            </option>
                                            <option value="Edinburgh"
                                                    <c:if test="${houseSearchVO.city == 'Edinburgh'}">selected</c:if>>
                                                Edinburgh
                                            </option>
                                            <option value="Glasgow"
                                                    <c:if test="${houseSearchVO.city == 'Glasgow'}">selected</c:if>>
                                                Glasgow
                                            </option>
                                            <option value="Manchester"
                                                    <c:if test="${houseSearchVO.city == 'Manchester'}">selected</c:if>>
                                                Manchester
                                            </option>
                                            <option value="Sheffield"
                                                    <c:if test="${houseSearchVO.city == 'Sheffield'}">selected</c:if>>
                                                Sheffield
                                            </option>
                                            <option value="Birmingham"
                                                    <c:if test="${houseSearchVO.city == 'Birmingham'}">selected</c:if>>
                                                Birmingham
                                            </option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="simple-input">
                                        <select id="selectRentType" name="rentType" class="form-control">
                                            <option value="">No limit</option>
                                            <option value="whole"
                                                    <c:if test="${houseSearchVO.rentType == 'whole'}">selected</c:if>>Whole Rent
                                            </option>
                                            <option value="share"
                                                    <c:if test="${houseSearchVO.rentType == 'share'}">selected</c:if>>Shared Rent
                                            </option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-with-icon">
                                        <input type="text" class="form-control" name="address" placeholder="House Name"
                                               value="${houseSearchVO.address}">
                                        <i class="ti-search"></i>
                                    </div>
                                </div>





                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 pt-4 pb-4">
                                        <h6>Monthly Spending</h6>
                                        <div class="rg-slider">
                                            <input type="text" class="js-range-slider-price" name="priceRange"
                                                   value=""/>
                                        </div>
                                    </div>
                                </div>


<%--                                <div class="row">--%>
<%--                                    <div class="col-lg-12 col-md-12 col-sm-12 pt-4 pb-4">--%>
<%--                                        <h6>选择面积范围</h6>--%>
<%--                                        <div class="rg-slider">--%>
<%--                                            <input type="text" class="js-range-slider-area" name="areaRange" value=""/>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>


                                <div class="ameneties-features">
                                    <button type="submit" class="btn btn-theme full-width bg-2">Search</button>
                                </div>
                            </form>

                        </div>

                    </div>
                </div>
                <!-- Sidebar End -->

            </div>


            <div class="col-lg-8 col-md-12 col-sm-12">


                <div class="row">

                    <c:forEach items="${pageInfo.records}" var="c">
                        <!-- Single Property -->
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <div class="single_property_style property_style_2 modern">

                                <div class="listing_thumb_wrapper">
                                    <div class="property_gallery_slide-thumb">
                                        <a href="/house/detail/${c.id}">
                                            <img src="${c.thumbnailUrl}" class="img-fluid mx-auto" alt="">
                                        </a>
                                    </div>
                                </div>

                                <div class="property_caption_wrappers pb-0">
                                    <div class="property_short_detail">
                                        <div class="pr_type_status">
                                            <h4 class="pr-property_title mb-1">
                                                <a href="/house/detail/${c.id}">${c.title}</a>
                                            </h4>
                                            <div class="listing-location-name">
                                                <a href="/house/detail/${c.id}">${c.address}</a>
                                            </div>
                                        </div>
                                        <div class="property-real-price">
                                            <a href="/house/detail/${c.id}" class="cl-blue">￡ ${c.monthRent}
                                                <span class="price_status">/Month</span></a>
                                        </div>
                                    </div>
                                </div>

                                <div class="modern_property_footer">
                                    <div class="property-lists flex-1">
                                        <ul>
                                            <li><span class="flatcons"><img src="/assets/img/bed.svg"
                                                                            alt=""></span>${c.bedroomNum} room available
                                            </li>
<%--                                            <li><span class="flatcons"><img src="/assets/img/wifi.svg"--%>
<%--                                                                            alt=""></span>WIFI--%>
<%--                                            </li>--%>
                                        </ul>
                                    </div>
                                    <div class="fp_types">
                                        <a href="javascript:void(0)" class="markHouse"
                                           onclick="submitMark(${c.id})">Mark</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <!-- Pagination 分页 -->
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                        <%@ include file="../common/page.jsp" %>

                    </div>
                </div>

            </div>


        </div>
    </div>
</section>

<!-- ============================ All Property ================================== -->


<%@ include file="../common/footer.jsp" %>
<script>
    let minPrice = ${houseSearchVO.minPrice};
    let maxPrice = ${houseSearchVO.maxPrice};
    let minArea = ${houseSearchVO.minArea};
    let maxArea = ${houseSearchVO.maxArea};
    // Range Slider Script
    $(".js-range-slider-price").ionRangeSlider({
        type: "double",
        min: 0,
        max: 10000,
        from: minPrice,
        to: maxPrice,
        grid: true
    });


    // Range Slider Script
    $(".js-range-slider-area").ionRangeSlider({
        type: "double",
        min: 0,
        max: 300,
        from: minArea,
        to: maxArea,
        grid: true
    });

</script>

</body>
</html>
