<template>
	
		<el-container>
		    <el-header style="font-size: 12px,width:100%">
				<el-input  class="input" type="text" clearable placeholder="请输入商品名称" v-model="goodName" />
				<el-select class="selectProvider" v-model="provider" clearable placeholder="选择供应商">
				    <el-option
				      v-for="item,index in selectProvider"
				      :key="index"
				      :label="item.label"
				      :value="item.value">
				    </el-option>
				  </el-select>
				  <el-select  class="selectIsPayment" v-model="isPayment" clearable placeholder="是否付款">
				      <el-option
				        v-for="item,index in isPaymentArrays"
				        :key="index"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
		      <el-button round class="btn" @click="queryClick">查询</el-button>
		      
		    </el-header>
		    
			<el-main>
			<el-table
			 :data="orderList"
			  style="width: 100%">
			  <el-table-column :prop="item.prop" :label="item.label" v-for="item,index in orderArrays" :key="item.index"></el-table-column>
			  <el-table-column label="操作" width="210">
				   <template slot-scope="scope">
					 <el-button
					   size="mini"
					   @click="handleQuery(scope.$index, scope.row)">查看</el-button>
					   <el-button
						 size="mini"
						 @click="handleAlter(scope.$index, scope.row)">修改</el-button>
					 <el-button
					   size="mini"
					   type="danger"
					   @click="handleDelete(scope.$index, scope.row)">删除</el-button>
				   </template>
				 </el-table-column>
			 </el-table-column>
			  
			</el-table>
			<h3 style="margin-left: 3%;">共{{orderCount}}条记录</h3>
			</el-main>
		  </el-container>
	
</template>

<script>
	import {getBillCount,getBillList,deleteBill} from "../../network/data/bill.js"
	import {getProviderNameList} from "../../network/data/provider.js"
	export default{
		name:"orderTable",
		activated() {
			getBillList().then(res =>{
				this.orderList = res
				
				for(let i in res){
					if(res[i].isPayment == 1)
					 res[i].isPayments = "未支付"		
					if(res[i].isPayment == 2)
					 res[i].isPayments = "已支付"
				}
				this.userList = res
			})
			getBillCount().then(res =>{
				this.orderCount = res
			})
			getProviderNameList().then(res =>{
				let arr = []
				this.selectProvider.splice(0,this.selectProvider.length)
				
				for(let i in res){
					 arr = {
						value:res[i].id,
						label:res[i].proName
					}		
					this.selectProvider.push(arr)
				}
			})
		},
		data(){
			return{
				orderCount:"",
				orderList:[],
				orderArrays:[{"label":"订单编码",prop:"billCode"},
							{"label":"商品名称",prop:"productName"},
							{"label":"供应商",prop:"proName"},
							{"label":"订单金额",prop:"totalPrice"},
							{"label":"是否付款",prop:"isPayments"},
							{"label":"创建时间",prop:"creationDate"}
							
			  ],
			  isPaymentArrays:[
				  {
				  value:"1",
				  label:'未支付'
				  },
				  {
				value:"2",
				label:'已付款'
				  }] ,
			
			  
			  selectProvider:[],
	
			//商品名称
			goodName:"",
			//供应商
			provider:'',
			//是否付款
			isPayment:'',
		}
		},
		methods:{
			queryClick(){
				getBillList(this.goodName,this.provider,this.isPayment).then(res =>{
						this.orderList = res
				})
				getBillCount(this.goodName,this.provider,this.isPayment).then(res =>{
						 this.totalCount = res
				})
			},
			handleQuery(index,item){
				this.$router.push({
					path:'/orderQuery',
					query:{
						item
					}
				})
			},
			handleAlter(index,item){
				this.$router.push({
					path:'/orderAlter',
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteBill(item.id).then(res => {
					this.orderList.splice(index,1)
					this.orderCount--
					this.$toast.show(res,1500)
				})
			}
			
		}
	}
</script>

<style scoped="scoped">
.input{
	width: 20%;
	margin-right: 8%;
	margin-left: 5%;
}
.selectProvider{
	width: 12%;
	margin-right: 8%;
}
.selectIsPayment{
	width: 10%;
}
.btn{
	width: 10%;
	position: relative;
	left: 20%;
}
</style>
