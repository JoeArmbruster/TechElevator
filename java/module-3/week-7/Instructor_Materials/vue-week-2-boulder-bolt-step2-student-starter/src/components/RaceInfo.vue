<template>
  <section id="info">
    <img src="../assets/runners_fun.png" />
    <div id="race-text">
      <h3>Race Date: {{ this.raceDateString }}</h3>
      <h3>Race Details</h3>
      <p class="race-details">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Etiam dignissim diam
        quis enim lobortis scelerisque fermentum. Sit amet mattis vulputate enim
        nulla. Quis ipsum suspendisse ultrices gravida dictum fusce.
        Pellentesque id nibh tortor id aliquet lectus proin. Sit amet mauris
        commodo quis imperdiet massa tincidunt nunc pulvinar. Posuere
        sollicitudin aliquam ultrices sagittis orci a scelerisque. Diam
        sollicitudin tempor id eu. Aliquet bibendum enim facilisis gravida neque
        convallis a cras semper. Aliquam faucibus purus in massa tempor.
      </p>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      raceDateString: "04/16/2024",
    };
  },
  computed: {
    getDaysTilRace() {
      const raceDate = new Date(this.raceDateString);
      const today = new Date();

      const differenceInMilliseconds = raceDate.getTime() - today.getTime();
      return Math.floor(differenceInMilliseconds / (1000 * 60 * 60 * 24));
    },
  },
};
</script>

<style>
#info {
  display: flex;
}

img {
  max-width: 40%;
}

#race-text{
    padding: 15px;
}

.race-details {
    text-align: left;
    padding: 0 10%;
}
</style>
