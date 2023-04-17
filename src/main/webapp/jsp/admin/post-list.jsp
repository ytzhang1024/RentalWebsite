<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 27/01/2022
  Time: 13:22
  Post list
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
                            <h4>Forum Management <a href="/admin/post/publish" class="btn btn-theme bg-2 btn-sm">Post</a></h4>
                        </div>


                        <table class="property-table-wrap responsive-table">

                            <tbody>
                            <tr>
                                <th style="width: 10%;">User</th>
                                <th>Title</th>
                                <th style="width: 20%">Time</th>
                                <th style="width: 20%">Operation</th>
                            </tr>
                            <c:forEach items="${pageInfo.records}" var="c">
                                <tr>
                                    <td align="center">${c.user.userDisplayName}</td>
                                    <td>
                                        <a href="/post/detail/${c.id}"  target="_blank" class="delete text-blue">${c.title}</a>
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${c.createTime}"/>
                                    </td>
                                    <td class="action">
                                        <a href="/admin/post/publish?id=${c.id}" class="delete text-blue">Edit</a>
                                        <a href="javascript:void(0)" class="delete text-danger"  onclick="deletePost(${c.id})">Delete</a>
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
