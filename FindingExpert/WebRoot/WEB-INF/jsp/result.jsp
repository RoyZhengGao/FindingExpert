<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

{"history": 
[
<s:iterator id="element" value="history" status="status" >
   {
      "query":"<s:property value='#element' />"
   }
   <s:if test="#status.count < history.size">,</s:if>   

</s:iterator>
] }

