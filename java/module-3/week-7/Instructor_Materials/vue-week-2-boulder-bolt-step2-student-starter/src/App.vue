

<template>
<div id="race-app">
  <header>
    <div class="race-title">
      <h1>Boulder Bolt</h1>
    </div>
      <nav>
        <a href ="#">Home</a>
        <a href="#">Registration</a>
        <a href="#">Results</a>
      </nav>
  </header>
  <main>
    <p> This is where your Views should appear</p>
  </main>
  <footer>
    <p>&copy; Boulder Bolt 2024.  All rights reserved.</p>
  </footer>
</div>
</template>

<script setup>
</script>

<style scoped>

* {
  font-family: Tahoma, Geneva, Verdana, sans-serif;
  font-size: 16px;
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
  grid-area: header;
  background-color: lightblue;
  line-height: 1.5;
}

h1 {
  font-size:2rem;
  color: white;
}

main {
  grid-area: main;
  border: 1px black solid;
}

footer{
  grid-area: footer;
  background-color: lightyellow;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  text-decoration: none;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}



</style>
