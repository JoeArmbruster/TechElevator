<template>
  <div id="cart-app">
    <header>
      <img src="/img/logo_400x70.png" alt="Company Logo" class="logo" />
    </header>
    <nav>
      <ul class="nav-links">
        <li><router-link to="/products" class="nav-link">Home</router-link></li>
        <li><router-link to="/cart" class="nav-link">Cart</router-link></li>
        <li v-if="$store.state.token">
          <router-link v-bind:to="{ name: 'logout' }" class="logout-link">Logout</router-link></li>
        <li v-else>
          <router-link v-bind:to="{ name: 'login' }" class="login-link">Login</router-link></li>
      </ul>
    </nav>
    <main>
      <router-view />
    </main>
    <footer>&copy; 2024. All rights reserved.</footer>
  </div>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
  },
};
</script>

<style scoped>
header {
  border-bottom: 1px solid;
}

.logo{
  display: block;
  margin: 0 auto;
}

nav {
  text-align: right;
  border-bottom: 1px solid;

}

.nav-links {
  display: flex;
  list-style: none;
  align-items: center;
  padding: 0;
}

.nav-links li {
  margin-right: 1rem;
}

.nav-links li:last-child {
  margin-right: 1rem;
  margin-left: auto;
}

.nav-link {
  text-decoration: none;
}

.logout-link,
.login-link {
  text-decoration: none;
}

footer {
  border-top: 1px solid;
  width: 100%;
  position: fixed;
  bottom: 0;
}
</style>
