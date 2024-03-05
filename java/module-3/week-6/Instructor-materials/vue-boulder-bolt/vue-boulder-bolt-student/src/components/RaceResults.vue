<template>
  <div id="results">
    <h2>2023 Results</h2>
    <div id="timeOrPaceButtons">
      <button>See Time</button>
      <button>See Pace</button>
    </div>
    <table id="results-table">
      <tr>
        <th>Last Name</th>
        <th>First Name</th>
        <th>{{viewTotalTime ? 'Time' : 'Pace'}}</th>
      </tr>
      <tr
        class="runner-row"
        v-for="(runner,index) in this.runners"
        v-bind:key="index"
        >
        <td>{{ runner.last_name}}</td>
        <td>{{ runner.first_name}}</td>
        <td>{{ viewTotalTime ? getRaceTime (runner.time_seconds) : getPace(runner.time_seconds)}}</td>
    </table>
  </div>
</template>

<script>
import RunnerData from "../assets/RunnerData";

export default {
  data() {
    return {
      runners: RunnerData.getRunnerData(),
      raceDistance: 26.2,
      viewTotalTime: true
    };
  },
  methods: {
    getRaceTime(timeInSeconds) {
      const hours = Math.floor(timeInSeconds / 3600);
      const minutes = Math.floor((timeInSeconds % 3600) / 60);
      const seconds = timeInSeconds % 60;

      return `${hours}:${minutes < 10 ? "0" : ""}${minutes}:${
        seconds < 10 ? "0" : ""
      }${seconds}`;
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
