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
              <td>{{ item.productName }}</td>
              <td>{{ formatCurrency(item.price) }}</td>
              <td>{{ formatCurrency(item.amount) }}</td>
          </tr>
      </tbody>
    </table>

    <div id="cart-summary">
      <div>
        <span>Subtotal:</span>
        <span>{{ formatCurrency(subtotal) }}</span>
      </div>
      <div>
        <span>Tax:</span>
        <span>{{ formatCurrency(tax) }}</span>
      </div>
      <div>
        <span>Total:</span>
        <span>{{ formatCurrency(total) }}</span>
      </div>
    </div>
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

  created() {
      this.$root.$on('add-to-cart', this.addToCart);
      this.products = [
          { productId: 1, name: 'Solar Geeks coffee mug', price: 14.99 },
          { productId: 2, name: 'Solar Geeks Yeti', price: 21.99 },
          { productId: 3, name: 'Galactic poster', price: 9.59 },
          { productId: 4, name: 'Toy rocket', price: 39.99 },
          { productId: 5, name: 'Astronaut ice cteam', price: 5.79 },
          { productId: 6, name: 'Solar Geeks baseball cap', price: 16.89 },
          { productId: 7, name: 'Inro to Astrophysics', price: 7.99}
      ];
  },
  computed: {
    subtotal() {
      return this.cartItems.reduce((acc, productId) => {
        return acc + this.getAmount(productId);
      }, 0);
    },
    tax() {
      return this.subtotal * 0.06; // Assuming tax rate is 6%
    },
    total() {
      return this.subtotal + this.tax;
    },
  },
  methods: {
    addToCart(productId) {
      // Add productId to cartItems array
      this.cartItems.push(productId);
    },
    getQuantity(productId) {
      // Calculate quantity for the productId in cartItems
      return this.cartItems.filter(id => id === productId).length;
    },
    getProduct(productId) {
      // Find and return the product name for the productId
      const product = this.products.find(p => p.productId === productId);
      return product ? product.name : 'Unknown Product';
    },
    getPrice(productId) {
      // Find and return the product price for the productId
      const product = this.products.find(p => p.productId === productId);
      return product ? product.price : 0;
    },
    getAmount(productId) {
      // Calculate and return the amount (price x quantity) for the productId
      return this.getPrice(productId) * this.getQuantity(productId);
    },
    formatCurrency(price) {
      // Format price as currency
      return new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'USD',
      }).format(price);
    },
  },
};
</script>

<style>
</style>