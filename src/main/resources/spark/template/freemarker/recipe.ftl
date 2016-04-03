<!DOCTYPE html>
<html lang="en">
<head>
<title>iMenu</title>
<meta charset="utf-8">
<meta name="author" content="Zhuoqun Wang">
<meta name="description" content="iMenu-Web Standard&Technology Project"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet" type="text/css" href="../../stylesheets/reset.css">
<link rel="stylesheet" type="text/css" href="../../stylesheets/responsive.css">
<link rel="stylesheet" type="text/css" href="../../stylesheets/formstyle.css">
<link rel="stylesheet" type="text/css" href="../../stylesheets/style.css">
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
</head>
<body>

<div class="h-top">
<header>
<div class="top-header" id="home">
<div class="top-header">
<a href="index.html"><img src="../../img/logo.png" class="logo" alt="" title=""/></a>
<a href="#" class="hamburger"></a>
<nav>
<ul>
<li><a href="#">About</a></li>
<li><a href="#">Contact</a></li>
</ul>
<a href="account.html" class="login_btn">LOGIN</a>
</nav>
</div>
</div>
</header><!--  end header section  -->

</div><!--  end hero section  -->
<div class="col-md-3 top-nav">
<div class="logo">
<a href="index.html"><h1>Hello!</h1></a>
</div>
<div class="top-menu">
<span class="menu"> </span>

<ul class="cl-effect-16">
                    <li><a class="usercenter.html" href="index.html" data-hover="Manage">Manage</a></li>
                    <li><a href="#" data-hover="History">History</a></li>
                    <li><a href="#" data-hover="Favourites">Favourites</a></li>
                    <li><a href="upload.html" data-hover="Upload">Upload</a></li>
                    <li><a href="#" data-hover="On Diet">On Diet</a></li>
                    <li><a href="#" data-hover="Need Help">Need Help</a></li>
</ul>
<!-- script-for-nav -->
<script>
$( "span.menu" ).click(function() {
$( ".top-menu ul" ).slideToggle(300, function() {
// Animation complete.
});
});
</script>
<!-- script-for-nav -->
<ul class="side-icons">
<li><a class="fb" href="#"></a></li>
<li><a class="twitt" href="#"></a></li>
<li><a class="goog" href="#"></a></li>
<li><a class="drib" href="#"></a></li>
</ul>
</div>
</div>

<section class="listings">
<div class="wrapper">
<ul class="properties_list">
<li>

</li>

<li>

<h2>Menu</h2>
<h3>Test RESTful Service ${method} JSON</h3>
<p>
Name: <span id="jname"></span><br />
ID: <span id="jID"></span><br />
Ingredients: <span id="jIng"></span><br />

</p>
<p>${results}</p>
<script>
var JSONObject= ${results};

document.getElementById("jname").innerHTML=JSONObject.name
document.getElementById("jID").innerHTML=JSONObject.id
document.getElementById("jIng").innerHTML=JSONObject.Ingredients

</script>

</li>

</ul>
<div class="more_listing">
<a href="#" class="more_listing_btn">Back</a>
</div>
</div>
</section>	<!--  end listing section  -->
<footer>
<div class="wrapper footer">
<ul>
<li class="links">
<ul>
<li><a href="#">About</a></li>
<li><a href="#">Support</a></li>
<li><a href="#">Terms</a></li>
<li><a href="#">Policy</a></li>
<li><a href="#">Contact</a></li>
</ul>
</li>



<li class="links">
<ul>
<li><a href="#">About me</a></li>
<li><a href="#">Zhuoqun Wang</a></li>
<li><a href="#">zhw59@pitt.edu</a></li>
<li><a href="#">UPitt</a></li>
<li><a href="#">Pittsburgh, PA</a></li>
</ul>
</li>
<li class="links">
<ul>
<li><a href="#">Pittsburgh</a></li>
<li><a href="#">PA</a></li>
<li><a href="#">Tele: 4153415605</a></li>
<li><a href="#">Zipcode: 15213</a></li>

</ul>
</li>
<li class="about">
<p>iMenu is a Web app for your meal. Tell us what you have in the kitchen, and we help you decide what to eat today.</p>
<ul>
<li><a href="http://facebook.com/pixelhint" class="facebook" target="_blank"></a></li>
<li><a href="http://twitter.com/pixelhint" class="twitter" target="_blank"></a></li>
<li><a href="http://plus.google.com/+Pixelhint" class="google" target="_blank"></a></li>
<li><a href="#" class="skype"></a></li>
</ul>
</li>
</ul>
</div>

<div class="copyrights wrapper">
Copyright © 2016 <a href="#" target="_blank" class="ph_link" title="...">Zhuoqun Wang</a>. All Rights Reserved.
</div>
</footer><!--  end footer  -->

</body>
</html>