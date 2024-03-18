import { createRouter as _createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import SingleRecipeView from '../views/SingleRecipeView.vue'
import MultipleRecipesView from '../views/MultipleRecipesView.vue'

// Create routes 
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/recipes',
    name: 'recipes',
    component: MultipleRecipesView
  },
  {
    path: '/recipe/:id',
    name: 'recipe',
    // props: true,
    component: SingleRecipeView,
  }
]

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
