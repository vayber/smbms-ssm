<template>
<div class="Toast" v-show="isShow">
  <div>{{message}}</div>
</div>
</template>

<script>
export default {
  name: "Toast",
  data(){
    return {
      message: '',
      isShow: false,
      isClick: true
    }
  },
  methods:{
    show(message='默认文字', time=2000){
      if(!this.isShow){
        this.isShow = true
        this.message = message
        setTimeout(()=>{
          this.isShow = false
          this.message = ''
        },time)
      }
    }
  }
}
</script>

<style scoped>
.Toast{
  position: fixed;
  z-index: 999;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0,0,0,.7);
  color: white;
  padding: 8px;
  border-radius: 5px;
}
</style>