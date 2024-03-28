import axios from "axios";


export default {
    get(id) {
        return axios.get(`/products/${id}`);
    },
    getProducts(){
        return axios.get('/products');
    },
    // searchProducts(searchTerm){
    //     const url = `/products?name=${searchTerm}`;
    //     return axios.get(url);
    // }
};