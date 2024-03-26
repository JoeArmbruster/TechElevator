<template>
  <div class="home">
    <div id="heading-line">
      <h1>
        Products
        <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>

      <div class="search-box">
        <font-awesome-icon
          v-bind:class="{ 'view-icon': true, active: cardView }"
          v-on:click="cardView = true"
          icon="fa-solid fa-grip"
          title="View tiles"
        />
        <font-awesome-icon
          v-bind:class="{ 'view-icon': true, active: !cardView }"
          v-on:click="cardView = false"
          icon="fa-solid fa-table"
          title="View table"
        />

        <input
          type="text"
          v-model.trim="searchTerm"
          @keyup.enter="searchProducts"
          placeholder="Search..."
        />
        <button @click="searchProducts" title="Search">
          <font-awesome-icon icon="fa-solid fa-search" />
        </button>
      </div>
    </div>
    <products-as-cards v-bind:products="filteredProducts" v-if="cardView" />
    <products-as-table v-bind:products="filteredProducts" v-else />
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
import ProductsAsCards from "../components/ProductsAsCards.vue";
import ProductsAsTable from "../components/ProductsAsTable.vue";

export default {
  components: {
    LoadingSpinner,
    ProductsAsCards,
    ProductsAsTable,
  },
  data() {
    return {
      isLoading: false,
      cardView: true,
      products: [],
      searchTerm: "",
    };
  },

  computed: {
    filteredProducts() {
      const searchTerm = this.searchTerm.toLowerCase();
      return this.products.filter((product) => {
        const productName = product.name.toLowerCase();
        const productSku = product.productSku.toLowerCase();
        return (
          productName.includes(searchTerm) || productSku.includes(searchTerm)
        );
      });
    },
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },

  methods: {
    searchProducts() {
      this.filteredProducts = this.products.filter((product) => {
        const productName = product.name.toLowerCase();
        const productSku = product.productSku.toLowerCase();
        return (
          productName.includes(this.searchTerm.toLowerCase()) ||
          productSku.includes(this.searchTerm.toLowerCase())
        );
      });
    },
    getProducts() {
      this.products = [
        {
          productId: 1,
          productSku: "MUG-023",
          name: "Solar Geeks coffee mug",
          description: "Start your day off right!",
          price: 14.99,
          imageName: "Product-MUG-023.jpg",
        },
        {
          productId: 2,
          productSku: "YET-001",
          name: "Solar Geeks Yeti",
          description: "Keep cool all day long.",
          price: 21.99,
          imageName: "Product-YET-001.jpg",
        },
        {
          productId: 3,
          productSku: "ART-256",
          name: "Galactic poster",
          description: "Beautiful view of a galaxy",
          price: 9.59,
          imageName: "Product-ART-256.jpg",
        },
        {
          productId: 4,
          productSku: "TOY-978",
          name: "Toy rocket",
          description: "To infinite imagination",
          price: 39.99,
          imageName: "Product-TOY-978.jpg",
        },
        {
          productId: 5,
          productSku: "EAT-235",
          name: "Astronaut ice cream",
          description: "As cold as space",
          price: 5.79,
          imageName: "Product-EAT-215.jpg",
        },
        {
          productId: 6,
          productSku: "HAT-928",
          name: "Solar Geeks baseball cap",
          description: "Look stylish with our logo",
          price: 16.89,
          imageName: "Product-HAT-908.jpg",
        },
        {
          productId: 7,
          productSku: "LIT-612",
          name: "Intro to Astrophysics",
          description: "Learn about astrophysics",
          price: 7.99,
          imageName: "Product-LIT-612.jpg",
        },
      ];
    },
  },

  created() {
    this.getProducts();
  },
};
</script>

<style scoped>
#heading-line {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 10px;
}

h1 {
  font-size: 2.5rem;
  margin: 5px;
}

#spinner {
  color: green;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}

.search-box {
  display: flex;
  align-items: center;
}
</style>