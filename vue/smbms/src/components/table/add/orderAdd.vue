<template>
	<el-container>
	    <el-header style="font-size: 12px;width:100%;text-align: center;">
		
		<h3>添加订单</h3>
	      
	    </el-header>
	    
		<el-main >
			<el-card class="box-card" >
				<div style="width: 30%; margin: 0 auto;">
		订单编码：<el-input placeholder="请输入订单编码" v-model="billCode" clearable/><br><br>
		商品名称：<el-input placeholder="请输入商品名称" v-model="productName" clearable/><br><br>
		商品描述：<el-input placeholder="请输入商品描述" v-model="productDesc" clearable/><br><br>
		商品单位：<el-input placeholder="请输入商品单位" v-model="productUnit" clearable/><br><br>
		商品数量：<el-input placeholder="请输入商品数量" v-model="productCount" clearable/><br><br>
		总金额：<el-input placeholder="请输入总金额" v-model="totalPrice" clearable/><br><br>
		供应商：<el-select style="width: 100%;"  v-model="providerId" clearable placeholder="请选择供应商">
				      <el-option
				        v-for="item in providerArrays"
				        :label="item.label"
				        :value="item.value"
				       >
				      </el-option>
				    </el-select>
					<br><br>
		是否付款：<el-select  style="width: 100%;" v-model="isPayment" clearable placeholder="是否付款">
				      <el-option
				        v-for="item in isPaymentArrays"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
				</div>
				<br><br>
				<div style="text-align: center; margin-right: 2%;">
				<el-button round class="backBtn" @click="saveClick">提交</el-button>
				<el-button round class="backBtn" @click="backClick">返回</el-button>
				</div>
		  </el-card >
		</el-main>
	  </el-container>
</template>

<script>
	import {getProviderNameList} from "../../../network/data/provider.js"
	import {addBill} from "../../../network/data/bill.js"
	export default{
		name:"orderAdd",
		activated() {
				
				getProviderNameList().then(res =>{
					this.providerArrays.splice(0,this.providerArrays.length)
					let arr = []
					for(let i in res){
						 arr = {
							value:res[i].id,
							label:res[i].proName
						}		
						this.providerArrays.push(arr)
					}
		
				})
		},
		data(){
			return{
					
					billCode:"",
					productName:"",
					productDesc:"",
					productUnit:"",
					productCount:"",
					totalPrice:"",
					providerId:"",
					isPayment:"",
					
				providerArrays:[],
				isPaymentArrays:[{
				  value:1,
				  label:'未支付'
				  },
				  {
				value:2,
				label:'已付款'
				  }] 
		}
		},
		methods:{
			saveClick(){
				let item = {
					billCode:this.billCode,
					productName:this.productName,
					productDesc:this.productDesc,
					productUnit:this.productUnit,
					productCount:this.productCount,
					totalPrice:this.totalPrice,
					providerId:this.providerId,
					isPayment:this.isPayment
				}
				addBill(item).then(res => {
					this.$toast.show(res,1500)
					})
				setTimeout(() => {
						this.$router.push("/orderTable")
					},1500)
			},
			backClick(){
				this.$router.go(-1)
			}
			
		}
	}
</script>

<style scoped="scoped">
	h3{
		font-size: 24px;
		line-height: 12px;
		color: aliceblue;
	}
</style>
