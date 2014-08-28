function getHistory(obj) {
	$.ajax({
		type : "post",
		url : "gethistory.action",
		data : {
			query : obj.value
		},
		success : function(data) {
			var jsonobj=eval('('+data+')');
			$("#suggest").empty();
			for(var i=0;i<jsonobj.history.length;i++){
				$("#suggest").append("<ul><li onmouseover=javascript:overLiColor(this); onmouseout=javascript:outLiColor(this); onmousedown=javascript:onclickLi(this);>"+jsonobj.history[i].query+"</li></ul>");
			}                  
		}
	});
}
function mouseOver(obj) {
	obj.style.backgroundColor = '#fff';
}
function mouseOut(obj) {
	if (obj != document.activeElement)
		obj.style.backgroundColor = '#F7F8F8';
}
function blurinput(obj) {
	obj.style.backgroundColor = '#F7F8F8';
	document.getElementById("suggest").style.display="none";
}
function getFocus()
{
	document.getElementById("suggest").style.display="block";
}
function overLiColor(object)
{
	object.style.backgroundColor="#CCC";
}
function outLiColor(object)
{
	object.style.backgroundColor="#FFF";
}
function onclickLi(object)
{
	document.getElementById("query").value=object.innerHTML;
}
function getNames(object)
{
	alert(object.value);
}