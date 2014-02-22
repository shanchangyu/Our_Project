/**
 * the js for the header
 */
function verifyEmailFormat(email) {
	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;
	if (format.test(email)) {
		return true;
	}
	return false;
}

function verifyEmailCB(email) {
	if (email.length == 0) {
		return;
	} else {
		if (!verifyEmailFormat(email)) {
			document.getElementById('errorEmail').innerHTML = "<h6>邮箱格式不正确，请您输入正确的邮箱地址!<h6/>";
			document.getElementById('errorEmail').style.display = "";
			return;
		} else {
			document.getElementById('errorEmail').style.display = "none";
		}
	}
	$
			.getJSON(
					"/those_people/register/verifyEmail.do",
					{
						email : email
					},
					function(data, textStatus) {
						if (data.result == false) {
							document.getElementById('errorEmail').innerHTML = "<h6>帐号已存在，请直接登录!<h6/>";
							document.getElementById('errorEmail').style.display = "";
						}
					});
}

function ifPasswordAndRePasswordSame(password, rePassword) {
	if (password == rePassword) {
		return true;
	}
	return false;
}

function verifyRepeatPassword(rePassword) {
	var password = document.getElementById('password').value;
	if (ifPasswordAndRePasswordSame(password, rePassword)) {
		document.getElementById('errorRePassword').style.display = "none";
	} else {
		document.getElementById("errorRePassword").innerHTML = "<h6>两次密码不一致!</h6>";
		document.getElementById('errorRePassword').style.display = "";
	}
}
function hideWarnText(elementId) {
	document.getElementById(elementId).style.display = "none";
}
function checkRegister() {
	var realName = document.getElementById("realName").value;
	var nickName = document.getElementById("nickName").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById('password').value;
	var rePassword = document.getElementById('rePassword').value;
	if (realName.length == 0 || nickName.length == 0 || email.length == 0
			|| password.length == 0 || rePassword.lenght == 0) {
		if (realName.length == 0) {
			document.getElementById('errorRealName').innerHTML = "<h6>请填写您的真实姓名!<h6/>";
			document.getElementById('errorRealName').style.display = "";
		}
		if (nickName.length == 0) {
			document.getElementById('errorNickName').innerHTML = "<h6>请填写您的昵称!<h6/>";
			document.getElementById('errorNickName').style.display = "";
		}
		if (email.length == 0) {
			document.getElementById('errorEmail').innerHTML = "<h6>请您填写邮箱!<h6/>";
			document.getElementById('errorEmail').style.display = "";
		}
		if (password.length == 0) {
			document.getElementById('errorPassword').innerHTML = "<h6>请您填写密码!<h6/>";
			document.getElementById('errorPassword').style.display = "";
		}
		if (rePassword.length == 0) {
			document.getElementById('errorRePassword').innerHTML = "<h6>请您再次填写密码!<h6/>";
			document.getElementById('errorRePassword').style.display = "";
		}
		return false;
	}
	if (!verifyEmailFormat(email)) {
         
	}
	if (ifPasswordAndRePasswordSame(password, rePassword)) {

	}

}
