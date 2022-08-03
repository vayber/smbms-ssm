<template>
	
		<el-container>
		    <el-header style="font-size: 12px;width:100%;text-align: center;">
			
			<h3>用户详情</h3>
		      
		    </el-header>
		    
			<el-main>
				<br>
			<el-descriptions class="margin-top"  :column="2"  border>
			   <el-descriptions-item>
			     <template slot="label">
			       <i class="el-icon-position"></i>
			       用户ID
			     </template>
			     {{item.id}}
			   </el-descriptions-item>
			    <el-descriptions-item>
			      <template slot="label">
			        <i class="el-icon-postcard"></i>
			        用户身份
			      </template>
			      {{item.roleName}}
			    </el-descriptions-item>
				
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-c-scale-to-original"></i>
				    用户编码
				  </template>
				  {{item.userCode}}
				</el-descriptions-item>
				
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-tickets"></i>
				    用户名称
				  </template>
				  {{item.userName}}
				</el-descriptions-item>
				
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-discover"></i>
				    用户性别
				  </template>
				  {{item.userGender}}
				</el-descriptions-item>
				
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-magic-stick"></i>
				    用户年龄
				  </template>
				  {{item.age}}
				</el-descriptions-item>
				
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-timer"></i>
				    用户生日
				  </template>
				  {{item.birthday}}
				</el-descriptions-item>
				<el-descriptions-item>
				  <template slot="label">
				    <i class="el-icon-mobile-phone"></i>
				    用户电话
				  </template>
				  {{item.phone}}
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
			        <i class="el-icon-user"></i>
			        修改人
			      </template>
			      {{item.modifyBy}}
			    </el-descriptions-item>
			 
			 <el-descriptions-item>
			   <template slot="label">
			     <i class="el-icon-s-promotion"></i>
			     家庭地址
			   </template>
			   {{item.address}}
			 </el-descriptions-item>
			  
			  </el-descriptions>
			  <br>
			  <el-button round class="backBtn" @click="backClick">返回</el-button>
			</el-main>
		  </el-container>
	
</template>

<script>
	
	export default{
		name:"userQuery",
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
