import axios from 'axios'



export function request(config){
	//1.创建axios的实例
	const instance = axios.create({
		
		baseURL:'http://localhost:8081/smbms_ssm_war',
		timeout : 5000
	})

	//2.axios的拦截器
	//2.1请求拦截
	instance.interceptors.request.use( config =>{

		//1.比如config中的一些信息不符合服务器的要求
		//2.比如每次发送网络请求时，都希望在界面中显示一个请求图标
		//3.某些网络请求(比如登录(token))，必须携带一些特殊信息 否则跳转到登录页面

			//做完之后
			return config
	})

	//2.2响应拦截
	instance.interceptors.response.use(res =>{
		return res.data
	} ,err => {
		console.log(err)
	})

	return instance(config)

}
