<template>
  <div id="register">
    <form v-on:submit.prevent="register" class="register-form">
      <h1>Create Account</h1>
      <div class="form-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          placeholder="Username"
          v-model.trim="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-group">
        <label for="name">Name</label>
        <input
          type="text"
          id="name"
          placeholder="Name"
          v-model.trim="user.name"
          required
        />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
          type="password"
          id="password"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <div class="form-group">
        <label for="confirmPassword">Confirm password</label>
        <input
          type="password"
          id="confirmPassword"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <div class="form-group">
        <label for="address">Address</label>
        <input
          type="text"
          id="address"
          placeholder="Address"
          v-model.trim="user.address"
        />
      </div>
      <div class="form-row">
        <div class="form-group">
          <label for="city">City</label>
          <input type="text" id="city" placeholder="City" v-model.trim="user.city" />
        </div>
        <div class="form-group">
          <label for="state">State</label>
          <input
            type="text"
            id="state"
            placeholder="State"
            v-model.trim="user.stateCode"
            maxlength="2"
            required
          />
        </div>
        <div class="form-group">
          <label for="zip">ZIP</label>
          <input
            type="number"
            id="zip"
            placeholder="ZIP"
            v-model.number="user.zip"
            required
            minlength="5"
            maxlength="5"
          />
        </div>
      </div>
      <button type="submit" class="submit-btn">Create Account</button>
    </form>
    <p class="login-link">Have an account? <router-link to="/login">Sign in!</router-link></p>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        name: "",
        password: "",
        confirmPassword: "",
        address: "",
        city: "",
        stateCode: "",
        zip: "",
        role: "user",
      },
    };
  },
  methods: {
    error(msg) {
      alert(msg);
    },
    success(msg) {
      alert(msg);
    },
    register() {
      if (this.user.password !== this.user.confirmPassword) {
        this.error("Password & Confirm Password do not match");
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status === 201) {
              this.success("Thank you for registering, please sign in.");
              this.$router.push({ path: "/login" });
            }
          })
          .catch((error) => {
            const response = error.response;
            if (!response) {
              this.error(error);
            } else if (response.status === 400) {
              if (response.data.errors) {
                // Show the validation errors
                let msg = "Validation error: ";
                for (let err of response.data.errors) {
                  msg += `'${err.field}':${err.defaultMessage}. `;
                }
                this.error(msg);
              } else {
                this.error(response.data.message);
              }
            } else {
              this.error(response.data.message);
            }
          });
      }
    },
  },
};
</script>

<style scoped>
#register {
  max-width: 400px;
  margin: 0 auto;
}

.register-form {
  border: 1px solid #ccc;
  padding: 20px;
  border-radius: 5px;
  background-color: #f9f9f9;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
}

.form-group input[type="text"],
.form-group input[type="password"],
.form-group input[type="number"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-row {
  display: flex;
  justify-content: space-between;
}

.form-row .form-group {
  flex-basis: calc(33.333% - 10px);
}

.submit-btn {
  background-color: #4caf50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.login-link {
  margin-top: 20px;
  text-align: center;
}

.login-link a {
  text-decoration: none;
  color: #4caf50;
}

.login-link a:hover {
  text-decoration: underline;
}
</style>
