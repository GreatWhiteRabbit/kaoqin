<template>
  <el-form ref="form" label-width="80px">
    <el-form-item label="上班时间">
      <el-input v-model="startTime"></el-input>
    </el-form-item>
    <el-form-item label="下班时间">
      <el-input v-model="endTime"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="updateWorkTime">修改时间</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "AddWorkTime",
  data() {
    return {
      startTime: '',
      endTime: ''
    }
  },
  created() {
    this.getWorkTime();
  },
  methods: {
    getWorkTime() {
      this.$http.get("/time/getWorkTime").then(res => {
        console.log(res.data[0]);
        this.startTime=res.data[0].starttime;
        this.endTime=res.data[0].endtime;
      })
    },
    updateWorkTime(){
      this.$http.post("/time/updateTime", {starttime:this.startTime, endtime:this.endTime})
          .then(res => {
            if(res.data===true){
              this.$message({
                message:'修改成功',
                type:"success"
              })
            } else {
              this.$message({
                message:'修改失败',
                type:"error"
              })
            }
          })
    }
  }
}
</script>

<style scoped>

</style>