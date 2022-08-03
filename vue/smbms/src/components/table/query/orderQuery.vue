<template>
	
		<el-container>
		    <el-header style="font-size: 12px;width:100%;text-align: center;">
			
			<h3>订单详情</h3>
		      
		    </el-header>
		    
			<el-main>
			<el-descriptions class="margin-top"  :column="2"  border>
			   <el-descriptions-item>
			     <template slot="label">
			       <i class="el-icon-position"></i>
			       订单ID
			     </template>
			     {{item.id}}
			   </el-descriptions-item>
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-postcard"></i>
			        订单编号
			      </template>
			      {{item.billCode}}
			    </el-descriptions-item>
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-user"></i>
			        创建人
			      </template>
			     {{item.createdBy}}
			    </el-descriptions-item>
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-date"></i>
			        创建日期
			      </template>
			      {{item.creationDate}}
			    </el-descriptions-item>
			    
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-user"></i>
			        修改人
			      </template>
			      {{item.modifyBy}}
			    </el-descriptions-item>
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-date"></i>
			      修改日期
			    </template>
			    {{item.modifyDate}}
			  </el-descriptions-item>
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-position"></i>
			      供应商ID
			    </template>
			    {{item.providerId}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-user"></i>
			      供应商
			    </template>
			    {{item.proName}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-tickets"></i>
			      支付状态
			    </template>
			    <el-tag size="small">{{item.isPayments}}</el-tag>
			  </el-descriptions-item>
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-goods"></i>
			      商品名
			    </template>
			    {{item.productName}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-c-scale-to-original"></i>
			      商品数量
			    </template>
			    {{item.productCount}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-tickets"></i>
			      商品描述
			    </template>
			    {{item.productDesc}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-reading"></i>
			      商品单位
			    </template>
			    {{item.productUnit}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-money"></i>
			      总价格
			    </template>
			    {{item.totalPrice}}
			  </el-descriptions-item>
			  </el-descriptions>
			  <el-button round class="backBtn" @click="backClick">返回</el-button>
			</el-main>
		  </el-container>
	
</template>

<script>
	
	export default{
		name:"orderQuery",
		activated() {
				this.item = this.$route.query.item
		},
		data(){
			return{
				item:{}
		}
		},
		methods:{
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
	.backBtn{
		 position: relative;
		 left: 75%;
		 top: 5%;
		 width: 10%;
	}
</style>
