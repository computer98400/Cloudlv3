
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderingManager from "./components/listers/OrderingCards"
import OrderingDetail from "./components/listers/OrderingDetail"

import DeliveringManager from "./components/listers/DeliveringCards"
import DeliveringDetail from "./components/listers/DeliveringDetail"

import StackingManager from "./components/listers/StackingCards"
import StackingDetail from "./components/listers/StackingDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderings',
                name: 'OrderingManager',
                component: OrderingManager
            },
            {
                path: '/orderings/:id',
                name: 'OrderingDetail',
                component: OrderingDetail
            },

            {
                path: '/deliverings',
                name: 'DeliveringManager',
                component: DeliveringManager
            },
            {
                path: '/deliverings/:id',
                name: 'DeliveringDetail',
                component: DeliveringDetail
            },

            {
                path: '/stackings',
                name: 'StackingManager',
                component: StackingManager
            },
            {
                path: '/stackings/:id',
                name: 'StackingDetail',
                component: StackingDetail
            },




    ]
})
