import Toast from './Toast'

const obj = {}
obj.install = function(Vue){
	//1.创建组件构造器
	const toastContrustor = Vue.extend(Toast)
	//2.创建一个组件对象
	const toast = new toastContrustor()
	//3.将组件对象手动挂在到某个元素
	toast.$mount(document.createElement('div'))
	//4.挂载完后将其添加到页面
	document.body.appendChild(toast.$el)
	//5.让全局都能使用
	Vue.prototype.$toast = toast
}
export default obj