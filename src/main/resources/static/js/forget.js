function checkAccount() {
    let username = document.getElementById('username').value

    if (!username) {
        alert('Please input correct format username !!!')
    } else {
        let url = '/account/check-exist-account'
		
		let params = {
			username: username
		}

		axios.get(url, {params}).then(res => {
			console.error(res)
			checkVerifyCode(res.data + '', username)
		}).catch(e => {
			console.error(e)
			alert('Some information is not correct ! Please check again !')
		})
    }
    
    return false
}

function checkVerifyCode(verifyCode, username) {
	let code = prompt('Check email to input verify code : ')

	console.error(verifyCode)
	console.error(code)

	if (code === verifyCode) {
		let newPassword = prompt('Enter new password : ')

		let url = '/account/reset-password'
		let param = {
			username: username,
			password: password
		}
		axios.get(url, {params}).then(res => {
			window.location.replace("http://localhost:8084")
		}).catch(e => console.log(e))

	} else {
		alert('Your verify code is not correct !!!')
	}
}