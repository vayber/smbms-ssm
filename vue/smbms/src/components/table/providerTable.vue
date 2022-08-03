<template>
	<el-container>
	    <el-header style="font-size: 12px,width:100%">
			<el-input  class="input" type="text" clearable placeholder="请输入供应商编码" v-model="providerCode" />
			<el-input  class="input" type="text" clearable placeholder="请输入供应商名称" v-model="providerName" />
			  
	      <el-button round class="btn" @click="queryClick">查询</el-button>
	      
	    </el-header>
	    
		<el-main>
		<el-table
		 :data="providerList"
		  style="width: 100%">
		  <el-table-column :prop="item.prop" :label="item.label" v-for="item,index in providerArrays" :key="item.index"></el-table-column>
		  <el-table-column label="操作" width="210">
			   <template slot-scope="scope">
				 <el-button
				   size="mini"
				   @click="handleSelect(scope.$index, scope.row)">查看</el-button>
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
		<h3 style="margin-left: 3%;">共{{providerCount}}条记录</h3>
		</el-main>
	  </el-container>
</template>

<script>
	import {getProviderCount,getProviderList,deleteProvider} from "../../network/data/provider.js"
	export default{
		name:"providerTable",
		activated() {
			getProviderCount().then(res =>{
				this.providerCount = res
				
			})
			getProviderList().then(res =>{
				this.providerList = res
				
			})
		},
		data(){
			return{
			providerArrays:[{"label":"供应商编码",prop:"proCode"},
							{"label":"供应商名称",prop:"proName"},
							{"label":"联系人",prop:"proContact"},
							{"label":"联系电话",prop:"proPhone"},
							{"label":"传真",prop:"proFax"},
							{"label":"创建时间",prop:"creationDate"}
			  ],
			  providerList:[],
			  providerCode:'',
			  providerName:'',
			  providerCount:'',
							  
			}
		},
		methods:{
			queryClick(){
				getProviderList(this.providerCode,this.providerName).then(res =>{
									  this.providerList = res
				})
				getProviderCount(this.providerCode,this.providerName).then(res =>{
										this.providerCount = res
				})
			},
			handleSelect(index,item){
				this.$router.push({
					path:'/providerQuery',
					query:{
						item
					}
				})
			},
			handleAlter(index,item){
				this.$router.push({
					path:'/providerAlter',
					query:{
						item
					}
				})
			},
			handleDelete(index,item){
				deleteProvider(item.id).then(res => {
					this.providerList.splice(index,1)
					this.providerCount--
					this.$toast.show(res,1500)
				})
			}
			
		}
		
		
	}
</script>

<style scoped="scoped">
	.input{
		width: 20%;
		margin-right: 5%;
		margin-left: 5%;
	}
	.btn{
		width: 10%;
		position:relative;
		left: 23%;
	}
</style>
