<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link>
      <router-link to="/myBooks">My Books</router-link>
    </nav>
    <h2>{{ book.title }}</h2>
    <h3>{{ book.author }}</h3>
    <img :src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-L.jpg'" alt="Book Cover" />
    <p>Number of Pages: {{ book.numPages }}</p>
    <a :href="book.moreInfoLink" target="_blank">More Information</a>
    <button @click="markAsRead">{{ book.read ? 'Mark as Unread' : 'Mark as Read' }}</button>
  </div>
</template>

<script>
export default {
  props: {
    book: Object    
  },
  methods: {
    markAsRead() {
      this.$store.commit('SET_READ_STATUS', { book: this.book, value: !this.book.read });
    }
  }
}
</script>

<style>
.separator {
  margin: 0 5px;
}
</style>