<template>
<div>
  <el-row v-if="OverTime.length!==0">
    <el-col>个人加班时长{{total}}分钟</el-col>
  </el-row>
  <el-table :data="OverTime" border style="width: 100%" >
    <el-table-column prop="usename" label="用户名" ></el-table-column>
    <el-table-column prop="count" label="工号"></el-table-column>
    <el-table-column prop="time" label="打卡时间"></el-table-column>
    <el-table-column prop="worktime" label="上班时间"></el-table-column>
    <el-table-column prop="state" label="加班时长（分钟）"></el-table-column>
  </el-table>
</div>
</template>

<script>
export default {
  name: "PersonalOverTime",
  data(){
    return{
      OverTime:[],
      count:'',
      total:0
    }
  },
  created() {
    this.get();
  },
  methods:{
        get(){
          this.$http.get('/dakaState/getOverTime',{
            params:{
              count:window.sessionStorage.getItem('account')
            }
          })
              .then(res => {
               this.OverTime=res.data;
               this.format();
              })
        },
    format(){
          for(let i=0;i<this.OverTime.length;i++){
            var a=this.OverTime[i].time.substring(11);
            var b=this.OverTime[i].worktime.substring(6);
            var a1=a.split(':');
            var b1=b.split(':');
            var a_num1=Number(a1[0]);
            var a_num2=Number(a1[1]);
            var b_num1=Number(b1[0]);
            var b_num2=Number(b1[1]);
            this.OverTime[i].state=a_num1*60+a_num2-b_num1*60-b_num2;
            this.total+=this.OverTime[i].state;
          }
    }
  }
}
</script>

<style scoped>

</style>