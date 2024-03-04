<template>
  <div id="race-app">
    <header>
      <h1>Boulder Bolt</h1>
    </header>
    <section id="register">
      <race-registration-vue/>
    </section>
    <section id="results">
      <race-results-vue/>
    </section>

  </div>
</template>

<script>
import RaceRegistrationVue from "./components/RaceRegistration.vue"
import RaceResultsVue from './components/RaceResults.vue'

export default {
  components: {
    RaceRegistrationVue,
    RaceResultsVue
  }
}

</script>


<style>

* {
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

#race-app {
  background-color: lightgray;
  text-align: center;
  padding: 10px 10%;
}

</style>
