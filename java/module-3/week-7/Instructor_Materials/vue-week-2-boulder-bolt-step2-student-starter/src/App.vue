<script setup>
</script>

<template>
<div id="race-app">
  <header>
    <div class="race-title">
      <h1>Boulder Bolt</h1>
    </div>
      <nav>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'registration' }">Registration</router-link>
        <router-link v-bind:to="{ name: 'results' }">Results</router-link>
      </nav>
  </header>
  
  <RouterView />
  <footer>
    <p>&copy; Boulder Bolt 2024.  All rights reserved.</p>
  </footer>
</div>
</template>

<style scoped>

* {
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

#race-app {
  height: 100vh;
  display: grid;
  grid-template-areas: 
  "header"
  "main"
  "footer";
  grid-template-rows: 160px 1fr 50px;
  background-color: lightgray;
  text-align: center;
  padding: 10px 10%;
}


header {
  background-color: lightblue;
  line-height: 1.5;
}

footer{
  background-color: lightyellow;
  font-size: 0.8em;
}


nav {
  width: 100%;
  text-align: center;
  margin-top: 2rem;
}

nav a {
  display: inline-block;
  text-decoration: none;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

.router-link-exact-active {
  font-weight: 800;
}








</style>
