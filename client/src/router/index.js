import Vue from 'vue'
import Router from 'vue-router';
import personnel from '../components/Personnel';
import disease from '../components/Disease'
import examResult from '../components/ExamResult'
import infectionExaminee from '../components/infectionExaminee'
Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: personnel
        },
        {
            path: '/personnel',
            component: personnel
        },
        {
            path: '/disease',
            component: disease
        },
        {
            path:'/examResult',
            component: examResult
        },
        {
            path:'/infection',
            component: infectionExaminee
        }
    ]
});
