!<template>
  <div id="movie-filter">
    <h2>Filter</h2>
    <form v-on:submit.prevent="filter">
      <div class="form-group">
        <label for="search">Title:</label>
        <input type="text" placeholder="Search..." v-model="titleString" id="search" />
      </div>
      <div class="form-group" v-if="allGenres.length > 0">
        <label for="genre-list">Genres:</label>
        <select id="genre-list" v-model="selectedGenreList" multiple>
          <option v-for="genre of allGenres" v-bind:key="genre.id"
              v-bind:value="genre.name">{{genre.name}}</option>
        </select>
      </div>
      <div v-else class="form-group">
      </div>
      <div class="button-group">
        <button type="submit">Filter</button>
        <button v-on:click="clear">Reset</button>
      </div>
    </form>
  </div>
</template>

<script>
import movieService from '../services/MovieService';

export default {

  data() {
    return {
      allGenres: [],
      titleString: "",
      selectedGenreList: []
    };
  },
  methods: {
    filter() {
      this.$emit("filterValueChange", {titleString: this.titleString, genreList: this.selectedGenreList});
    },
    clear() {
      this.titleString='';
      this.selectedGenreList=[];
    },
    fetchGenres() {
      movieService.getGenres()
      .then(response => {
        this.allGenres = response.data;
      })
    }
  },
  created() {
    this.fetchGenres();
  }
};
</script>

<style scoped>
#movie-filter {
  background-color:  #fdd481;
  border: 1px solid #51010F;
  display: flex;
  flex-wrap: nowrap;
  align-items: top;
  gap: 2rem;
  margin-bottom: 2rem;
  padding: 1rem 2rem;
  width: fit-content;
}

form {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  justify-content: center;
  align-items: top;
}

.form-group {
  display: flex;
  align-items: baseline;
}

label {
  margin-right: 0.5rem;
}

h2 {
  font-size: 1.2rem;
  font-weight: bold;
  text-shadow: 1px 1px #FFB41F;
}

input {
  background-color: #F9F6F0;
  border: 1px solid #51010F;
  display: inline-block;
  height: fit-content;
  margin-bottom: 1rem;
  padding: 0.25rem 0.75rem;
}

button {
  background-color: #e9e7e3;
  border: 1px solid #51010F;
  border-radius: 0.25rem;
  display: inline-block;
  height: fit-content;
  padding: 0.25rem 0.75rem;
  margin-bottom: 0.5rem;
  margin-right: 0.5rem;
  width: 100px;
}

button[type=submit]{
  background-color: #ffb41f81
}

select {
  background-color: #F9F6F0;
  border: 1px solid #51010F;
  display: inline-block;
}

option {
  padding: 0.25rem 0.5rem;
}

</style>
