import axios from "axios";

const API_BASE_URL = "http://localhost:82/api";


export const getProducts = () => {
    return axios.get(`${API_BASE_URL}/products`);
};

export const getProductById = (id) => {
    return axios.get(`${API_BASE_URL}/products/${id}`);
};

export const getProductImage = (id) => {
    return `${API_BASE_URL}/product/${id}/image`;
};

export const addProduct = (formData) => {
    return axios.post(
        `${API_BASE_URL}/product`,
        formData,
        {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }
    );
};

export const updateProduct = (id, formData) => {
    return axios.put(
        `${API_BASE_URL}/product/${id}`,
        formData,
        {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }
    );
};

export const deleteProduct = (id) => {
    return axios.delete(
        `${API_BASE_URL}/product/${id}`
    );
};