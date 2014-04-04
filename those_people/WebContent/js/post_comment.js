function postCommnet(infoType,commentType,commentUserId){
	var content=$("#commentConten").val();
	if($.trim(content).length==0){
		return;
	}
	var infoId=$("#infoId").val();

	$.post("/those_people/post_comment/post.do",{"infoType":infoType,
		"commentType":commentType,"commentContent":content,
		"commentUserId":commentUserId,"infoId":infoId},
		function(data){
			if (data.result  == "success") 
			{
				$('#commentBody').append(
						'<hr class="featurette-divider"><div class="row"><div class="col-md-2"><img src="'+
						data.headPic+'" class="img-rounded" id="head-pic-comment"> <label id="commentUser">'
						+data.Nickname+'</label></div><div class="col-md-10">'+
						data.comment+'</div></div>'
				);  
			}
		});
}