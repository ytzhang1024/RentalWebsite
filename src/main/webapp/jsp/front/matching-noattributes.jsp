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

                <h4 align="center">You have not completed the matching attributes questionnaire!</h4>
                <a class="btn btn-theme bg-2" style="margin: 0 40%;" href="/admin/matching">Click here to start matching ! </a>


            </div>

        </div>

    </div>
</section>

<script>
    function prompt() {
        alert(data.msg);
        window.location.href = "/admin/my-matching/";
    }
</script>
<%@ include file="../common/footer.jsp" %>

</body>
</html>
