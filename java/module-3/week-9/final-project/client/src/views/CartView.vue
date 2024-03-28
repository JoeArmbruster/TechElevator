<template>
  <div id="cart-view">
    <h1>Shopping Cart</h1>

    <table>
      <thead>
        <tr>
          <th>Quantity</th>
          <th>Product</th>
          <th>Price</th>
          <th>Amount</th>
        </tr>
      </thead>
      <tbody>
          <tr v-for="item in cartItems" :key="item.productId">
              <td>{{ item.quantity }}</td>
              <td>{{ item.name }}</td>
              <td>{{ formatCurrency(item.price) }}</td>
              <td>{{ formatCurrency(item.quantity * item.price) }}</td>
          </tr>
      </tbody>
    </table>

    <!-- <div id="cart-summary">
      <div>
        <span>Subtotal:</span>
        <span>{{ formatCurrency(Subtotal) }}</span>
      </div>
      <div>
        <span>Tax:</span>
        <span>{{ formatCurrency(tax) }}</span>
      </div>
      <div>
        <span>Total:</span>
        <span>{{ formatCurrency(total) }}</span>
      </div>
    </div> -->
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      cartItems: [],
    };
  },
//   props: {
//       cartItems: {
//           type: Array,
//           default: () => [],
//       },
//   },
  created() {
      this.fetchCartItems();
  },
  computed: {
    subtotal() {
      return this.cartItems.reduce(
        (acc, item) => acc + item.quantity * item.price,
        0
      );
    },
    tax() {
      return this.subtotal * 0.06;
    },
    total() {
      return this.subtotal + this.tax;
    },
  },
  methods: {
    formatCurrency(amount) {
      return amount.toFixed(2);
    },
    fetchCartItems() {
        axios.get('/api/cart')
        .then(response => {
            this.cartItems = response.data;
        })
    }
  },
};
</script>

<style>
</style>