<template>
  <section id="product-table">
    <table>
        <thead>
            <tr>
                <th>SKU</th>
                <th>Product></th>
                <th>Price</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="product in products" :key="product.productId">
                <td>{{ product.productSku }}</td>
                <td>{{ product.name }}</td>
                <td>{{ formatCurrency(product.price) }}</td>
                <td><button @click="addToCart(product.productId)">Add to cart</button></td>
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
          return new Intl.NumberFormat('en-US', {
              currency: 'USD',
              style: "currency"
          }).format(price);
      },
      addtoCart(productId){
          
      }
  }
};
</script>

<style>
</style>