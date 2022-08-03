<template>
	<el-container>
	    <el-header style="font-size: 12px;width:100%;text-align: center;">
		
		<h3>用户修改</h3>
	      
	    </el-header>
	    
		<el-main >
			<el-card class="box-card" >
				<div style="width: 30%; margin: 0 auto;">
		用户名称：<el-input placeholder="请输入用户名称" v-model="item.userName" clearable/><br><br>
		用户性别：<el-select  style="width: 100%;" v-model="item.gender" clearable placeholder="请选择用户性别">
				      <el-option
				        v-for="item in genderArrays"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
		<br><br>
		用户年龄：<el-input placeholder="请输入用户年龄" v-model="item.age" clearable/><br><br>
		用户电话：<el-input placeholder="请输入用户电话" v-model="item.phone" clearable/><br><br>
		用户角色：<el-select  style="width: 100%;" v-model="item.userRole" clearable placeholder="请选择用户角色">
				      <el-option
				        v-for="item in roleArrays"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
		<br><br>
		家庭地址：<el-input placeholder="请输入用户电话" v-model="item.address" clearable/><br><br>
		
					
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
	import {modifyUser} from "../../../network/data/user.js"
	export default{
		name:"orderAlter",
		activated() {
				this.item = this.$route.query.item
		},
		data(){
			return{
				item:{},
				
					genderArrays:[{
					  value:1,
					  label:'女'
					  },
					  {
					value:2,
					label:'男'
					  }],
					  
					  
					  roleArrays:[{
					    value:1,
					    label:'系统管理员'
					    },
					    {
					  value:2,
					  label:'经理'
					    },
						{
						value:3,
						label:'普通员工'
						  }]
		}
		},
		methods:{
			saveClick(){
				modifyUser(this.item).then(res => {
					this.$toast.show(res,1500)
				})
				setTimeout(() => {
					this.$router.push("/userTable")
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
