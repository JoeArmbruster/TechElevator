<template>
  <div id="product-details" v-if="product">
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
    <img
      :src="imageSrc(product.imageName)"
      alt="Product Image"
      class="product-image"
    />
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<script>
export default {
    props: ['product'],

//   props: {
//       product: {
//           type: Object,
//           required: true
//       }
//   },

//   created() {
//     const productId = this.$route.params.id;
//     this.fetchProductDetails(productId);
//   },
  methods: {
    // fetchProductDetails(productId) {
    //   const apiURL = `/api/products/${productId}`;
    //   fetch(apiURL)
    //     .then((response) => response.json())
    //     .then((productData) => {
    //       this.product = productData;
    //     });
    // },
    formatCurrency(price) {
      return new Intl.NumberFormat("en-US", {
        currency: "USD",
        style: "currency",
      }).format(price);
    },
    addtoCart(productId) {},
    imageSrc(imageName) {
    return '/img/product_350x250.jpg';
    //   return imageName ? `/img/${imageName}` : "img/product_350x250.jpg";
    },
  },
};
</script>

<style>
#heading-line {
  display: flex;
  align-items: center;
}

#details-line {
  display: flex;
  justify-content: space-between;
}

product-image {
  max-width: 100%;
}
</style>