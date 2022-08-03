import {request} from '../request.js'

export function getUserList(userName,userRole) {
	return request({
		url: '/management.do/queryList',
		params:{
			queryname:userName,
			queryUserRolesss:userRole
		}
	})
}

export function getUserCount(userName,userRole) {
	return request({
		url: '/management.do/getUserCount',
		params:{
			queryname:userName,
			queryUserRolesss:userRole
		}
	})
}

export function modifyUser(item) {
	return request({
		url: '/management.do/modify',
		params:{
			id:item.id,
			userName:item.userName,
			gender:item.gender,
			age:item.age,
			phone:item.phone,
			address:item.address,
			userRole:item.userRole,
			modifyBy:0
		}
	})
}

export function deleteUser(id){
	return request({
		url: '/management.do/delete',
		params:{
			uid:id
		}
	})
}

export function addUser(item){
	return request({
		url: '/management.do/add',
		params:{
			userName:item.userName,
			userCode:item.userCode,
			userPassword:item.userPassword,
			gender:item.gender,
			userAge:item.age,
			birthday:item.birthday,
			phone:item.phone,
			queryUserRole:item.userRole,
			address:item.address,
			createdBy:0
		}
	})
}