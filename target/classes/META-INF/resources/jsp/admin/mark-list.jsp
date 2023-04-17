<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 15/1/2022
  Time: 19:57
  Marks
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
                            <h4>Collection Management</h4>
                        </div>

                        <table class="property-table-wrap responsive-table bkmark">

                            <tbody>
                            <tr>
                                <th><i class="fa fa-file-text"></i>My Favourites</th>
                                <th></th>
                            </tr>

                            <c:forEach items="${pageInfo.records}" var="c">
                                <tr>
                                    <td class="dashboard_propert_wrapper">
                                        <img src="${c.house.thumbnailUrl}" alt="">
                                        <div class="title">
                                            <h4><a href="/house/detail/${c.houseId}" target="_blank">${c.house.title}</a></h4>
                                            <span>${c.house.address}</span>
                                            <span class="table-property-price">￡${c.house.monthRent} / Month</span>
                                        </div>
                                    </td>
                                    <td class="action">
                                        <a href="javascript:void(0)" class="delete" onclick="cancelMark(${c.id})"><i class="ti-close"></i>Cancel collection</a>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>

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
    </div>
</section>
<!-- ============================ User Dashboard End ================================== -->


<%@ include file="../common/footer.jsp" %>
</body>
</html>
