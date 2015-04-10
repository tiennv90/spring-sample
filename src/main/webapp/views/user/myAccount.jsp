<%@ include file="/views/header.jsp" %>

    <div class="container">

        <div class="col-sm-3 col-md-2 sidebar">
            <h3>My Account</h3>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">View Profile <span class="sr-only">(current)</span></a>
                </li>
                <li><a href="#">Edit Profile</a></li>
            </ul>
            <h3>My Orders</h3>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">View Orders</a>
                </li>
                <li><a href="#">Edit Orders</a></li>
            </ul>
             <h3>My Payment</h3>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Payment Details</a>
                </li>
                <li><a href="#">Edit Payment</a></li>
            </ul>


        </div>
        <div class="col-sm-9 col-md-10 mainarea">
            <div>
            
            <h3>Welcome, Demo User</h3>
                <P>
                <img src="images/demo_user.png" alt="demo user">
                    Name: Mr. Demo User <br>
                    Email: email@demo.com <br>
                    Address: Demo Street, State, Country.<br>
                </P>
                
            </div>
        </div>

    </div>
    <!--  -->
    <!--  -->
    <div id="main">
        <section class="products-list">
            <div class="container">
                <!-- Heading Starts -->
                <h2 class="product-head">SPECIALS PRODUCTS </h2>
                <!-- Heading Ends -->
                <!-- Products Row Starts -->
                <div class="row">
                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="images/product/clothing/05.jpg" alt="">
                            <div class="caption">
                                <h3>Sleep Socks with Non-Skid Soles</h3>
                                <p>$7.95  &nbsp; &nbsp; &nbsp;  <strike>$16.95</strike></p>
                                <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="images/product/health/05.jpg" alt="">
                            <div class="caption">
                                <h3>Product Name</h3>
                                <h3>Bed Buddy Hot and Cold Pack</h3>
                                <p>$8.95  &nbsp; &nbsp; &nbsp;  <strike>$16.95</strike></p>
                                <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="images/product/bath/05.jpg" alt="">
                            <div class="caption">
                                <h3>Extra Wide Tall-Ette Toilet Seat with Arms</h3>
                                <p>$50.95  &nbsp; &nbsp; &nbsp;  <strike>$100.95</strike></p>
                                <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3">
                        <div class="thumbnail">
                            <img src="images/product/mobility/05.jpg" alt="">
                            <div class="caption">
                                   <h3>Handirail Bedside Assistant Bed Safety Rail</h3>
                                <p>$40.95 &nbsp; &nbsp; &nbsp;  <strike>$80.95</strike></p>
                                <p><a href="#" class="btn btn-primary" role="button">Buy</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- c -->
    </div>
    <!-- //Main -->

<%@ include file="/views/footer.jsp" %>