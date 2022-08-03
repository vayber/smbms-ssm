//配置路由相关的信息
import VueRouter from 'vue-router'
import Vue from 'vue'



const Element = () => import("../components/element.vue")

const FirstPage = () => import("../components/table/firstPage.vue")
const OrderTable = () => import("../components/table/orderTable.vue")
const ProviderTable = () => import("../components/table/providerTable.vue")
const UserTable = () => import("../components/table/userTable.vue")

const OrderQuery = () => import("../components/table/query/orderQuery.vue")
const ProviderQuery = () => import("../components/table/query/providerQuery.vue")
const UserQuery = () => import("../components/table/query/userQuery.vue")



const OrderAlter = () => import("../components/table/alter/orderAlter.vue")
const ProviderAlter = () => import("../components/table/alter/providerAlter.vue")
const UserAlter = () => import("../components/table/alter/userAlter.vue")

const OrderAdd = () => import("../components/table/add/orderAdd.vue")
const ProviderAdd = () => import("../components/table/add/providerAdd.vue")
const UserAdd = () => import("../components/table/add/userAdd.vue")
//1.通过Vue.use(插件),安装插件
Vue.use(VueRouter)

//解决重复点击路由跳转报错
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

//2.创建VueRouter对象
//映射
const routes = [
  {
    path:'',
    //重定向
    redirect:'/element'
  },
  {
    path:'/element',
    component:Element,
	children:[
		{
		  path:'',
		  //重定向
		  redirect:'/home'
		},
		{
			path:'/home',
			component:FirstPage
		},
			//订单
			{
				path:'/orderTable',
				component:OrderTable
			},
			{
				path:'/orderQuery',
				component:OrderQuery
			},
			{
				path:'/orderAlter',
				component:OrderAlter
			},
			{
				path:'/orderAdd',
				component:OrderAdd
			},
				//供应商
				{
					path:'/providerTable',
					component:ProviderTable
				},
				{
					path:'/providerQuery',
					component:ProviderQuery
				},
				{
					path:'/providerAlter',
					component:ProviderAlter
				},
				{
					path:'/providerAdd',
					component:ProviderAdd
				},
					//用户
					{
						path:'/userTable',
						component:UserTable
					},
					{
						path:'/userQuery',
						component:UserQuery
					},
					{
						path:'/userAlter',
						component:UserAlter
					},
					{
						path:'/userAdd',
						component:UserAdd
					}
	]
  }
]


//router 是一个机制，相当于一个管理者，它来管理路由。
// 因为routes 只是定义了一组路由，它放在哪里是静止的，
// 当真正来了请求，怎么办？ 就是当用户点击home 按钮的时候，
// 怎么办？这时router 就起作用了，它到routes 中去查找，
// 去找到对应的 home 内容，所以页面中就显示了 home 内容。


const router = new VueRouter({
   routes,
   mode:'history',
   linkActiveClass:'active'
})

//3.将router对象传入到Vue实例中
export default router
