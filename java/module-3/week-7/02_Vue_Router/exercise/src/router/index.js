import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import MyBooksView from '../views/MyBooksView.vue';
import NewBookView from '../views/NewBookView.vue';
import BookDetails from '../components/BookDetails.vue';

const routes = [
  {
    path: '/',
    component: HomeView
  },
  {
    path: '/myBooks',
    component: MyBooksView
  },
  {
    path: '/addBook',
    component: NewBookView
  },
  {
    path: '/book/:isbn',
    component: BookDetails,
    props: true
  }

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
