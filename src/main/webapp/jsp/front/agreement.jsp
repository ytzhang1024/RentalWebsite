<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 13/01/2022
  Time: 13:53
  Tenancy agreement
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../common/head.jsp" %>


<!-- ============================ Agency List Start ================================== -->
<section class="gray-simple">

    <div class="container">

        <!-- row Start -->
        <div class="row">

            <div class="col-lg-12 col-md-12">
                <div class="property_block_wrap style-2">

                    <div id="content" style="padding: 10px;">
                        <h2 style="text-align: center;">Tenancy agreement</h2>
                        <p>　　Landlord： ${order.ownerUser.userDisplayName} </p>
                        <p>　　ID/Passport： ${order.ownerUser.idCard} </p>
                        <p>　　Tenant： ${order.customerUser.userDisplayName} </p>
                        <p>　　ID/Passport： ${order.customerUser.idCard} </p>

                        <p>　　Address： ${order.house.address}; House Name:
                             ${order.house.title} 。
                        </p>
                        <p>　　Lease Term   ${order.dayNum}  days
                            From
                             
                                <fmt:formatDate pattern="dd-MM-yyyy" value="${order.startDate}"/>
                             
                            to
                              <fmt:formatDate pattern="dd-MM-yyyy" value="${order.endDate}"/>
                                </span>
                             </p>
                        <p>　　House rent：  ￡<fmt:formatNumber value="${order.monthRent/30 }" pattern="#" type="number"/> / day,
                             ${order.dayNum}  days，Total ￡
                             ${order.totalAmount} </p>
                        <p>　　On the basis of voluntariness, equality and mutual benefit, and by consensus, and in order to clarify the rights and obligations between the two parties, this contract is made in respect of landlord renting its legally owned house to tenant for use and tenant renting landlord's house.</p>

                        <hr>
                        <p>　　The Tenant(s) agrees with the Landlord:</p>
                        <p>　　(a) To pay rent not later than the 1st day of each month. To arrange for and pay the charges for hydro and natural gas for the rented premises, and in default of such payment, the Landlord may pay the same and charge such payments to the Tenant as additional rent. </p>
                        <p>　　(b) To pay for the repair of all damages or expenses incurred by Housing resulting from the willful or negligent act of the Tenant or persons permitted on the Premises by the Tenant. </p>
                        <p>　　(c) That the Landlord may on 24 hours written notice at a time between 8:00 AM and 8:00 PM to be specified in such notice, enter to view the state of repairs. </p>
                        <p>　　(d) That the Tenant will not assign, sublet or otherwise part with possession of the Premises or permit the Premises to be occupied by anyone other than the person(s) specifically noted above, without the consent of the Landlord, whose consent shall not be arbitrarily or unreasonably withheld </p>
                        <p>    (e) That the Tenant will maintain the Premises in a clean and tidy condition at all times and will leave the Premises in such condition and in good repair (reasonable wear and tear and damage by lightning and tempest only excepted). The tenant will be responsible for all costs incurred as the result of a new incoming tenant being unable to occupy a unit due to its physical state or the outgoing tenant having failed to vacate at the required time. </p>
                        <p>　　(f) That the Tenant will use the Premises only for the purpose of a residence for her/himself, and for no other purpose whatsoever. </p>
                        <p>　　(g) That the Tenant will observe and be subject to all the rules and regulations made by the Landlord relative to the use of the Premises in the Complex and the adjacent lands. </p>
                        <p>　　GENERAL </p>
                        <p>    The Landlord may, on 24 hours' written notice, enter the premises at any time between 8:00 a.m. and 8:00 p.m. as specified in the notice, and in case of emergency, at any time, and make such repairs as the Landlord thinks fit. If the Landlord makes repairs to the Tenant in accordance with that paragraph, the Tenant shall pay the Landlord for such repairs immediately upon receipt of an invoice.</p>
                        <p>　　7. A waiver by the Landlord of any breach of covenant or regulation shall not be considered to be a waiver of such covenant or regulation generally or of any subsequent breach of any covenant or regulation. </p>
                        <p>　　Any notice to be given to the Landlord shall be in writing and delivered to the Rental Office, 536 Platt’s Lane Estates, and any notice to be given to the Tenant hereunder shall be in writing and delivered to the Tenant at the Premises or by email.</p>
                        <p>　　If, during the final 2 months of this fixed term lease, a new lease has not been signed, the Landlord may enter the Premises between the hours of 8 a.m. and 8 p.m. to show the Premises to prospective tenants provided that, before entering, the Landlord informs or makes a reasonable effort to inform the Tenant of the intention to do so. </p>
                        <p>　　It is agreed that there is no representation, collateral agreement, or condition affecting this Lease or the Premises or supported hereby other than as expressed herein in writing. </p>
                        <p>　　The Landlord has caused this lease to be executed on its behalf by its Rental Clerk/Authorized Agent, and the Tenant has agreed to this lease with their signature</p>

                    </div>
                    <div style="text-align: center;margin-top: 50px;">
                        <c:choose>
                            <c:when test="${order.status == -2}">
                                <a href="javascript:void(0)" onclick="confirmAgreement(${order.id})"
                                   class="btn btn-primary">I have read and agree to the above agreement</a>
                            </c:when>
                            <c:when test="${order.status == -1}">To be paid</c:when>
                            <c:when test="${order.status == 0}">Contract in force</c:when>
                            <c:when test="${order.status == 1}">Contract has expired</c:when>
                            <c:when test="${order.status == 2}">Application for surrender of rent has been made</c:when>
                            <c:when test="${order.status == 3}">Application for surrender of rent rejected</c:when>
                            <c:when test="${order.status == -3}">Cancelled</c:when>
                        </c:choose>

                    </div>
                    <div style="text-align: center;margin: 20px;">
                        <a href="javascript:void(0)" onclick="printHtml('content')">Print</a>
                    </div>

                </div>

            </div>


        </div>
        <!-- /row -->

    </div>

</section>
<!-- ============================ Agency List End ================================== -->


<%@ include file="../common/footer.jsp" %>
<script>
    function printHtml(div) {

        var before = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'></head><body >";
        var print = document.getElementById(div).innerHTML;
        var result = before + print + "</body></html>"

        console.log(result);
        var wind = window.open("", 'newwindow', 'height=300, width=700, top=100, left=100, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');

        wind.document.body.innerHTML = result;

        wind.print();
        return false;
    }
</script>
</body>
</html>
