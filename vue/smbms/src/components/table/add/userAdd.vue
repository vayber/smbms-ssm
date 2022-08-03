<template>
	<el-container>
	    <el-header style="font-size: 12px;width:100%;text-align: center;">
		
		<h3>添加用户</h3>
	      
	    </el-header>
	    
		<el-main >
			<el-card class="box-card" >
				<div style="width: 30%; margin: 0 auto;">
		用户名称：<el-input placeholder="请输入用户名称" v-model="userName" clearable/><br><br>
		用户编码：<el-input placeholder="请输入用户编码" v-model="userCode" clearable/><br><br>
		用户密码：<el-input placeholder="请输入用户密码" v-model="userPassword" clearable/><br><br>
		用户性别：<el-select  style="width: 100%;" v-model="gender" clearable placeholder="请选择用户性别">
				      <el-option
				        v-for="item in genderArrays"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
		<br><br>
		用户生日: <br><el-date-picker style="width: 100%;"
      v-model="birthday"
      type="date"
	   format="yyyy 年 MM 月 dd 日"
	   value-format="yyyy-MM-dd"
      placeholder="请选择生日">
    </el-date-picker><br><br>
		用户年龄：<el-input placeholder="请输入用户年龄" v-model="age" clearable/><br><br>
		用户电话：<el-input placeholder="请输入用户电话" v-model="phone" clearable/><br><br>
		用户角色：<el-select  style="width: 100%;" v-model="userRole" clearable placeholder="请选择用户角色">
				      <el-option
				        v-for="item in roleArrays"
				        :label="item.label"
				        :value="item.value">
				      </el-option>
				    </el-select>
		<br><br>
		家庭地址：<el-input placeholder="请输入地址" v-model="address" clearable/><br><br>
		
					
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
	import {addUser} from "../../../network/data/user.js"
	export default{
		name:"userAdd",
		activated() {
				
		},
		data(){
			return{
				userName:"",
				userCode:"",
				userPassword:"",
				gender:"",
				age:"",
				birthday:"",
				phone:"",
				userRole:"",
				address:"",
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
				let item = {
					userName:this.userName,
					userCode:this.userCode,
					userPassword:this.userPassword,
					gender:this.gender,
					age:this.age,
					birthday:this.birthday,
					phone:this.phone,
					userRole:this.userRole,
					address:this.address,
				}
				console.log(item)
				addUser(item).then(res => {
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
