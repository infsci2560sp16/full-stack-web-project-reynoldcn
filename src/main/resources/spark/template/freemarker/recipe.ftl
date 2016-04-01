<!DOCTYPE html>
<html>
<body>
<h2>Menu</h2>

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
document.getElementById("jIng").innerHTML=JSONObject.ingredients

</script>

</body>
</html>
</html>
