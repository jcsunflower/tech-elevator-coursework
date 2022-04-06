import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsList from '../components/ProductsList'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
