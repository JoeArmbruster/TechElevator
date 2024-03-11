<template>
  <div id="results">
    <h2>2023</h2>
    <div id="timeOrPaceButtons">
      <button v-on:click="setToTime">See Time</button>
      <button v-on:click="setToPace">See Pace</button>
    </div>
    <table id="results-table">
      <tr>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Home</th>
        <th>{{ viewTotalTime ? "Time" : "Pace" }}</th>
      </tr>
      <tr
        class="runner-row"
        v-for="(runner, index) in $store.state.runners"
        v-bind:key="index"
      >
        <td>{{ runner.last_name }}</td>
        <td>{{ runner.first_name }}</td>
        <td>{{runner.city}}, {{runner.state}}</td>
        <td>
          {{
            viewTotalTime
              ? getRaceTime(runner.time_seconds)
              : getPace(runner.time_seconds)
          }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      raceDistance: 26.2,
      viewTotalTime: true,
    };
  },
  methods: {
    setToTime() {
      this.viewTotalTime = true;
    },
    setToPace() {
      this.viewTotalTime = false;
    },
    getRaceTime(timeInSeconds) {
      const hours = Math.floor(timeInSeconds / 3600);
      const minutes = Math.floor((timeInSeconds % 3600) / 60);
      const seconds = timeInSeconds % 60;

      return `${hours}:${minutes < 10 ? "0" : ""}${minutes}:${
        seconds < 10 ? "0" : ""
      }${seconds}`;
    },
    getPace(timeInSeconds) {
      const secondsPerMile = timeInSeconds / this.raceDistance;
      const minutes = Math.floor(secondsPerMile / 60);
      const seconds = Math.floor(secondsPerMile % 60);

      return `${minutes}:${seconds < 10 ? "0" : ""}${seconds}`;
    },
  },
};
</script>

<style scoped>
#results-table {
  margin-left: auto;
  margin-right: auto;

  background-color: white;
  width: 60%;
}

#timeOrPaceButtons {
  margin: 10px;
}
</style>
