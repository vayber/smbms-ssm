<template>
	
		<el-container>
		    <el-header style="font-size: 12px;width:100%;text-align: center;">
			<h3>供应商详情</h3>
		      
		    </el-header>
		    
			<el-main>
			<el-descriptions class="margin-top"  :column="2"  border>
			   <el-descriptions-item>
			     <template slot="label">
			       <i class="el-icon-position"></i>
			       供应商ID
			     </template>
			     {{item.id}}
			   </el-descriptions-item>
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-postcard"></i>
			        供应商编码
			      </template>
			      {{item.proCode}}
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
			      地址
			    </template>
			    {{item.proAddress}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-user"></i>
			      联系人
			    </template>
			    {{item.proContact}}
			  </el-descriptions-item>
			  
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-goods"></i>
			      联系电话
			    </template>
			    {{item.proPhone}}
			  </el-descriptions-item>
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-c-scale-to-original"></i>
			      传真
			    </template>
			    {{item.proFax}}
			  </el-descriptions-item>
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-tickets"></i>
			      公司名称
			    </template>
			    {{item.proName}}
			  </el-descriptions-item>
			  
			  <el-descriptions-item>
			    <template slot="label">
			      <i class="el-icon-tickets"></i>
			      公司描述
			    </template>
			    {{item.proDesc}}
			  </el-descriptions-item>
			  
			  
			  
			  </el-descriptions>	
				
			 <el-button round class="backBtn" @click="backClick">返回</el-button>
			</el-main>
		  </el-container>
	
</template>

<script>
	
	export default{
		name:"providerQuery",
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
