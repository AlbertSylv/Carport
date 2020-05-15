<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Input to create SVG shape</title>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/d3/3.4.2/d3.js"></script>

    <style>
        body {font-family: monospace; line-height: 160%; font-size: 18px; }
        input {border: 1px dotted #ccc; background: white; font-family: monospace; padding: 10px 20px; font-size: 18px; margin: 20px 10px 20px 0; color: red;}
        input:focus { background-color:yellow; outline: none;}
        #myRadius {max-width: 35px}
        form {display: block; position: fixed; left: 10px; top: 10px; background: transparent; ;}
    </style>
</head>
<body>



<form name="myform" onSubmit="return handleClick()">
    <input name="Submit"  type="submit" value="Radius" />
    <input type="text" id="myRadius" maxlength="" />
</form>


<script>


    // width and height
    var w = 900;
    var h = 500;


    var mySVG = d3.select("body")
        .append("svg:svg")
        .attr("width", w)
        .attr("height", h);

    function handleClick(event){
        console.log(document.getElementById("myRadius").value)
        draw(document.getElementById("myRadius").value)
        return false;
    }

    function draw(rad){
        mySVG.append("svg:circle")
            .style("fill", "red")
            .attr("opacity", 0.4)
            .attr("r", rad)
            .attr("cx", Math.round(Math.random()*w))
            .attr("cy", Math.round(Math.random()*h))
    }

</script>


</body>
</html>