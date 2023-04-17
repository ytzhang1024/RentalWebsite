<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 02/02/2022
  Time: 15:35
  Homepage
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ All Matching ================================== -->
<section class="gray-simple">

    <div class="container">

        <div class="row">

            <div class="col-lg-12 col-md-12 col-sm-12">

                <div class="row">
                    <c:forEach items="${matchingList}" var="c">
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="single_property_style property_style_2 modern">
                            <div class="listing_thumb_wrapper">
                                <div class="property_gallery_slide-thumb">
                                    <a href="matching/contact/${c.userName}">
                                        <img src="${c.userAvatar}" class="img-fluid mx-auto" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="property_caption_wrappers pb-0">
                                <div class="property-real-price">
                                    <a class="cl-blue">${c.userName}
                                        <span class="price_status">is looking for a room</span></a>
                                </div>
                            </div>
                            <div class="modern_property_footer">
                                <div class="property-lists flex-1">
                                    <ul>
                                        <li>${c.wantcity}</li>
                                        <li>￡${c.budget} monthly Budget</li>
                                    </ul>
                                </div>
                                <div class="fp_types">
                                    <a href="matching/contact/${c.userName}">Contact</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>

            <!-- Pagination 分页 -->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <%@ include file="../common/page.jsp" %>
                </div>
            </div>
            

        </div>

    </div>
</section>

<!-- ============================ All Matching ================================== -->


<%@ include file="../common/footer.jsp" %>

</body>
</html>
