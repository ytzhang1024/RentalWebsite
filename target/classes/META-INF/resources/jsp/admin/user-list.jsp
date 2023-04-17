<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 05/01/2022
  Time: 15:22
  User list
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
                            <h4>User Management</h4>
                        </div>


                        <table class="property-table-wrap responsive-table">

                            <tbody>
                            <tr>
                                <th style="width: 25%;">Account Info</th>
                                <th>Contact Info</th>
                                <th>Status</th>
                                <th>Operation</th>
                            </tr>
                            <c:forEach items="${pageInfo.records}" var="c">
                                <tr>
                                    <td>
                                        <span title="Username">${c.userName}</span> <span title="Name">${c.userDisplayName}</span> <br><span title="ID card number/passport number">${c.idCard}</span>
                                    </td>
                                    <td>
                                        <span title="Email">${c.email}</span> <br>
                                        <span title="Tel">${c.phone}</span> <br>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${c.status == 0}">
                                                <span class="text-success">Enable</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="text-danger">Disable</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="action">

                                        <c:choose>
                                            <c:when test="${c.status == 0}">
                                                <a href="javascript:void(0)" class="delete"
                                                   onclick="disableUser(${c.id})">Disable</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="javascript:void(0)" class="delete"
                                                   onclick="enableUser(${c.id})">Enable</a>
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="javascript:void(0)" class="delete text-danger"
                                           onclick="deleteUser(${c.id})">Delete</a>
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
