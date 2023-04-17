<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 2021/3/14
  Time: 5:54 下午
  合同页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>
<link rel="stylesheet" href="/assets/css/pay.css">

<!-- ============================ Agency List Start ================================== -->
<section class="gray-simple">

    <div class="container">

        <!-- row Start -->
        <div class="row">

            <div class="col-lg-12 col-md-12">
                <div>

                    <div class="mod-ct">
                        <div class="order">
                            ${order.house.title}
                        </div>
                        <div class="amount" id="money">
                            ￡${order.totalAmount}
                        </div>
                        <div class="container p-0">

                            <div class="card px-4">
                                <p class="h8 py-3">Payment Details</p>

                                <div class="row gx-3">
                                    <div class="col-12">
                                        <div class="d-flex flex-column">
                                            <p class="text mb-1">Person Name</p> <input class="form-control mb-3" type="text" placeholder="Holder Name" value="">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="d-flex flex-column">
                                            <p class="text mb-1">Card Number</p> <input class="form-control mb-3" type="text" placeholder="1234 5678 435678">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="d-flex flex-column">
                                            <p class="text mb-1">Expiry</p> <input class="form-control mb-3" type="text" placeholder="MM/YYYY">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="d-flex flex-column">
                                            <p class="text mb-1">CVV/CVC</p> <input class="form-control mb-3 pt-2 " type="password" placeholder="***">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="btn btn-primary mb-3"> <span class="ps-3">Pay</span> <span class="fas fa-arrow-right"></span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="time-item" style="padding-top: 10px">
                            <div class="time-item" id="msg">
                                <h1>OClick on the button below to simulate payment successful</h1>
                            </div>
                        </div>

                        <div class="tip">
                            <div class="tip-text">
                                <button onclick="submitPay(${order.id})" class="btn btn-small btn-success" style="color:#ffffff;" title="Payment successful">Payment successful</button>
                            </div>
                        </div>

                        <div class="tip-text">
                        </div>

                    </div>


                </div>

            </div>


        </div>
        <!-- /row -->

    </div>

</section>
<!-- ============================ Agency List End ================================== -->


<%@ include file="../common/footer.jsp" %>
</body>
</html>
