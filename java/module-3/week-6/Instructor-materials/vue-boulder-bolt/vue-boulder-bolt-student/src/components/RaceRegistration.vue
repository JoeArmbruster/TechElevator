<template>
  <div id="registration">
    <section id="info-2024">
      <img src="../assets/runners_fun.png" />
    </section>
    <section id="registration">
      <form id="registration-form">
        <h2>Register</h2>
         <p> 999 days remain! </p>
        <label for="fname">First name:</label>
        <input type="text" id="fname" name="fname" /><br /><br />
        <label for="lname">Last name:</label>
        <input type="text" id="lname" name="lname" /><br /><br />
        <label for="lname">Estimated Time:</label>
        <input type="text" id="estimated-time" name="estimated-time" /><br /><br />
        <input type="submit" value="Submit" />
      </form>
    </section>
  </div>
</template>

<script>
export default {
    data() {
        return {
            raceDateString: "04/16/2024",
        }
    },
    computed: {
        getDaysTilRace() {
          const raceDate = new Date (this.raceDateString);
          const today = new Date();
          
          // add your code here . . .
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
