<template>
	<div>
	<h1 class="title">超级超市管理系统</h1>
	<el-container style="height: 500px; border: 1px solid #eee">
	  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
	    <el-menu 
		  :unique-opened="true" 
		>
		  
	      <el-submenu index="1" >
	        <template slot="title"><i class="el-icon-menu"></i>订单管理</template>
	        <el-menu-item-group>
				 <el-menu-item index="1-1" @click="orderTable">
					 <i class="el-icon-s-order"></i>
						订单列表
					 </el-menu-item>
					 <el-menu-item index="1-2" @click="orderAdd">
						 <i class="el-icon-circle-plus"></i>
			 			添加订单
					 </el-menu-item>
	        </el-menu-item-group>
	      
	      </el-submenu>
		  
		  
	      <el-submenu index="2" >
	        <template slot="title"><i class="el-icon-menu"></i>供应商管理</template>
	        <el-menu-item-group>
	       
	        <el-menu-item index="2-1" @click="providerTable">
				<i class="el-icon-s-order"></i>
			供应商列表
		 </el-menu-item>
		 <el-menu-item index="2-2" @click="providerAdd">
			 <i class="el-icon-circle-plus"></i>
			添加供应商
		 </el-menu-item>
			
			</el-menu-item-group>
	      </el-submenu>
		  
		  
		  
		  <el-submenu index="3" >
		    <template slot="title"><i class="el-icon-menu"></i>用户管理</template>
		    <el-menu-item-group>
			 <el-menu-item index="3-1" @click="userTable">
				 <i class="el-icon-s-order"></i>
				用户列表
			 </el-menu-item>
			 <el-menu-item index="3-2" @click="userAdd">
				 <i class="el-icon-circle-plus" ></i>
				添加用户
			 </el-menu-item>
		    </el-menu-item-group>
		  </el-submenu>
		  
		  
	    </el-menu>
	  </el-aside>
	  
		<keep-alive>
		  <router-view/>
		</keep-alive>
	  </el-container>
	  <h1 class="title">Vayber</h1>
	  
	  </div>
	  
</template>

<script>
	export default {
		name : "elenemt",
		
		data() {
		      return {
				 
		      }
			  
		    
			},
		methods:{
			orderTable(){
				this.$router.push("/orderTable")
			},
			orderAdd(){
				this.$router.push("/orderAdd")
			},
			providerTable(){
				this.$router.push("/providerTable")
			},
			providerAdd(){
				this.$router.push("/providerAdd")
			},
			userTable(){
				this.$router.push("/userTable")
			},
			userAdd(){
				
				this.$router.push("/userAdd")
			}
			
			
			   }
		
		
	}
</script>

<style>
	.el-header {
	    background-color: #B3C0D1;
	    color: #333;
	    line-height: 60px;
	  }
	  
	  .el-aside {
	    color: #333;
	  }
	  .title{
		  color: #B3C0D1;
		  text-align: center;
	  }

</style>
