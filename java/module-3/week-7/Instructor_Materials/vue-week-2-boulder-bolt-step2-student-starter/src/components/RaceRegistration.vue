<template>
    <section id="registration">
      
      <form id="registration-form" v-if="showRegistrationForm">
        <h2>Register</h2>
         <p> {{ this.getDaysTilRace}} days remain! </p>
        <label for="fname">First name:</label>
        <input type="text" id="fname" name="fname" /><br /><br />
        <label for="lname">Last name:</label>
        <input type="text" id="lname" name="lname" /><br /><br />
        <label for="lname">Estimated Time:</label>
        <input type="text" id="estimated-time" name="estimated-time" /><br /><br />
        <label for="city">City:</label>
        <input type="text" id="city" name="city" /><br /><br />
        <label for="state">State:</label>
        <input type="text" id="state" name="state" /><br /><br />
        <input type="submit" value="Submit" />
      </form>
    </section>
</template>

<script>
export default {
    data() {
        return {
            showRegistrationForm: true,
            raceDateString: "04/16/2024",
        }
    },
    computed: {
        getDaysTilRace() {
            const raceDate = new Date (this.raceDateString);
            const today = new Date();

            const differenceInMilliseconds = raceDate.getTime() - today.getTime();
            return Math.floor (differenceInMilliseconds / (1000 * 60 * 60 *24));
        }
    },
};
</script>

<style scoped>
#registration {
  display: flex;
  justify-content: center;
  align-items: center;
  

  background-color: aqua;
    padding: 10px;
}

#registration-form {
    min-width: 350px;
}

img {
  max-width: 80%;
  border-radius: 8px;
}

.title-btn {
  display: inline-block;
  padding: 10px 20px;
  margin-right: 8px;
  text-align: center;
  text-decoration: none;
  color: #ffffff;
  background-color: #4dee0e;
  border-radius: 6px;
  border: 0;
  outline: none;
}
</style>
