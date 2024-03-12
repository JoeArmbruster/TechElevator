<template>
  <div class="new-book-form">
    <form @submit.prevent="addBook">
      <label for="title">Title:</label>
      <input type="text" id="title" v-model="title" class="title-input" required>
      <label for="author">Author:</label>
      <input type="text" id="author" v-model="author" class="author-input" required>
      <label for="isbn">ISBN:</label>
      <input type="text" id="isbn" v-model="isbn" class="isbn-input" required>
      <button type="submit">Add Book</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: '',
      author: '',
      isbn: ''
    };
  },
  methods: {
    addBook() {
      const newBook = {
        title: this.title,
        author: this.author,
        read: false,
        isbn: this.isbn
      };
      this.$store.commit('ADD_BOOK', newBook);
      this.title = '';
      this.author = '';
      this.isbn = '';
    }
  }
}
</script>

<style>

</style>