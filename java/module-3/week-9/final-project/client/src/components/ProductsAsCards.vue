<template>
  <section id="product-cards">
    <div
      class="product-card"
      v-for="product in products"
      v-bind:key="product.productId">
      <router-link :to="`/products/${product.productId}`">
      <div class="product-header">
      <div class="product-sku">{{ product.productSku }}</div>
      <div class="product-price">{{ formatCurrency(product.price) }}</div>
      </div>
        <div class="product-name">{{ product.name }}</div>
        <img src="/img/product_350x250.jpg" alt="Product Image" class="product-image" />
      <button @click="addToCart(product.productId)" class="add-to-cart-btn"><font-awesome-icon icon="fa-solid fa-cart-plus" /></button>
      </router-link>
      </div>
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
#product-cards {
    display: flex;
    flex-wrap: wrap;
}

.product-card {
    width: 359px;
    height: auto;
    border: 1px solid;
    background-color: lightblue;
    margin: 20px;
    padding: 10px;
}

.product-header {
    display: flex;
    justify-content: space-between;
    margin-bottom: 5px;
}

.product-sku,
.product-price {
    font-size: 24px;
    font-weight: bold;
}

.product-name{
    font-size: 18px;
    margin-bottom: 10px;
}

.product-image{
    width: 100%;
    height: auto;
    border-radius: 25px;
    opacity: 0.5;
    margin-bottom: 10px;
}

.add-to-cart-btn {
    float: right;
}

</style>