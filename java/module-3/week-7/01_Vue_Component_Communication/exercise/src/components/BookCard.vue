<template>
  <div class="card" v-bind:class="{ read: book.read }">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <button @click="toggleRead" :class="{ 'mark-read': !book.read, 'mark-unread': book.read }">
      {{ book.read ? 'Mark Unread' : 'Mark Read' }}
    </button>
    <!-- <div class="button-container" v-if="! enableAdd">
      <button class="mark-read" v-on:click.prevent="setRead(true)" v-if=" ! book.read">Mark Read</button>
      <button class="mark-unread" v-on:click.prevent="setRead(false)" v-if="book.read">Mark Unread</button>
    </div>
    <button v-if="enableAdd" v-on:click.prevent="addToReadingList(book)">Add to Reading List</button> -->
  </div>
</template>

<script>
export default {
  props: {
    book: Object,
    enableAdd: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    toggleRead() {
      this.$store.commit('TOGGLE_READ_STATUS', this.book);
    },
    addToReadingList(book) {
      let addedBook = Object.assign({ read: false }, book);
      delete addedBook.bestSeller;
      delete addedBook.newRelease;
      this.$store.commit('SAVE_BOOK', addedBook);
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
</style>
