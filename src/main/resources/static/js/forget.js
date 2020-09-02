function checkAccount() {
    let username = document.getElementById('username').value

    if (!username) {
        alert('Please input correct format username !!!')
    } else {
        let url = '/account/check-exist-account'
		axios.get(url, params).then(res => {
            console.log(res)
            checkVerifyCode()
		}).catch(e => {
			console.log(e)
			alert('Some information is not correct ! Please check again !')
		})
    }
    
    return false
}

function checkVerifyCode() {
    
}