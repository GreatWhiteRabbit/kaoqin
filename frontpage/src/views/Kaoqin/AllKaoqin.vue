<template>
  <div>
    <el-row>
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="员工工号">
          <el-input  placeholder="请输入员工工号" v-model="count"></el-input>
        </el-form-item>
        <el-form-item label="考勤状态">
          <el-select  placeholder=" -- " v-model="state">
            <el-option label=" -- " value=""></el-option>
            <el-option label="正常" value="正常"></el-option>
            <el-option label="迟到" value="迟到"></el-option>
            <el-option label="早退" value="早退"></el-option>
            <el-option label="加班" value="加班"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"  @click="Search">查询</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row >
      <el-col >共查到{{AllData.length}}条记录</el-col>
    </el-row>
    <el-table :data="AllData" border style="width: 100%">
      <el-table-column prop="usename" label="用户名"></el-table-column>
      <el-table-column prop="count" label="工号"></el-table-column>
      <el-table-column prop="time" label="打卡时间"></el-table-column>
      <el-table-column prop="state" label="考勤状态"></el-table-column>
      <el-table-column prop="worktime" label="上班时间"></el-table-column>

    </el-table>
  </div>

</template>

<script>
export default {
  name: "AllKaoqin",
  data(){
    return{
      AllData:[],
      count:'',
      state:''
    }
  },
  methods:{
    getAllData(){
      this.$http.get('/dakaState/getAll'
      ).then(res => {
        this.AllData=res.data;
      })
    },
    Search(){
     this.$http.get('/dakaState/search',{
       params: {
         count: this.count,
         state: this.state
       }
       })
         .then(res => {
           this.AllData=res.data;
         })
    }
  },
  created() {
    this.getAllData();
  }
}
</script>

<style scoped>

</style>