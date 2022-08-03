import {request} from '../request.js'

export function getUser(name,password) {
	return request({
		url: '/operate.do/checkLogin',
		params:{
			userCode:name,
			userPassword:password
		}
	})
}