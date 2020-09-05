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
			console.error(res.data)
			return checkVerifyCode(res.data + '', username)
		}).catch(e => {
			console.error(e)
			alert('Some information is not correct ! Please check again !')
		})
    }
    
    return false
}

function checkVerifyCode(verifyCode, username) {
	let code = prompt('Check email to input verify code : ')

	if (code === verifyCode) {
		let url = '/reset'
		let params = {
			username: username
		}
		// axios.get(url, {params})
		document.getElementById('forgetForm').submit()
	} else {
		alert('Your verify code is not correct !!!')
		return false
	}
}

function resetPassword() {
	let username = document.getElementById('username').value
    let password = document.getElementById('password').value

    if (!password) {
        alert('Please input new password !')
    } else {
        let url = '/account/reset-password'
		
		let params = {
			username: username,
			password: password
		}

		axios.get(url, {params}).then(res => {
			window.location.replace("http://localhost:8084")
		}).catch(e => {
			console.error(e)
			alert('Some information is not correct ! Please check again !')
		})
    }
    
    return false	
}