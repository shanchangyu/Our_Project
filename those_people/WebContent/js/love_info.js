function likeThisInfo() {

};

function showWarnMessage(message) {
	$("#errorInfo").html("<h4>" + message + "<h4/>");
	$("#errorInfo").show();
};

function hideWarnMessage() {
	$("#errorInfo").hide();
};
function checkPostLoveInfo() {
	var title = $("#infoTitle").val();
	var selfDescribe = $("#selfDescribe").val();
	var expectOther = $("#expectOther").val();
	var contactWay = $("#contactWay").val();
	if ($.trim(title).length == 0 || $.trim(selfDescribe).length==0
			|| $.trim(expectOther).length == 0
			|| $.trim(contactWay).length == 0) {
		showWarnMessage("请您把必要信息填写完整！");
		return false;
	}
	return true;
};