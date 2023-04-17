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

<section  class="gray-simple">

    <div class="container">

        <div class="row">

            <div class="col-lg-12 col-md-12 col-sm-12 occupation">

                <h2 align="center">Sent an email to your potential roommate!</h2>
                <h4 align="center">You are trying to contact: ${potentialRoommate.userName}</h4>
                <h4 align="center">His Email: ${potentialRoommate.email}</h4>
                <h4 align="center">His Tel: ${potentialRoommate.phone}</h4>

                <!-- User Detail -->
                <div class="agent-_blocks_wrap b-0">
                    <div class="side-block-header">
                        <h3 class="title">Contact the Potential Roommate</h3>
                    </div>
                    <div class="side-block-body">
                        <form action="" id="contactForm">
                            <div class="row">
                                <input type="hidden" name="potentialRoommateEmail" value="${potentialRoommate.email}">
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="name" placeholder="My name" value="${user.userName}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="email" placeholder="My Email" value="${user.email}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="phone" placeholder="My Phone Number" value="${user.phone}"/>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                    <div class="form-group">
                                            <textarea class="form-control" name="content"
                                                      placeholder="Contents"></textarea>
                                    </div>
                                </div>

                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="stbooking-footer mt-1">
                                        <div class="form-group mb-0 pb-0">
                                            <a href="javascript:void(0)" onclick="roommateContact()"
                                               class="btn btn-md full-width btn-theme bg-2">Sent</a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>


            </div>

        </div>

    </div>
</section>

<%@ include file="../common/footer.jsp" %>

</body>
</html>
