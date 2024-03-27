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
      <tbody></tbody>
    </table>

    <div id="cart-summary">
      <div>
        <span>Subtotal:</span>
        <span>{{ formatCurrency(Subtotal) }}</span>
      </div>
      <div>
        <span>Tax (6%):</span>
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
export default {
  data() {
    return {
      cartItems: [],
    };
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
  },
};
</script>

<style>
</style>