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


<!-- ============================ Hero Banner Start================================== -->
<div class="image-cover hero_banner" style="background:#334aca url(/assets/img/banner-3.jpg) no-repeat;"
     data-overlay="1">
    <div class="container">

        <h1 class="big-header-capt mb-0">Rent a room. Meet new flatmates.</h1>
        <h1 class="text-center mb-5">Clever matches. Better flatshares.</h1>
        <!-- Type -->
        <div class="full_search_box nexio_search lightanic_search hero_search-radius modern">
            <div class="search_hero_wrapping">
                <form action="/house">

                    <div class="row">

                        <div class="col-lg-3 col-md-3 col-sm-12">
                            <div class="form-group">
                                <label>Name</label>
                                <div class="input-with-icon">
                                    <input type="text" name="address" class="form-control">
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2 col-sm-12">
                            <div class="form-group">
                                <label>City</label>
                                <div class="input-with-icon">
                                    <select id="city" name="city" class="form-control">
                                        <option value="">No limit</option>
                                        <option value="London">London</option>
                                        <option value="Newcastle">Newcastle</option>
                                        <option value="Edinburgh">Edinburgh</option>
                                        <option value="Glasgow">Glasgow</option>
                                        <option value="Manchester">Manchester</option>
                                        <option value="Sheffield">Sheffield</option>
                                        <option value="Birmingham">Birmingham</option>
                                    </select>
                                </div>
                            </div>
                        </div>


                        <div class="col-lg-2 col-md-2 col-sm-12">
                            <div class="form-group">
                                <label>Rental Type</label>
                                <div class="input-with-icon">
                                    <select id="selectRentType" name="rentType" class="form-control">
                                        <option value="">No limit</option>
                                        <option value="whole">Whole Rent</option>
                                        <option value="share">Shared Rent</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-3 col-sm-12">
                            <div class="form-group">
                                <label>Monthly Spending</label>
                                <div class="input-with-icon">
                                    <select id="price" class="form-control" name="priceRange">
                                        <option value="">No limit</option>
                                        <option value="0;100">100</option>
                                        <option value="100;200">100-200</option>
                                        <option value="200;500">200-500</option>
                                        <option value="500;1000">500-1000</option>
                                        <option value="1000;3000">1000-3000</option>
                                        <option value="3000;10000">3000-10000</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-2 col-md-2 col-sm-12 small-padd">
                            <div class="form-group none">
                                <button type="submit" class="btn search-btn">Search</button>
                            </div>
                        </div>

                    </div>
                </form>


            </div>
        </div>
    </div>
</div>
<!-- ============================ Hero Banner End ================================== -->

<!-- ============================ Whole rent Start ================================== -->
<section class="gray-simple">
    <div class="container">

        <div class="row justify-content-center">
            <div class="col-lg-7 col-md-8">
                <div class="sec-heading center">
                    <h2>Whole Rent</h2>
                    <p>Recently added homes</p>
                </div>
            </div>
        </div>

        <div class="row">
            <%--  Whole rent--%>
            <c:forEach items="${recentWholeHouseList}" var="c">
                <!-- Single Property -->
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="single_property_style property_style_2 modern">

                        <div class="listing_thumb_wrapper">
                            <div class="property_gallery_slide-thumb">
                                <a href="/house/detail/${c.id}">
                                    <img src="${c.thumbnailUrl}" class="img-fluid mx-auto" alt=""></a>
                            </div>
                        </div>

                        <div class="property_caption_wrappers pb-0">
                            <div class="property_short_detail">
                                <div class="pr_type_status">
                                    <h4 class="pr-property_title mb-1">
                                        <a href="/house/detail/${c.id}">
                                                ${c.title}
                                        </a>
                                    </h4>
                                    <div class="listing-location-name">
                                        <a href="/house/detail/${c.id}">
                                                ${c.address}
                                        </a>
                                    </div>
                                </div>
                                <div class="property-real-price">
                                    <a href="/house/detail/${c.id}" class="cl-blue">
                                        ￡ ${c.monthRent}<span class="price_status">/month</span>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="modern_property_footer">
                            <div class="property-lists flex-1">
                                <ul>
                                    <li><span class="flatcons">
                                        <img src="/assets/img/bed.svg" alt=""></span>${c.bedroomNum} bedrooms
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/living-room.svg"
                                                                    alt=""></span>${c.area} ㎡
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/kitchen.svg"
                                                                    alt=""></span>${c.kitchenNum} kitchens
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/shower-curtain.svg"
                                                                    alt=""></span>${c.toiletNum} baths
                                    </li>
                                </ul>
                            </div>
                            <div class="fp_types"><a href="javascript:void(0)" class="markHouse" data-id="${c.id}"
                                                     onclick="submitMark(${c.id})">Mark</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 text-center">
                <a href="/house?rentType=whole" class="btn btn-theme arrow-btn bg-2">More
                    <span><i class="ti-arrow-right"></i></span>
                </a>
            </div>
        </div>

    </div>
</section>
<div class="clearfix"></div>
<!-- ============================ Whole Rent End ================================== -->


<!-- ============================ Whole Rent Start ================================== -->
<section class="gray-simple">
    <div class="container">

        <div class="row justify-content-center">
            <div class="col-lg-7 col-md-8">
                <div class="sec-heading center">
                    <h2>Shared Rent</h2>
                    <p>Recently added homes</p>
                    </p>
                </div>
            </div>
        </div>

        <div class="row">
            <%--  Whole Rent--%>
            <c:forEach items="${recentShareHouseList}" var="c">
                <!-- Single Property -->
                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div class="single_property_style property_style_2 modern">

                        <div class="listing_thumb_wrapper">
                            <div class="property_gallery_slide-thumb">
                                <a href="/house/detail/${c.id}">
                                    <img src="${c.thumbnailUrl}" class="img-fluid mx-auto" alt=""></a>
                            </div>
                        </div>

                        <div class="property_caption_wrappers pb-0">
                            <div class="property_short_detail">
                                <div class="pr_type_status">
                                    <h4 class="pr-property_title mb-1">
                                        <a href="/house/detail/${c.id}">
                                                ${c.title}
                                        </a>
                                    </h4>
                                    <div class="listing-location-name">
                                        <a href="/house/detail/${c.id}">
                                                ${c.address}
                                        </a>
                                    </div>
                                </div>
                                <div class="property-real-price">
                                    <a href="/house/detail/${c.id}" class="cl-blue">
                                        ￡ ${c.monthRent}<span class="price_status">/month</span>
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div class="modern_property_footer">
                            <div class="property-lists flex-1">
                                <ul>
                                    <li><span class="flatcons">
                                        <img src="/assets/img/bed.svg" alt=""></span>${c.bedroomNum} bedrooms
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/living-room.svg"
                                                                    alt=""></span>${c.area} ㎡
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/kitchen.svg"
                                                                    alt=""></span>${c.kitchenNum} kitchens
                                    </li>
                                    <li><span class="flatcons"><img src="/assets/img/shower-curtain.svg"
                                                                    alt=""></span>${c.toiletNum} baths
                                    </li>
                                </ul>
                            </div>
                            <div class="fp_types"><a href="javascript:void(0)" class="markHouse" data-id="${c.id}"
                                                     onclick="submitMark(${c.id})">Mark</a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 text-center">
                <a href="/house?rentType=share" class="btn btn-theme arrow-btn bg-2">More
                    <span><i class="ti-arrow-right"></i></span>
                </a>
            </div>
        </div>

    </div>
</section>
<div class="clearfix"></div>
<!-- ============================ Whole Rent End ================================== -->


<%@ include file="../common/footer.jsp" %>
<script th:inline="javascript">
    let openLogin = "${openLogin}";
    if (openLogin == 'Y') {
        $('#gotoLogin').click();
    }
</script>

</body>
</html>
