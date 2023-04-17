<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 27/1/2022
  Time: 19:26
  Comment list
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
                            <h4>Message Management</h4>
                        </div>


                        <table class="property-table-wrap responsive-table">

                            <tbody>
                            <tr>
                                <th  style="width: 10%;">User</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Time</th>
                                <th>Operation</th>
                            </tr>
                            <c:forEach items="${pageInfo.records}" var="c">
                                <tr>
                                    <td align="center">${c.user.userDisplayName}</td>
                                    <td>
                                        <a href="/post/detail/${c.postId}" target="_blank" class="delete text-blue">${c.post.title}</a>
                                    </td>
                                    <td>
                                        ${c.content}
                                    </td>
                                    <td>
                                        <fmt:formatDate pattern="yyyy-MM-dd" value="${c.createTime}"/>
                                    </td>
                                    <td class="action">
                                        <a href="/post/detail/${c.postId}#comment-${c.id}" class="delete text-blue">View</a>
                                        <a href="javascript:void(0)" class="delete text-danger" onclick="deleteComment(${c.id})">Delete</a>
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
