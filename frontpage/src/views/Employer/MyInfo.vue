<template>
  <div>
    <el-descriptions class="margin-top" :title="page.name" :column="3" border>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          empId
        </template>
        <span>{{ page.empId }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          用户名
        </template>
        <span>{{ page.name }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          手机号
        </template>
        <span>{{ page.phone }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-time"></i>
          入职时间
        </template>
        <span>{{ formatDate(page.createTime) }}</span>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          角色
        </template>
        <el-tag size="small">{{ formatRole(page.role) }}</el-tag>
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-message"></i>
          邮箱
        </template>
        {{ page.email }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-male"></i>
          性别
        </template>
        {{ formatGender(page.gender) }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-loading"></i>
          密码
        </template>
        {{ page.password }}
      </el-descriptions-item>
    </el-descriptions>

    <el-form>
      <el-form-item>
        <el-button type="primary" @click="updateInfo">修改个人信息</el-button>
        <el-button @click="isshow=false">取消</el-button>
      </el-form-item>
    </el-form>
    <el-form v-if="isshow" label-width="80px">
      <el-form-item label="手机号" style="width: 300px">
        <el-input v-model="phone"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" style="width: 300px">
        <el-input v-model="email"></el-input>
      </el-form-item>
        <el-form-item label="密码" style="width: 300px">
          <el-input v-model="password"></el-input>
        </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="update">修改</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  data() {
    return {
      seach: {
        account: '0',
      },
      page: {},
      isshow: false,
      phone: '',
      email: '',
      password: ''
    }
  },
  created() {
    this.loaddate();
  },
  methods: {
    loaddate() {
      this.seach.account = window.sessionStorage.getItem('empId');
      this.$http.get('/queryEmpInfoById/' + this.seach.account).then(res => {
        this.page = res.data;
      });
    },
    formatDate(startTime) {
      var date = new Date(startTime);
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      return year + '-' + month + '-' + day;
    },
    formatRole(role) {
      if (role == 0) {
        return '员工'
      } else if (role == 1) {
        return '部门经理'
      } else if (role == 2) {
        return '副总经理'
      } else if (role == 3) {
        return '总经理'
      } else if (role == 4) {
        return '人事人员'
      } else if (role == 5) {
        return '财务人员'
      }
    },
    formatGender(gender) {
      if (gender == 0) {
        return '女'
      } else {
        return '男'
      }
    },
    updateInfo() {
      this.isshow = true;
      this.phone = this.page.phone;
      this.password = this.page.password;
      this.email = this.page.email;
    },
    update(){
      this.$http.post('/newEmployer/update',{
        name:this.page.name,
        empId:this.page.empId,
        account:this.page.account,
        gender:this.page.gender,
        createTime:this.page.createTime,
        role:this.page.role,
        phone:this.phone,
        password:this.password,
        email:this.email
      }).then(res => {
        if(res.data===true){
        this.$message({
          type:'success',
          message:'修改成功'
        })
        } else {
          this.$message({
            type:'error',
            message:'修改失败'
          })
        }
      })
    }
  },
}
</script>