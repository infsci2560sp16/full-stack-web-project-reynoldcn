<!DOCTYPE html>
<html lang="en">
<head>
<title>iMenu</title>
<meta charset="utf-8">
<meta name="author" content="Zhuoqun Wang">
<meta name="description" content="iMenu-Web Standard&Technology Project"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />

<link rel="stylesheet" type="text/css" href="../stylesheets/reset.css">
<link rel="stylesheet" type="text/css" href="../stylesheets/responsive.css">

<script type="text/javascript" src="../js/main.js"></script>
</head>
<body>

<div class="hero">
<header>
<div class="wrapper">
<a href="index.html"><img src="../img/logo.png" class="logo" alt="" title=""/></a>
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
</header><!--  end header section  -->

<div class="caption">
<h2 class="caption">What's in Your Kitchen?</h2>
<h3 class="properties">We help you make a wonderful meal</h3>
</div>
</div><!--  end hero section  -->


<div class="search">
<div class="wrapper">
<form action="RestController" method="post">
<input type="text" id="search" name="search" placeholder="What are there in your kitchen, tomato, patato or ...?"  autocomplete="off"/>
<input type="submit" id="submit_search" name="submit_search"/>
</form>
<a href="#" class="advanced_search_icon" id="advanced_search_btn"></a>
</div>

<div class="advanced_search">
<div class="wrapper">
<span class="arrow"></span>

</div>
</div><!--  end advanced search section  -->
</div><!--  end search section  -->


<section class="listings">
<div class="wrapper">
<ul class="properties_list">
<li>
<a href="#">
<img src="../img/food_1.jpg" alt="" title="" class="property_img"/>
</a>
<span class="price">900Calories</span>
<div class="property_details">
<h1>
<a href="#">fried tomatoes with egg</a>
</h1>
<h2>1 tomatoes, 1 eggs. <span class="property_size">...</span></h2>
</div>
</li>
<li>
<a href="#">
<img src="../img/food_2.jpg" alt="" title="" class="property_img"/>
</a>
<span class="price">900Calories</span>
<div class="property_details">
<h1>
<a href="#">Beef Humbugers</a>
</h1>
<h2>Beef, Bread. <span class="property_size">...</span></h2>
</div>
</li>
<li>
<a href="#">
<img src="../img/food_3.jpg" alt="" title="" class="property_img"/>
</a>
<span class="price">200Calories</span>
<div class="property_details">
<h1>
<a href="#">Roasted Turkey</a>
</h1>
<h2>1 Turkey <span class="property_size">...</span></h2>
</div>
</li>
</ul>
</div>
<div class="more_listing">
<a href="results.html" class="more_listing_btn">View More Listings</a>
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
<li><a href="#">MSIS, iSchool</a></li>
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