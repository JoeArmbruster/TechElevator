<template>
  <loading-spinner v-if="isLoading"/>
  <div v-else class="view-container">
    <header class="view-header">
      <h1>Author Details</h1>
    </header>
    <div id="view-content">
      <div class="error" v-show="error">
        <p>Sorry! Something unexpected happened. {{error}} Please try again later.</p>
      </div>
      <author-details v-show="!error" v-bind:author="authorData" />
    </div>
  </div>
</template>

<script>
import LoadingSpinner from '../components/LoadingSpinner.vue';
import AuthorDetails from '../components/AuthorDetails.vue';
import BookService from '../services/BookService';

export default {
  components: { LoadingSpinner, AuthorDetails },
  data() {
    return {
      error: null,
      isLoading: true,
      authorId: this.$route.params.authorId,
      authorData: {}
    };
  },
  created() {
    this.fetchAuthorData();
  },
  methods: {
    fetchAuthorData(){
      const authorId = this.$route.params.authorId;
      BookService.getAuthorById(authorId)
      .then(response => {
        this.authorData = response.data;
        this.isLoading = false;
      })
      .catch(error => {
        this.error = `Could not fetch author details for id ${authorId}.`;
        console.error(this.error, error);
      });
    }
  }
}
</script>

<style>

</style>