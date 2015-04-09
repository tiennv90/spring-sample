<%@ include file="/views/header.jsp" %>

    <!--  -->
    <!--  -->
    <div class="container">
        <div class="col-xs-6 col-xs-offset-3  feedback">

            <form class="form-horizontal">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="text" class="form-control" id="phone" placeholder="Phone Number">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter your Email">
                </div>
                <div class="form-group">
                    <label for="feedback">Feedback</label>
                    <textarea class="form-control" rows="3" id="feedback" placeholder="Feedback"></textarea>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default">Submit</button>

                </div>
        </div>
        </form>
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