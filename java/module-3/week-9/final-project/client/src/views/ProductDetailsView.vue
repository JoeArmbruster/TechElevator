<template>
  <div id="product-details">
    <div id="heading-line">
      <h1>{{ product.name }}</h1>
      <button class="add-to-cart-button" @click="addToCart(product.productId)">
        <i class="fas fa-cart-plus"></i> Add to Cart
      </button>
    </div>
    <p>{{ product.description }}</p>
    <div id="details-line">
      <span>{{ product.productSku }}</span>
      <span>{{ formatCurrency(product.price) }}</span>
    </div>
    <img :src="imageSrc(product.imageName)" alt="Product Image" class="product-image" />
  </div>
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
#heading-line {
    display: flex;
    align-items: center;
}

#details-line{
    display: flex;
    justify-content: space-between;
}

product-image {
    max-width: 100%;
}
</style>