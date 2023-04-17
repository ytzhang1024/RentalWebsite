<%-- left sidebar--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="col-lg-3 col-md-4 col-sm-12">
    <div class="property_dashboard_navbar">

        <c:choose>
            <%--  Administrator  --%>
            <c:when test="${sessionScope.user.role == 'admin'}">
                <div class="dash_user_menues">
                    <ul>
                            <%--                        <li <c:if test="${tab == 'index'}"> class="active"</c:if>><a href="/admin/index"><i--%>
                            <%--                                class="ti-dashboard"></i>Dashboard</a></li>--%>
                        <li <c:if test="${tab == 'my-profile'}"> class="active"</c:if>><a href="/admin/profile"><i
                                class="ti-user"></i>Profile</a></li>
                        <li <c:if test="${tab == 'house-list'}"> class="active"</c:if>><a href="/admin/house"><i
                                class="ti-layers"></i>House Management</a></li>
                        <li <c:if test="${tab == 'order-list'}"> class="active"</c:if>><a href="/admin/order"><i
                                class="ti-gift"></i>Order Management</a></li>
                        <li <c:if test="${tab == 'user-list'}"> class="active"</c:if>><a href="/admin/user"><i
                                class="ti-user"></i>User Management</a></li>
                        <li <c:if test="${tab == 'feedback-list'}"> class="active"</c:if>><a href="/admin/feedback"><i
                                class="ti-alert"></i>Feedback Management</a></li>
                        <li <c:if test="${tab == 'news-list'}"> class="active"</c:if>><a href="/admin/news"><i
                                class="ti-new-window"></i>News & Events</a></li>
                        <li <c:if test="${tab == 'post-list'}"> class="active"</c:if>><a href="/admin/post"><i
                                class="ti-pencil"></i>Forum Management</a></li>
                        <li <c:if test="${tab == 'comment-list'}"> class="active"</c:if>><a href="/admin/comment"><i
                                class="ti-comment"></i>Message Management</a></li>
                        <li <c:if test="${tab == 'my-password'}"> class="active"</c:if>><a href="/admin/password"><i
                                class="ti-unlock"></i>Password Management</a></li>
                        <li><a href="/logout"><i class="ti-power-off"></i>Log out</a></li>
                    </ul>
                </div>
            </c:when>
            <%--  Landlord  --%>
            <c:when test="${sessionScope.user.role == 'owner'}">
                <div class="dash_user_menues">
                    <ul>
                        <li <c:if test="${tab == 'my-profile'}"> class="active"</c:if>><a href="/admin/profile"><i
                                class="ti-user"></i>Profile</a></li>
                        <li <c:if test="${tab == 'house-list'}"> class="active"</c:if>><a href="/admin/house"><i
                                class="ti-layers"></i>House Management</a></li>
                        <li <c:if test="${tab == 'order-list'}"> class="active"</c:if>><a href="/admin/order"><i
                                class="ti-gift"></i>Order Management</a></li>
                        <li <c:if test="${tab == 'house-publish'}"> class="active"</c:if>><a
                                href="/admin/house/publish"><i class="ti-pencil-alt"></i>Post new house</a></li>
                        <li <c:if test="${tab == 'feedback-list'}"> class="active"</c:if>><a href="/admin/feedback"><i
                                class="ti-alert"></i>Feedback Management</a></li>
                        <li <c:if test="${tab == 'post-list'}"> class="active"</c:if>><a href="/admin/post"><i
                                class="ti-pencil"></i>Forum Management</a></li>
                        <li <c:if test="${tab == 'comment-list'}"> class="active"</c:if>><a href="/admin/comment"><i
                                class="ti-comment"></i>Message Management</a></li>
                        <li <c:if test="${tab == 'my-password'}"> class="active"</c:if>><a href="/admin/password"><i
                                class="ti-unlock"></i>Password Management</a></li>
                        <li><a href="/logout"><i class="ti-power-off"></i>Log out</a></li>
                    </ul>
                </div>
            </c:when>
            <%--  Tenant  --%>
            <c:when test="${sessionScope.user.role == 'customer'}">
                <div class="dash_user_menues">
                    <ul>
                        <li <c:if test="${tab == 'my-profile'}"> class="active"</c:if>><a href="/admin/profile"><i
                                class="ti-user"></i>Profile</a></li>

                        <li <c:if test="${tab == 'my-matching'}"> class="active"</c:if>><a href="/admin/matching"><i
                                class="ti-user"></i>Matching Management</a></li>

                        <li <c:if test="${tab == 'home'}"> class="active"</c:if>><a
                                href="/admin/home"><i class="ti-home"></i>My Home</a></li>
                        <li <c:if test="${tab == 'order-list'}"> class="active"</c:if>><a
                                href="/admin/order"><i class="ti-gift"></i>Order Management</a></li>
                        <li <c:if test="${tab == 'mark-list'}"> class="active"</c:if>><a href="/admin/mark"><i
                                class="ti-bookmark"></i>Favourites Management</a></li>
                        <li <c:if test="${tab == 'feedback-list'}"> class="active"</c:if>><a href="/admin/feedback"><i
                                class="ti-alert"></i>Feedback Management</a></li>
                        <li <c:if test="${tab == 'post-list'}"> class="active"</c:if>><a href="/admin/post"><i
                                class="ti-pencil"></i>Forum Management</a></li>
                        <li <c:if test="${tab == 'comment-list'}"> class="active"</c:if>><a href="/admin/comment"><i
                                class="ti-comment"></i>Message Management</a></li>
                        <li <c:if test="${tab == 'my-password'}"> class="active"</c:if>><a href="/admin/password"><i
                                class="ti-unlock"></i>Password Management</a></li>
                        <li><a href="/logout"><i class="ti-power-off"></i>Log out</a></li>
                    </ul>
                </div>
            </c:when>
        </c:choose>

    </div>
</div>