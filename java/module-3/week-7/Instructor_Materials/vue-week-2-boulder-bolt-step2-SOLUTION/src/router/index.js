import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegistrationView from '../views/RegistrationView.vue'
import ResultsView from '../views/ResultsView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/results',
      name: 'results',
      component: ResultsView
    },
    {
      path: '/registration',
      name: 'registration',
      component: RegistrationView
    }
  ]
})

export default router
