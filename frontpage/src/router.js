import Vue from 'vue'
import Router from 'vue-router'
import AddEmployer from "./views/Employer/AddEmployer.vue"
import AddApply from "./views/ApplyForVacation/AddApply.vue"
import Login from "./views/login.vue"
import Home from "./views/home.vue"
import ApplyList from "./views/ApplyForVacation/ApplyList.vue"
import ManageApply from "./views/ApplyForVacation/ManageApply.vue"
import ManageApplyX from "./views/ApplyForVacation/ManageApplyX.vue"
import EmployeDaKa from "./views/Daka/EmployeDaKa.vue"
import AllEmployeState from "./views/Employer/AllEmployeState.vue"
import AllDaKa from "./views/Daka/AllDaKa.vue"
import CheckLeft from "./views/ApplyForVacation/CheckLeft.vue"
import AllEmployer from "./views/Employer/AllEmployer.vue"
import EmployerInfo from "./views/Employer/EmployerInfo.vue"
import MyInfo from "./views/Employer/MyInfo.vue"
import AllApplyList from "./views/ApplyForVacation/AllApplyList.vue"
import AddWorkTime from "@/views/AddWorkTime";
import PersonalKaoqin from "@/views/Kaoqin/PersonalKaoqin";
import AllKaoqin from "@/views/Kaoqin/AllKaoqin";
import PersonalOverTime from "@/views/OverTime/PersonalOverTime";
import AllOverTime from "@/views/OverTime/AllOverTime";
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: '登录',
      component: Login
    }, {
      path: '/login',
      name: '登录',
      component: Login,
    },{
      path: '/home',
      name: '',
      component: Home,
    }, {
      path: '/home',
      component: Home,
      name: '管理',
      children: [
        {
          path: '/apply/addApply',
          name: '添加申请',
          component: AddApply,
        }, {
          path: '/employer/AddEmployer',
          name: '添加员工',
          component: AddEmployer,
        },  {
          path: '/apply/applyList',
          name: '请假记录',
          component: ApplyList,
        }, {
          path: '/apply/ManageApply',
          name: '审核请假',
          component: ManageApply,
        }, {
          path: '/apply/ManageApplyX',
          name: '审核3天以上请假',
          component: ManageApplyX,
        }, {
          path: '/DaKa/EmployeDaKa',
          name: '员工打卡',
          component: EmployeDaKa,
        }, {
          path: '/employer/AllEmployeState',
          name: '员工状态',
          component: AllEmployeState,
        }, {
          path: '/Daka/AllDaKa',
          name: '员工状态',
          component: AllDaKa,
        }, {
          path: '/employer/CheckLeft',
          name: '剩余假期',
          component: CheckLeft,
        }, {
          path: '/employer/AllEmployer',
          name: '查询所有人员',
          component: AllEmployer,
        }, {
          path: '/employer/EmployerInfo',
          name: '查询人员详情',
          component: EmployerInfo,
        }, {
          path: '/employer/MyInfo',
          name: '我的详情',
          component: MyInfo,
        }, {
          path: '/apply/AllApplyList',
          name: '所有请假申请',
          component: AllApplyList,
        },{
        path:'/employer/AddWorkTime',
          name:'添加工作时间',
          component:AddWorkTime
        },{
        path:'/Daka/PersonalKaoqin',
          name:'个人考勤',
          component:PersonalKaoqin
        },{
        path:'/Daka/AllKaoqin',
          name:'所有员工考勤',
          component:AllKaoqin
        },{
        path:'/OverTime/Person',
          name:'个人加班',
          component:PersonalOverTime
        },{
        path:'/OverTime/All',
          name:'员工加班',
          component:AllOverTime
        }
      ]
    }
  ]
})