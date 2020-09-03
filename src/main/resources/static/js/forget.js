function checkAccount() {
    let username = document.getElementById('username').value

    if (!username) {
        alert('Please input correct format username !!!')
    } else {
        let url = '/account/check-exist-account'
		
		let params = {
			username: username
		}
		
		console.log('Forget Request')
		axios.get(url, {
			params
		}).then(res => {
            console.log(res)
		}).catch(e => {
			console.log(e)
			alert('Some information is not correct ! Please check again !')
		})
    }
    
    return false
}

function checkVerifyCode() {
    
}