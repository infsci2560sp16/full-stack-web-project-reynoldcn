<!DOCTYPE html>
<html lang="en">
<head>
<title>iMenu</title>
<meta charset="utf-8">
<meta name="author" content="Zhuoqun Wang">
<meta name="description" content="iMenu-Web Standard&Technology Project"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet" type="text/css" href="stylesheets/reset.css">
<link rel="stylesheet" type="text/css" href="stylesheets/responsive.css">
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>
<body>

<div class="h-top">
<header>
<div class="top-header" id="home">
<div class="top-header">
<a href="index.html"><img src="img/logo.png" class="logo" alt="" title=""/></a>
<a href="#" class="hamburger"></a>
<nav>
<ul>
<li><a href="#">About</a></li>
<li><a href="#">Contact</a></li>
</ul>
<#if isLogin = true>
<a href="account.html" class="login_btn">${userName}</a>
<#else>
<a href="login.html" class="login_btn">Login</a>
</#if>
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
<li><a class="usercenter.html" href="index.html" data-hover="HOME">Manage</a></li>
<li><a href="#" data-hover="About">History</a></li>
<li><a href="#" data-hover="Grids">Favourites</a></li>
<li><a href="#" data-hover="Services">Upload</a></li>
<li><a href="#" data-hover="Gallery">On Diet</a></li>
<li><a href="#" data-hover="CONTACT">Need Help</a></li>
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
<a href="#">
<img src="img/user.jpg" alt="" title="" class="property_img"/>
</a>

<div class="property_details">
<h2>
<a href="#">Zhuoqun Wang</a>
</h2>
<h3>CEO of iMenu <span class="property_size">...</span></h3>
</div>
</li>
<li>
<form >

<h4>Manage Account</h4>


<p>
<label for="name">Name:</label>
<input type="text" id="name" name="name">
</p>

<p>
<label for="company">Age:</label>
<input type="text" id="company" name="company">
</p>

<p>
<label for="email">Email Address:</label>
<input type="text" id="email" name="email">
</p>

<p>
<label for="phone">Phone Number:</label>
<input type="text" id="phone" name="phone">
</p>

<p>
<label for="location">Location (city):</label>
<input type="text" id="location" name="location">
</p>

<p>
<label>Describe:</label>
<textarea rows="10" name="message"></textarea>
</p>
<div class="dots">
<input class="submit" type="submit" name="submit" value="send">
</div>
</form>
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
<#list profile as item>
<li><a href="#">${item}</a></li>
</#list>

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