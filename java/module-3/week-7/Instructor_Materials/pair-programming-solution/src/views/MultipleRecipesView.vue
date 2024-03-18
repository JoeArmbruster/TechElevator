<template>
  <div id="recipes-view">
    <h1 id="recipes-title">Recipes</h1>
    <recipe-cards v-bind:recipes="recipeData" />
  </div>
</template>

<script>
import RecipeCards from '../components/RecipeCards.vue';
import recipeService from '../services/RecipeService';

export default {
  components: {
    RecipeCards,
  },
  computed: {
    recipeData() {
      // Get the search term from the query string
      const searchTerm = this.$route.query.searchTerm;
      // If searching, filter recipes
      if (searchTerm) {
        return recipeService.searchRecipes(searchTerm); 
      } else {
        return recipeService.getRecipes();
      }
    }
  }
};
</script>

<style scoped>
#recipes-title {
  text-align: center;
}
</style>