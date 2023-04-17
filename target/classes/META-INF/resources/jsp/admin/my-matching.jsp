<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 2/2/2022
  Time: 19:22
  Matching
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
                            <h4>Matching</h4>
                            <p>Please fill in the form below and click save button in order to start matching</p>
                        </div>
                        <form action="" id="matchingSubmit">
                            <table class="property-table-wrap responsive-table bkmark">
                                <tbody>
                                <tr>
                                    <th><i class="fa fa-file-text"></i>Type</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>




                                <tr>
                                    <td>What is your personality?</td>
                                    <td><select name="personality">
                                        <c:choose>
                                            <c:when test="${matching.personality == '0'}">
                                                <option value="0"  selected>Somewhere in between</option>
                                                <option value="1">Introvert</option>
                                                <option value="2">Extrovert</option>
                                            </c:when>
                                            <c:when test="${matching.personality == '1'}">
                                                <option value="0">Somewhere in between</option>
                                                <option value="1"  selected>Introvert</option>
                                                <option value="2">Extrovert</option>
                                            </c:when>
                                            <c:when test="${matching.personality == '2'}">
                                                <option value="0">Somewhere in between</option>
                                                <option value="1">Introvert</option>
                                                <option value="2"  selected>Extrovert</option>
                                            </c:when>
                                        </c:choose>
                                    </select></td>
                                    <td></td>
                                    <td></td>
                                </tr>



                                <tr>
                                    <td>What is your religion?</td>
                                    <td><select name="religion">
                                        <c:choose>
                                            <c:when test="${matching.religion == '0'}">
                                                <option value="0"  selected>Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '1'}">
                                                <option value="0" >Others</option>
                                                <option value="1"  selected>Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '2'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2"  selected>Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '3'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3" selected>Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '4'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4" selected>Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '5'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5" selected>Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '6'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6" selected>Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '7'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7" selected>Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '8'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8" selected>Jewish</option>
                                                <option value="9">Sikh</option>
                                            </c:when>
                                            <c:when test="${matching.religion == '9'}">
                                                <option value="0" >Others</option>
                                                <option value="1">Agnostic</option>
                                                <option value="2">Atheist</option>
                                                <option value="3">Buddhist</option>
                                                <option value="4">Catholic</option>
                                                <option value="5">Christian</option>
                                                <option value="6">Hindu</option>
                                                <option value="7">Muslim</option>
                                                <option value="8">Jewish</option>
                                                <option value="9" selected>Sikh</option>
                                            </c:when>
                                        </c:choose>
                                    </select></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>What is your ethnicity?</td>
                                    <td><select name="ethnicity">
                                        <c:choose>
                                            <c:when test="${matching.ethnicity == '0'}">
                                                <option value="0" selected>Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '1'}">
                                                <option value="0" >Others</option>
                                                <option value="1" selected>American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '2'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2" selected>Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '3'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3" selected>East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '4'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4" selected>Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '5'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5" selected>Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '6'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6" selected>Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '7'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7" selected>Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '8'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8" selected>South Asian</option>
                                                <option value="9" >White Caucasian</option>
                                            </c:when>
                                            <c:when test="${matching.ethnicity == '9'}">
                                                <option value="0" >Others</option>
                                                <option value="1">American</option>
                                                <option value="2">Black/African Descent</option>
                                                <option value="3">East Asian</option>
                                                <option value="4">Southeast Asian</option>
                                                <option value="5">Hispanic/Latino</option>
                                                <option value="6">Middle Eastern</option>
                                                <option value="7">Pacific Islander</option>
                                                <option value="8">South Asian</option>
                                                <option value="9" selected>White Caucasian</option>
                                            </c:when>
                                        </c:choose>
                                    </select></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>What is your sleepingstatus?</td>
                                    <c:choose>
                                        <c:when test="${matching.sleepingstatus == 0}">
                                            <td><input type="radio" name="sleepingstatus" value="0" checked>&nbspEarly bird</td>
                                            <td><input type="radio" name="sleepingstatus" value="1" >&nbspNight owl</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="sleepingstatus" value="0" >&nbspEarly bird</td>
                                            <td><input type="radio" name="sleepingstatus" value="1" checked>&nbspNight owl</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you smoke?</td>
                                    <c:choose>
                                        <c:when test="${matching.smoking == 0}">
                                            <td><input type="radio" name="smoking" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="smoking" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="smoking" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="smoking" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you drink?</td>
                                    <c:choose>
                                        <c:when test="${matching.drinking == 0}">
                                            <td><input type="radio" name="drinking" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="drinking" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="drinking" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="drinking" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you like cooking?</td>
                                    <c:choose>
                                        <c:when test="${matching.cooking == 0}">
                                            <td><input type="radio" name="cooking" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="cooking" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="cooking" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="cooking" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you like outdoor activities?</td>
                                    <c:choose>
                                        <c:when test="${matching.outdoor == 0}">
                                            <td><input type="radio" name="outdoor" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="outdoor" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="outdoor" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="outdoor" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you like exercise or go to gym?</td>
                                    <c:choose>
                                        <c:when test="${matching.gym == 0}">
                                            <td><input type="radio" name="gym" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="gym" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="gym" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="gym" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you like pets?</td>
                                    <c:choose>
                                        <c:when test="${matching.pets == 0}">
                                            <td><input type="radio" name="pets" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="pets" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="pets" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="pets" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you like video games?</td>
                                    <c:choose>
                                        <c:when test="${matching.games == 0}">
                                            <td><input type="radio" name="games" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="games" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="games" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="games" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>

                                <tr>
                                    <td>Do you like photography?</td>
                                    <c:choose>
                                        <c:when test="${matching.photography == 0}">
                                            <td><input type="radio" name="photography" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="photography" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="photography" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="photography" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>Do you mind live with different gender?</td>
                                    <c:choose>
                                        <c:when test="${matching.minddiffgender == 0}">
                                            <td><input type="radio" name="minddiffgender" value="0" checked>&nbspNo</td>
                                            <td><input type="radio" name="minddiffgender" value="1" >&nbspYes</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><input type="radio" name="minddiffgender" value="0" >&nbspNo</td>
                                            <td><input type="radio" name="minddiffgender" value="1" checked>&nbspYes</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td></td>
                                </tr>


                                </tbody>
                            </table>

                            <div class="form-group col-lg-12 col-md-12" id="matchingSave">
                                <button class="btn btn-theme bg-2" type="button" onclick="submitMatchingInfo()">
                                    Save
                                </button>
                            </div>

                        </form>



                    </div>

<%--                    <!-- Pagination  -->--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-lg-12 col-md-12 col-sm-12">--%>
<%--                            <%@ include file="../common/page.jsp" %>--%>

<%--                        </div>--%>
<%--                    </div>--%>

                </div>
            </div>

        </div>
    </div>
</section>
<!-- ============================ User Dashboard End ================================== -->


<%@ include file="../common/footer.jsp" %>
</body>
</html>
