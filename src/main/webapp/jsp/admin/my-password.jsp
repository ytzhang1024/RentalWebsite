<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 23/12/2021
  Time: 16:29
  Reset password
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ User Dashboard ================================== -->
<section class="gray p-0">
    <div class="container-fluid p-0">

        <div class="row">

            <%@ include file="../common/admin-left.jsp" %>


            <div class="col-lg-9 col-md-8 col-sm-12">
                <div class="dashboard-body">

                    <div class="dashboard-wraper">

                        <!-- Basic Information -->
                        <div class="frm_submit_block">
                            <h4>Change password</h4>
                            <div class="frm_submit_wrap">
                                <form action="" id="passwordForm">
                                    <div class="form-row">

                                        <div class="col-md-6">
                                            <div class="form-group col-md-12">
                                                <label>Old Password</label>
                                                <input type="password" class="form-control" name="oldPassword">
                                            </div>

                                            <div class="form-group col-md-12">
                                                <label>New Password</label>
                                                <input type="password" class="form-control" name="newPassword">
                                            </div>

                                            <div class="form-group col-md-12">
                                                <label>Confirm Password</label>
                                                <input type="password" class="form-control" name="confirmPassword">
                                            </div>


                                            <div class="form-group col-lg-12 col-md-12">
                                                <button class="btn btn-theme bg-2" type="button"
                                                        onclick="submitPassword()">
                                                    Update password
                                                </button>
                                            </div>
                                        </div>

                                    </div>
                                </form>
                            </div>
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
