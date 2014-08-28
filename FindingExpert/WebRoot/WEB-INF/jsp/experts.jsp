<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'job.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/main.css" rel="stylesheet" type="text/css" media="screen" /> 
	<script type="text/javascript" src="javascript/common.js"></script>
	<script type="text/javascript" src="javascript/jquery.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <header>
       <section class = "index-content">
	    <img src="pic/dissertation_meitu_2.jpg" class="item"/>
	    <section class = "srchmenu">  
    </header>
    <section class = "srchtop">
    <div class="search_center2">
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
    </div>
    </section>
        <section class = "content" style="margin-top:50px;">
            <h1 class="grayWords" >First <s:property value='users.size'/> Experts:</h1>
            <hr/>
            <s:iterator id="element" value="users" status="status" >
            <section>
            	
           	 	<section class = "item">
	            <div name="users" class = "jobs">
		            <section class="item_left">
	            		<img name="img" src="<s:property value='#element.profile_image_url' />" />
	            	</section>
	                <div name="Name" class="title"><a href="https://twitter.com/<s:property value='#element.screen_name' />"><h1><s:property value='#element.name' />(@<s:property value='#element.screen_name' />)</h1></a></div>
	                <div name="Website" class="company"><span class="fontColor">Website: </span><a href="<s:property value='#element.url' />"><s:property value='#element.url' /></a></div>
	                <div name="Description" class="company"><span class="fontColor">Location: </span><s:property value='#element.location' /></div>
	                <div name="summary" class="summary">
	                	<span class="fontColor">Description:</span> <s:property value='#element.description' />
	                </div>
	            </div>
	            </section>
			   <s:if test="#status.count < jobs.size"></s:if>  
			</section>
			</s:iterator>
        </section> 
    <footer>
    </footer>
  </body>
</html>
