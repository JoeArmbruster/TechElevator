<template>
  <section id="product-table">
    <table>
      <thead>
        <tr>
          <th class="center">SKU</th>
          <th class="left">Product</th>
          <th class="right">Price</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.productId">
          <td class="center">{{ product.productSku }}</td>
          <td class="left">
            <router-link :to="`/products/${product.productId}`">{{
              product.name
            }}</router-link>
          </td>
          <td class="right">{{ formatCurrency(product.price) }}</td>

          <td class="button-col">
            <button @click="addToCart(product.productId)">
              <font-awesome-icon icon="fa-solid fa-cart-plus" />
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </section>
</template>

<script>
export default {
  props: ["products"],

  methods: {
    formatCurrency(price) {
      return new Intl.NumberFormat("en-US", {
        currency: "USD",
        style: "currency",
      }).format(price);
    },
    addtoCart(productId) {},
  },
};
</script>

<style scoped>
#product-table {
  margin-top: 20px;
}

table {
  width: auto;
}

th,
td {
  padding: 5px 50px;
}

th {
  text-align: center;
  font-size: 25px;
}

td {
  vertical-align: center;
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

td:last-child {
  text-align: center;
}

.button-col button {
  margin-left: -50px;
}
</style>