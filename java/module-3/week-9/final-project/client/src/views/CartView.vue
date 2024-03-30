<template>
  <div id="cart-view">
    <div class="header-container">
      <h1>Shopping Cart</h1>
      <button @click="clearCart" class="clear-cart-button">
        🗑️ Clear Cart
      </button>
    </div>
    <table id="cart-table">
      <thead>
        <tr>
          <th class="center">Qty</th>
          <th class="left">Product</th>
          <th class="right">Price</th>
          <th class="right">Amount</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in cart.items" v-bind:key="item.cartItemId">
          <td class="center">{{ item.quantity }}</td>
          <td class="left">
            <router-link
              :to="{
                name: 'productDetails',
                params: { id: item.product.productId },
              }"
              >{{ item.product.name }}</router-link
            >
          </td>
          <td class="center">${{ item.product.price }}</td>
          <td class="center">${{ item.quantity * item.product.price }}</td>
          <td class>
            <button @click="deleteItem(item)" class="delete-btn">X</button>
          </td>
        </tr>
      </tbody>
    </table>

    <table id="cart-summary-table">
      <tbody>
        <tr>
          <td class="title-column">Item subtotal:</td>
          <td class="value-column">${{ cart.itemSubtotal }}</td>
        </tr>
        <tr>
          <td class="title-column">Tax:</td>
          <td class="value-column">${{ cart.tax }}</td>
        </tr>
        <tr>
          <td class="title-column">Total:</td>
          <td class="value-column">${{ cart.total }}</td>
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
    deleteItem(item) {
      const index = this.cart.items.findIndex(
        (i) => i.cartItemId === item.cartItemId
      );
      this.cart.items.splice(index, 1);
      this.cart.itemSubtotal = this.calculateSubtotal();
      this.cart.tax = this.calculateTax();
      this.cart.total =
        parseFloat(this.cart.itemSubtotal) + parseFloat(this.cart.tax);
    },
    calculateSubtotal() {
      return this.cart.items.reduce((acc, item) => {
        return acc + item.quantity * item.product.price;
      }, 0);
    },
    clearCart() {
      this.cart.items = [];
      this.cart.itemSubtotal = 0;
      this.cart.tax = 0;
      this.cart.total = 0;
    },
    calculateTax() {
      return (0.06 * this.cart.itemSubtotal).toFixed(2);
    },
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
    this.cart.tax = this.calculateTax();
  },
};
</script>

<style>
#cart-table {
  border-bottom: 1px solid;
}

th,
td {
  padding: 5px 40px;
}

th {
  text-align: center;
  font-size: 25px;
}

td.center {
  text-align: center;
}

td.left {
  text-align: left;
}

td.right {
  text-align: right;
}

#cart-summary-table {
  text-align: right;
  margin-left: 180px;
}

.value-column {
  padding-left: 210px;
}

.delete-btn {
  color: red;
  background: none;
  border: none;
  cursor: pointer;
}

.header-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.clear-cart-button {
  border-radius: 7px;
  font-size: 1.3rem;
  margin-right: 10px;
}

</style>
 







