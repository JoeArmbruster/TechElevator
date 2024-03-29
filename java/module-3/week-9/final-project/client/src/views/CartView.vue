<template>
  <div id="cart-view">
    <h1>Shopping Cart</h1>
    <table id="cart-table">
      <thead>
        <tr>
          <th>Qty</th>
          <th>Product</th>
          <th>Price</th>
          <th>Amount</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in cart.items" v-bind:key="item.cartItemId">
        <td>{{ item.quantity }}</td>
        <td>{{ item.product.name }}</td>
        <td>{{ item.product.price }}</td>
        <td>{{ item.quantity * item.product.price }}</td>
        </tr>
        <tr class="underline-row">
            <td colspan="5"></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cart: {},
    };
  },
  methods: {
    getCart() {
      this.cart = {
        tax: 8.74,
        items: [
          {
            cartItemId: 1,
            userId: 1,
            productId: 2,
            product: {
              productId: 2,
              productSku: "YET-001",
              name: "Solar Geeks Yeti",
              description: "Keep cool all day long.",
              price: 21.99,
              imageName: "Product-YET-001.jpg",
            },
            quantity: 3,
          },
          {
            cartItemId: 2,
            userId: 1,
            productId: 4,
            product: {
              productId: 4,
              productSku: "TOY-978",
              name: "Toy rocket",
              description: "To infinite imagination",
              price: 39.99,
              imageName: "Product-TOY-978.jpg",
            },
            quantity: 1,
          },
          {
            cartItemId: 3,
            userId: 1,
            productId: 1,
            product: {
              productId: 1,
              productSku: "MUG-023",
              name: "Solar Geeks coffee mug",
              description: "Start your day off right!",
              price: 14.99,
              imageName: "Product-MUG-023.jpg",
            },
            quantity: 2,
          },
          {
            cartItemId: 4,
            userId: 1,
            productId: 7,
            product: {
              productId: 7,
              productSku: "LIT-612",
              name: "Intro to Astrophysics",
              description: "Learn about astrophysics",
              price: 7.99,
              imageName: "Product-LIT-612.jpg",
            },
            quantity: 2,
          },
        ],
        itemSubtotal: 151.92,
        total: 160.66,
      };
    },
  },
  created() {
    this.getCart();
  },
};
</script>

<style>
#cart-table .underline-row {
    border-bottom: 1px solid black;
}
</style>
 







