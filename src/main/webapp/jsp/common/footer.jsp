<%--
  Created by IntelliJ IDEA.
  User: Yutian Zhang
  Date: 15/12/2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- ============================ Footer Start ================================== -->
<footer class="dark-footer skin-dark-footer style-2" style="padding-top: 0;">

    <div class="footer-middle">
        <div class="container">
            <div class="row" id="footerpad">
                <div class="col-lg-4 col-md-4">
                    <div class="footer_widget">
                        <div class="footlogo"><img src="/assets/img/logo-light.png" class="img-fluid mb-3" alt=""/>
                        </div>
                        <p>Newcastle<br>Newcastle upon Tyne<br>UK NE2 1XH</p>
                        <ul class="footer-bottom-social">
                            <li><a href="#"><i class="ti-facebook"></i></a></li>
                            <li><a href="#"><i class="ti-twitter"></i></a></li>
                            <li><a href="#"><i class="ti-instagram"></i></a></li>
                            <li><a href="#"><i class="ti-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-2 col-md-2">
                    <div class="footer_widget">
                        <h4 class="widget_title">Citys</h4>
                        <ul class="footer-menu">
                            <li><a href="#">London</a></li>
                            <li><a href="#">Newcastle</a></li>
                            <li><a href="#">Gateshead</a></li>
                            <li><a href="#">More</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-2 col-md-2">
                    <div class="footer_widget">
                        <h4 class="widget_title">About Us</h4>
                        <ul class="footer-menu">
                            <li><a href="#">Contact us</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-2 col-md-2">
                    <div class="footer_widget">
                        <h4 class="widget_title">Careers</h4>
                        <ul class="footer-menu">
                            <li><a href="#">Work with us</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-2 col-md-2">
                    <div class="footer_widget">
                        <h4 class="widget_title">Useful information</h4>
                        <ul class="footer-menu">
                            <li><a href="#">Terms & Conditions</a></li>
                            <li><a href="#">Privacy</a></li>
                            <li><a href="#">Tips</a></li>
                            <li><a href="#">FAQs</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>


</footer>
<!-- ============================ Footer End ================================== -->

<!-- Login pop up Modal -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="registermodal" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered login-pop-form" role="document">
        <header class="modal_content_header">
            <div class="hm_nav">
                <h3 class="hm_nav_title">Log In</h3>
                <span class="mod-close" data-dismiss="modal" aria-hidden="true"><i class="ti-close"></i></span>
            </div>
        </header>
        <div class="modal-content" id="registermodal">
            <div class="modal-body">
                <div class="login-form">
                    <form id="loginForm">

                        <div class="form-group">
                            <label>Username</label>
                            <div class="input-with-icon">
                                <input type="text" class="form-control" name="userName" placeholder="Username">
                                <i class="ti-user"></i>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <div class="input-with-icon">
                                <input type="password" class="form-control" name="userPass" placeholder="*******">
                                <i class="ti-unlock"></i>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="button" onclick="submitLogin()" class="btn btn-md full-width pop-login bg-2">Login</button>
                        </div>

                    </form>
                </div>

                <div class="text-center">
                    <p class="mt-3"><i class="ti-user mr-1"></i>Forgot your password? <a href="#" data-toggle="modal"  data-target="#forget"class="link">Reset</a></p>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- End Modal -->

<!-- Sign up Modal -->
<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="sign-up" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered login-pop-form" role="document">
        <header class="modal_content_header">
            <div class="hm_nav">
                <h3 class="hm_nav_title">Sign Up</h3>
                <span class="mod-close" data-dismiss="modal" aria-hidden="true"><i class="ti-close"></i></span>
            </div>
        </header>
        <div class="modal-content" id="sign-up">
            <div class="modal-body">
                <div class="login-form">
                    <form id="registerForm">

                        <div class="row">

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Name</label>
                                    <div class="input-with-icon">
                                        <input type="text" name="userDisplayName" class="form-control" placeholder="Name">
                                        <i class="ti-user"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>E-mail</label>
                                    <div class="input-with-icon">
                                        <input type="email" name="email" class="form-control" placeholder="E-mail">
                                        <i class="ti-email"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Phone number</label>
                                    <div class="input-with-icon">
                                        <input type="text" name="phone" class="form-control" placeholder="Phone number">
                                        <i class="ti-mobile"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Usernmae</label>
                                    <div class="input-with-icon">
                                        <input type="text" name="userName" class="form-control" placeholder="Usernmae">
                                        <i class="ti-user"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Password</label>
                                    <div class="input-with-icon">
                                        <input type="password" name="userPass" class="form-control" placeholder="Password">
                                        <i class="ti-unlock"></i>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Role</label>
                                    <div class="simple-input">
                                        <select name="role" class="form-control">
                                            <option value="customer">Tenant</option>
                                            <option value="owner">Landlord</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="form-group">
                            <button type="button" onclick="submitRegister()" class="btn btn-md full-width pop-login bg-2">Join</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Modal -->

<!-- Forgot password Modal -->
<div class="modal fade" id="forget" tabindex="-1" role="dialog" aria-labelledby="forgetmodal" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered login-pop-form" role="document">
        <header class="modal_content_header">
            <div class="hm_nav">
                <h3 class="hm_nav_title">Reset password</h3>
                <span class="mod-close" data-dismiss="modal" aria-hidden="true"><i class="ti-close"></i></span>
            </div>
        </header>
        <div class="modal-content">
            <div class="modal-body">
                <div class="login-form">
                    <form id="forgetForm">

                        <div class="form-group">
                            <label>Username</label>
                            <div class="input-with-icon">
                                <input type="text" class="form-control" name="userName" placeholder="Username">
                                <i class="ti-user"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>E-mail</label>
                            <div class="input-with-icon">
                                <input type="email" class="form-control" name="email" placeholder="E-mail">
                                <i class="ti-unlock"></i>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="button" onclick="submitForget()" class="btn btn-md full-width pop-login bg-2">Reset Password</button>
                        </div>

                    </form>
                </div>

                <div class="text-center">
                    <p class="mt-3"><i class="ti-user mr-1"></i>Email to reset password has been sent</p>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- End Modal -->

<!-- End Video Modal -->
<a id="back2Top" class="top-scroll" title="Back to top" href="#"><i class="ti-arrow-up"></i></a>


</div>
<!-- ============================================================== -->
<!-- End Wrapper -->
<!-- ============================================================== -->

<!-- ============================================================== -->
<!-- All Jquery -->
<!-- ============================================================== -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/popper.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/ion.rangeSlider.min.js"></script>
<script src="/assets/js/select2.min.js"></script>
<script src="/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/assets/js/slick.js"></script>
<script src="/assets/js/slider-bg.js"></script>
<script src="/assets/js/lightbox.js"></script>
<script src="/assets/js/imagesloaded.js"></script>
<script src="/assets/js/custom.js"></script>
<script src="/assets/js/script.js"></script>
<!-- ============================================================== -->
<!-- This page plugins -->
<!-- ============================================================== -->
