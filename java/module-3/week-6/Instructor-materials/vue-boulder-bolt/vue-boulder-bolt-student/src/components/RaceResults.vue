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
        <th>Time</th>
      </tr>
    </table>
  </div>
</template>

<script>
import RunnerData from "../assets/RunnerData";

export default {
  data() {
    return {};
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
