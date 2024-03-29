<template>
  <div id="product-details" v-if="product">
    <div id="heading-line">
      <h1>{{ product.name }}</h1>
      <button class="add-to-cart-button" @click="addToCart(product.productId)">
        <font-awesome-icon icon="fa-solid fa-cart-plus" /> Add to Cart
      </button>
    </div>
    <div class="product-description">{{ product.description }}</div>
    <span class="product-sku">{{ product.productSku }}</span>
    <span class="product-price">{{ formatCurrency(product.price) }}</span>
    <div class="product-image">
      <img
        src="/img/product_350x250.jpg"
        alt="Product Image"
        class="product-image"
      />
    </div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<script>
import productService from "../services/ProductService";

export default {
  data() {
    return {
      product: null,
    };
  },

  created() {
    const productId = this.$route.params.id;
    this.fetchProductDetails(productId);
  },

  methods: {
    fetchProductDetails(productId) {
      productService.get(productId).then((response) => {
        this.product = response.data;
      });
    },
    formatCurrency(price) {
      return new Intl.NumberFormat("en-US", {
        currency: "USD",
        style: "currency",
      }).format(price);
    },
    // addtoCart(productId) {
    //     this.$emit('add-to-cart', productId)
    // }
    addToCart(){
        
    },
  },
};
</script>

<style>
#product-details {
    margin-left: 10px;
}

#heading-line {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.product-name {
  flex-grow: 1;
}

h1 {
  font-size: 2.5rem;
  margin: 5px;
}

.product-sku,
.product-price {
  font-size: 1.2 rem;
  font-weight: normal;
}

.product-sku {
  margin-right: 15px;
}

.product-image {
  width: auto;
  height: auto;
  margin-top: 10px;
}

.add-to-cart-button {
  border-radius: 7px;
  font-size: 1.3rem;
  margin-right: 10px;
}

.product-description {
  font-size: 2rem;
  margin-bottom: 10px;
}
</style>