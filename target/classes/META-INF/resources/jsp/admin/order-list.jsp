<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 30/01/2022
  Time: 20:11
  Order list
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

                    <div class="dashboard-wraper">

                        <!-- Bookmark Property -->
                        <div class="frm_submit_block">
                            <h4>Order management</h4>
                        </div>

                        <table class="property-table-wrap responsive-table bkmark">

                            <tbody>
                            <tr>
                                <th><i class="fa fa-file-text"></i>Order List</th>
                                <th>Tenant</th>
                                <th>Landlord</th>
                                <th>Operation</th>
                            </tr>

                            <c:forEach items="${pageInfo.records}" var="c">
                                <tr>
                                    <td class="dashboard_propert_wrapper">
                                        <img src="${c.house.thumbnailUrl}" alt="">
                                        <div class="title">
                                            <h4><a href="/house/detail/${c.houseId}" target="_blank">${c.house.title}</a></h4>
                                            <span>${c.house.address}</span>
                                            <span class="table-property-price">Start time：
                                                <fmt:formatDate pattern="yyyy-MM-dd" value="${c.startDate}"/><br/>
                                                End time：<fmt:formatDate pattern="yyyy-MM-dd" value="${c.endDate}"/>
                                            </span>
                                            <span class="table-property-price">Total amount：￡ ${c.totalAmount}</span>
                                            <c:choose>
                                                <c:when test="${c.status == -2}"> <span
                                                        class="text-warning"> Agreement to be signed </span></c:when>
                                                <c:when test="${c.status == -1}"> <span
                                                        class="text-warning"> Payment pending </span></c:when>
                                                <c:when test="${c.status == 0}"> <span
                                                        class="text-success"> Agreement in force </span></c:when>
                                                <c:when test="${c.status == 1}"> <span
                                                        class="text-danger"> Surrender of tenancy </span></c:when>
                                                <c:when test="${c.status == -3}"> <span
                                                        class="text-warning"> Order cancelled </span></c:when>
                                                <c:when test="${c.status == 2}"> <span
                                                        class="text-warning"> Application for surrender of tenancy </span></c:when>
                                                <c:when test="${c.status == 3}"> <span
                                                        class="text-warning"> Application for surrender of tenancy rejected </span></c:when>
                                            </c:choose>

                                        </div>
                                    </td>
                                    <td>
                                            ${c.customerUser.userDisplayName}<br/>${c.customerUser.phone}
                                    </td>
                                    <td>
                                            ${c.ownerUser.userDisplayName}<br/>${c.ownerUser.phone}
                                    </td>
                                    <td>
                                        <a class="delete" href="/order/agreement/view?orderId=${c.id}" target="_blank">View Agreement</a>
                                        <br>

                                        <c:if test="${c.status == -2 || c.status == -1}">
                                            <a class="delete" href="javascript:void(0)"
                                               onclick="cancelOrder(${c.id})">Cancle order</a>
                                        </c:if>
                                        <c:if test="${c.status   == 0 || c.status == 3}">
                                            <a class="delete" href="javascript:void(0)"
                                               onclick="endOrder(${c.id})">Apply for surrender of rent</a>
                                        </c:if>
                                        <c:if test="${sessionScope.user.role != 'customer' && c.status == 2}">
                                            <a class="delete" href="javascript:void(0)" onclick="endOrderPass(${c.id})">Agree to surrender of rent</a>
                                            <a class="delete" href="javascript:void(0)" onclick="endOrderReject(${c.id})">Refuse to surrender of rent</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>

                    </div>

                    <!-- Pagination -->
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <%@ include file="../common/page.jsp" %>

                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</section>
<!-- ============================ User Dashboard End ================================== -->


<%@ include file="../common/footer.jsp" %>
</body>
</html>
