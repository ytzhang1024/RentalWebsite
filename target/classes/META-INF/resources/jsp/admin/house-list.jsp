<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 29/1/2022
  Time: 9:34
  House list
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ User Dashboard ================================== -->
<section class="p-0">
    <div class="container-fluid p-0">

        <div class="row">

            <%@ include file="../common/admin-left.jsp" %>


            <div class="col-lg-9 col-md-8 col-sm-12">
                <div class="dashboard-body">


                    <div class="frm_submit_block">
                        <h4>House Management <a href="/admin/house/publish" class="btn btn-theme bg-2 btn-sm">Post new house</a></h4>
                    </div>

                    <div class="row">

                        <c:forEach items="${pageInfo.records}" var="c">
                            <!-- Single Property -->
                            <div class="col-lg-4 col-md-6 col-sm-12">
                                <div class="dashboard_property_list">
                                    <div class="dashboard_property_list_thumb">
                                        <img src="${c.thumbnailUrl}" class="img-fluid" alt=""/>
                                        <c:choose>
                                            <c:when test="${c.status == 1}">
                                                <span class="dashboard_pr_status">Not rented</span>
                                            </c:when>
                                            <c:when test="${c.status == 0}">
                                                <span class="dashboard_pr_status published">Leased out</span>
                                            </c:when>
                                            <c:when test="${c.status == -1}">
                                                <span class="dashboard_pr_status expire">Removed</span>
                                            </c:when>
                                            <c:when test="${c.status == -2}">
                                                <span class="dashboard_pr_status expire">Pending review</span>
                                            </c:when>
                                            <c:when test="${c.status == -3}">
                                                <span class="dashboard_pr_status expire">Audit Rejected</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="dashboard_pr_status ">Unknown status</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="dashboard_property_list_content">
                                        <h4>${c.title}</h4>
                                        <span><i class="ti-location-pin"></i>${c.address}</span>
                                    </div>
                                    <div class="dashboard_property_list_footer">
                                        <a href="/house/detail/${c.id}" data-toggle="tooltip" title="View"><i
                                                class="ti-eye"></i></a>

                                            <%--   The information of a property that has been rented out can not be changed      --%>
                                        <c:if test="${c.status != 0}">
                                            <a href="/admin/house/publish?id=${c.id}" data-toggle="tooltip"
                                               title="Edit"><i
                                                    class="ti-pencil"></i></a>
                                        </c:if>

                                        <c:choose>
                                            <c:when test="${c.status == 1}">
                                                <a href="javascript:void(0)" onclick="downHouse(${c.id})"
                                                   data-toggle="tooltip" title="Removed"><i class="ti-control-pause"></i></a>
                                            </c:when>
                                            <c:when test="${c.status == -1}">
                                                <a href="javascript:void(0)" onclick="upHouse(${c.id})"
                                                   data-toggle="tooltip" title="Renting" data-original-title="Running"><i
                                                        class="ti-control-play"></i></a>
                                            </c:when>
                                        </c:choose>
                                        <a href="javascript:void(0)" onclick="deleteHouse(${c.id})"
                                           data-toggle="tooltip" title="Delete"><i class="ti-close"></i></a>

                                        <c:if test="${isAdmin && c.status == -2}">
                                            <a href="javascript:void(0)" onclick="checkPassHouse(${c.id})"
                                               data-toggle="tooltip" title="Audit approved"><i class="ti-arrow-up"></i></a>
                                            <a href="javascript:void(0)" onclick="checkRejectHouse(${c.id})"
                                               data-toggle="tooltip" title="Audit Rejection"><i class="ti-arrow-down"></i></a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- row -->

                    <!-- Pagination -->
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <%@ include file="../common/page.jsp" %>

                        </div>
                    </div>

                    <!-- row -->

                </div>

            </div>

        </div>
    </div>
</section>
<!-- ============================ User Dashboard End ================================== -->


<%@ include file="../common/footer.jsp" %>
</body>
</html>
