import React from "react";
import ProductForm from "../components/product/ProductForm";
import { useParams } from "react-router-dom";

const AddProduct = () => {

    const { id } = useParams();

    return (
        <ProductForm
            productId={id}
        />
    );
};

export default AddProduct;