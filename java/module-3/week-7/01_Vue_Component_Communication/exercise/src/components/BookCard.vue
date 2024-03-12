<template>
  <div :class="{ 'card': true, 'read': book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img class="book-image" :src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" alt="Book Cover">
    <button @click="toggleRead" :class="{ 'mark-read': !book.read, 'mark-unread': book.read }">
      {{ book.read ? 'Mark Unread' : 'Mark Read' }}
    </button>
  </div>
</template>

<script>
export default {
  props: {
    book: {
      type: Object,
      required: true
    }
  },
  methods: {
    toggleRead() {
      this.$store.commit('TOGGLE_READ_STATUS', this.book);
    }
  }
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read,
.mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>