function checkRegis() {
	let username = document.getElementById('username').value
	let password = document.getElementById('password').value
	let confirm = document.getElementById('confirmPassword').value
	let fullname = document.getElementById('fullname').value
	let email = document.getElementById('email').value
	
	if (!username || !password || !confirm || !fullname || !email || !email.match("^[a-z][a-z0-9_\.]{5,32}@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$") || password !== confirm) {
		alert("Your information is not correct! Please check again !")
		return false;
	} else {
		let params = {
			username: username,
			password: password,
			fullname: fullname,
			email: email
		}
		
		axios.post('/account/register-account', params).then(res => {
			console.log(res)
		}).catch(e => {
			alert('Request Fail')
			console.log(e)
		})
		
		return false
	}
}