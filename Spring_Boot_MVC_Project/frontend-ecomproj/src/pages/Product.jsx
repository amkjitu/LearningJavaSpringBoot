import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getProductById, getProductImage, deleteProduct } from "../services/productService";
import "../assets/styles/product.css";
import toast from "react-hot-toast";

const Product = () => {

    const { id } = useParams();
    const navigate = useNavigate();
    const [product, setProduct] = useState(null);
    const [error, setError] = useState(false);

    const handleDelete = async () => {
        const confirmDelete = window.confirm(
            "Are you sure you want to delete this product?"
        );
        if(!confirmDelete){
            return;
        }
        try {
            await deleteProduct(product.id);
            toast.success("Product deleted successfully");
            navigate("/");
        }
        catch(error){
            console.error(error);
            toast.error(
                "Failed to delete product"
            );
        }
    };

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await getProductById(id);
                setProduct(response.data);
            } catch(error) {
                console.error(error);
                setError(true);
            }
        };

        fetchProduct();
    }, [id]);

    if(error){
        return (
            <h2 className="error-message">
                Product not found
            </h2>
        );
    }

    if(!product){
        return (
            <h2 className="loading-message">
                Loading...
            </h2>

        );
    }

    return (
        <div className="product-details-container">
            <div className="product-image-section">
                <img
                    src={
                        product.imageData
                            ? getProductImage(product.id)
                            : "/no-product.png"
                    }
                    alt={product.name}
                    onError={(e)=>{
                        e.target.src="/no-product.png";
                    }}
                />
            </div>

            <div className="product-info-section">
                <h1>
                    {product.name}
                </h1>

                <span className={product.available ? "badge-success" : "badge-danger"}>
                    {
                        product.available ? "In Stock" : "Out Of Stock"
                    }
                </span>

                <div className="product-info">
                    <p>
                        <b>Brand:</b>
                        {" "}
                        {product.brand}
                    </p>

                    <p>
                        <b>Category:</b>
                        {" "}
                        {product.category}
                    </p>

                    <p>
                        <b>Price:</b>
                        <span className="price">
                            ${product.price}
                        </span>
                    </p>

                    <p>
                        <b>Quantity:</b>
                        {" "}
                        {product.quantity}
                    </p>

                    <p>
                        <b>Release Date:</b>
                        {" "}
                        {product.releaseDate}
                    </p>

                </div>

                <div className="description">

                    <h3>Description</h3>
                    <p>{product.description}</p>
                </div>

                <div className="action-buttons">

                    <button
                        className="edit-btn"
                        onClick={()=>navigate(`/product/edit/${product.id}`)}
                    >
                        Edit Product
                    </button>

                    <button className="delete-btn" onClick={handleDelete}>
                        Delete Product
                    </button>

                </div>

            </div>
        </div>
    );
};

export default Product;