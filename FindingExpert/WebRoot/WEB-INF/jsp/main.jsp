<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JobSeeker</title>
<script type="text/javascript" src="javascript/jquery.js">
	
</script>
<link href="css/main.css" rel="stylesheet" type="text/css" media="screen" /> 
<script type="text/javascript" src="javascript/common.js"></script>
<script type="text/javascript" src="javascript/jquery.js"></script>
</head>

<body>
    <section class = "index-content">
    	
	    <img src="pic/dissertation_meitu_2.jpg" class="item"/>
	    <section class = "srchmenu">
	    	
	    	<form action="getallexperts.action">
	
	    	<div class="search_center">
	    		<div id="searchInput">
	            	<input id = "query" name="query" class="searchbox" type = "text" size = "35" onkeyup="javascript:getHistory(this);" onfocus="getFocus()"  onmouseover="mouseOver(this)" onmouseout="mouseOut(this)" onblur="blurinput(this)" placeholder = "Interesting Topics" />
	            	<button type="submit" id = "search" >Search</button>
	            </div>
	            <div id="suggest" style="display:none;" >
	            	<ul>
	                	<li onmouseover="javascript:overLiColor(this);" onmouseout="javascript:outLiColor(this);" onmousedown="javascript:onclickLi(this);"></li>
	                </ul>
	            </div>
	        </div>
	        
	        </form>
	    </section>
    </section>
    <footer>
          
    </footer>
</body>
</html>
