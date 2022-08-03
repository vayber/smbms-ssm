import {request} from '../request.js'

export function getProviderList(providerCode,prodviderName) {
	return request({
		url: '/providerManagement.do/queryList',
		params:{
			queryProCode:providerCode,
			queryProName:prodviderName			
		}
	})
}
export function getProviderCount(providerCode,prodviderName) {
	return request({
		url: '/providerManagement.do/getProviderCount',
		params:{
			queryProCode:providerCode,
			queryProName:prodviderName
		}
	})
}

export function getProviderNameList(){
	return request({
		url: '/providerManagement.do/getNameList'
	})
}

export function modifyProvider(item) {
	return request({
		url: '/providerManagement.do/modify',
		params:{
			id:item.id,
			proCode:item.proCode,
			proName:item.proName,
			proDesc:item.proDesc,
			proContact:item.proContact,
			proPhone:item.proPhone,
			proAddress:item.proAddress,
			proFax:item.proFax,
			modifyBy:0
		}
	})
}

export function deleteProvider(id){
	return request({
		url: '/providerManagement.do/delete',
		params:{
			proid:id
		}
	})
}

export function addProvider(item){
	return request({
		url: '/providerManagement.do/add',
		params:{
			createdBy:0,
			proCode:item.proCode,
			proName:item.proName,
			proDesc:item.proDesc,
			proContact:item.proContact,
			proPhone:item.proPhone,
			proAddress:item.proAddress,
			proFax:item.proFax
		}
	})
}