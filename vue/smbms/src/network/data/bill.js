import {request} from '../request.js'

export function getBillList(goodName,provider,isPayment) {
	return  request({
		url: '/billManagement.do/queryList',
		params:{
			queryProductName:goodName,
			queryProvider:provider,
			queryIsPayment:isPayment
		}
	})
}
export function getBillCount(goodName,provider,isPayment) {
	return request({
		url: '/billManagement.do/getBillCount',
		params:{
			queryProductName:goodName,
			queryProvider:provider,
			queryIsPayment:isPayment
		}
	})
}

export function modifyBill(item) {
	return request({
		url: '/billManagement.do/modify',
		params:{
			id:item.id,
			billCode:item.billCode,
			productName:item.productName,
			productDesc:item.productDesc,
			productUnit:item.productUnit,
			productCount:item.productCount,
			totalPrice:item.totalPrice,
			providerId:item.providerId,
			isPayment:item.isPayment,
			modifyBy:0
		}
	})
}

export function deleteBill(id){
	return request({
		url: '/billManagement.do/delete',
		params:{
			billid:id
		}
	})
}

export function addBill(item){
	return request({
		url: '/billManagement.do/add',
		params:{
			createdBy:0,
			billCode:item.billCode,
			productName:item.productName,
			productDesc:item.productDesc,
			productUnit:item.productUnit,
			productCount:item.productCount,
			totalPrice:item.totalPrice,
			providerId:item.providerId,
			isPayment:item.isPayment
		}
	})
}