/*
    app.js

*/

document.addEventListener("DOMContentLoaded", function () {

    const products = productService.getProducts();
    const productCardsSection = document.getElementById("product-cards");
    const searchBox = document.getElementById("search-box");
    const messageWindow = document.getElementById("message-window");

    searchBox.addEventListener("keyup", function (event) {
        const searchTerm = event.target.value.trim().toLowerCase();

        products.forEach(product => {
            const productName = product.name.toLowerCase();
            const article = document.querySelector(`[data-id="${product.productId}"]`);

            if (productName.includes(searchTerm)) {
                article.style.display = "block";
            } else {
                article.style.display = "none";
            }
        });
    });

    products.forEach(product => {
        const article = document.createElement("article");
        article.classList.add("product-card");
        article.setAttribute("data-id", product.productId);

        const sku = document.createElement("div");
        sku.classList.add("sku");
        sku.textContent = product.productSku;

        const price = document.createElement("div");
        price.classList.add("price");
        price.textContent = `$${product.price.toFixed(2)}`;

        const productName = document.createElement("div");
        productName.classList.add("product-name", "action");
        productName.textContent = product.name;
        productName.setAttribute("data-id", product.productId);

        productName.addEventListener("click", function() {
            showMessage(product.description);
        });

        const productImage = document.createElement("div");
        productImage.classList.add("product-image");
        const img = document.createElement("img");
        img.src = product.imageName;
        img.alt = product.name;
        productImage.appendChild(img);

        const cart = document.createElement("div");
        cart.classList.add("cart");
        const cartIcon = document.createElement("i");
        cartIcon.classList.add("fa-solid", "fa-cart-plus", "icon", "action");
        cartIcon.setAttribute("title", "Add item to cart");

        cartIcon.addEventListener("click", function () {
            showMessage(`"${product.name}" has been added to the cart.`);
        });
        cart.appendChild(cartIcon);

        article.appendChild(sku);
        article.appendChild(price);
        article.appendChild(productName);
        article.appendChild(productImage);
        article.appendChild(cart);

        productCardsSection.appendChild(article);
    });

    function showMessage(message){
        messageWindow.textContent = message;
        messageWindow.style.display = "block";
    }
});