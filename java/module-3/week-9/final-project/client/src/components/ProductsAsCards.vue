<template>
  <section id="product-cards">
    <div
      class="product-card"
      v-for="product in products"
      v-bind:key="product.productId">
      {{ product.name }}
      {{ product.productSku }}
      </div>
  </section>
</template>

<script>
export default {
  props: ["products"],
};
</script>

<style>
#product-cards {
    display: flex;
    flex-wrap: wrap;
}

.product-card {
    width: 400px;
    height: 400px;
    border: 1px solid;
    background-color: lightgreen;
}

</style>