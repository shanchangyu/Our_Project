//this is for upload head picture
function preview(file) {
	console.log("onchange preview");
	var prevDiv = document.getElementById('preview');
	if (file.files && file.files[0]) {
		var reader = new FileReader();
		reader.onload = function(evt) {
			prevDiv.innerHTML = '<img id="headpic" src="'
					+ evt.target.result
					+ '"  style="height:290px;width:290px;padding-left:5px;padding-right:5px;" class="img-rounded"/>';
		};
		reader.readAsDataURL(file.files[0]);
		$('#uploadHeadPicModal').modal();
	} else {
		prevDiv.innerHTML = '<div class="img-rounded" id="headpic" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\''
				+ file.value + '\'"></div>';
		$('#uploadHeadPicModal').modal();
	}
	$('#uploadHeadPicModal').on('shown.bs.modal', function(e) {
		$('#preview').imgAreaSelect({
			x1 : 60,
			y1 : 40,
			x2 : 320,
			y2 : 300,
			resizable : false,
			persistent : true,
			onInit : function(img, selection) {
				$("#picx").val(selection.x1);
				$("#picy").val(selection.y1);
				$("#picwid").val(selection.width);
				$("#pichei").val(selection.height);
			},
			onSelectEnd : function(img, selection) {
				$("#picx").val(selection.x1);
				$("#picy").val(selection.y1);
				$("#picwid").val(selection.width);
				$("#pichei").val(selection.height);
			}
		});
	});
	$('#uploadHeadPicModal').on('hide.bs.modal', function(e) {
		$('#preview').imgAreaSelect({
			remove : true
		});
	});
}

function checkUploadAndSubmit() {
	var location = document.getElementById("headpicfile").value;
	if (location == "") {
		alert("请先选择图片文件");
		return;
	}
	var point = location.lastIndexOf(".");
	var type = location.substr(point);
	if (type == ".jpg" || type == ".gif" || type == ".JPG" || type == ".GIF"
			|| type == ".PNG" || type == ".png") {
		 $("#headpictoupload").submit();
	} else {
		alert("只能输入jpg或者gif格式的图片");
		return;
	}
}

function callbackupload(headpicurl) {
	$("#headerpic").attr("src", headpicurl);
}
