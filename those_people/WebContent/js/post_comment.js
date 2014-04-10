function postCommnet(infoType,commentType,commentUserId){
	var content=$("#commentContent").val();
	if($.trim(content).length==0){
		return;
	}
	$("#commentContent").val("");
	var infoId=$("#infoId").val();

	$.post("/those_people/post_comment/post.do",{"infoType":infoType,
		"commentType":commentType,"commentContent":content,
		"commentUserId":commentUserId,"infoId":infoId},
		function(data){
			alert(data.result);
			if (data.result  == "success") 
			{
				$('#commentOfInfo').append(
						'<hr class="featurette-divider"><div class="row"><div class="col-md-2"><img src="../img/head-pic/head.jpg" class="img-rounded" id="head-pic-comment"> <label id="commentUser">'
						+"忒各色"+'</label></div><div class="col-md-10">'+
						data.commentContent+'</div></div>'
				);  
			}
		});
}