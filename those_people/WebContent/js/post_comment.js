function postCommnet(infoType,commentType,commentUserId){
	var content=$("#commentConten").val();
	if($.trim(content).length==0){
		return;
	}
	var infoId=$("#infoId").val();
	alert(infoId);
	$.post("/those_people/post_comment/post.do",{"infoType":infoType,
		"commentType":commentType,"commentContent":content,
		"commentUserId":commentUserId,"infoId":infoId},function(result){
		alert(result.result);
	});
}