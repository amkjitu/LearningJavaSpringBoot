import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

const Product = () => {
    const { id } = useParams();
    const [product, setProduct] = useState(null);
    const [isError, setIsError] = useState(false);

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await axios.get(`http://localhost:82/api/products/${id}`);
                setProduct(response.data || null);
            } catch (error) {
                console.error("Error fetching product:", error);
                setIsError(true);
            }
        };

        fetchProduct();
    }, [id]);

    if (isError) {
        return (
            <h2 className="text-danger" style={{ textAlign: "center", marginTop: "20px" }}>
                Error fetching product
            </h2>
        );
    }

    if (!product) {
        return (
            <div style={{ padding: "20px" }}>
                <h2>Product not found</h2>
                <Link to="/home" style={{ color: "#1a73e8", textDecoration: "none", fontWeight: 600 }}>
                    Back to products
                </Link>
            </div>
        );
    }

    return (
        <div style={{ padding: "20px" }}>
            <div style={{
                maxWidth: "720px",
                margin: "0 auto",
                background: "#fff",
                border: "1px solid #eee",
                borderRadius: "12px",
                padding: "20px",
                boxShadow: "0 2px 6px rgba(0,0,0,0.06)"
            }}>
                <div style={{ color: "#1a73e8", fontSize: "13px", fontWeight: 700, textTransform: "uppercase", marginBottom: "10px" }}>
                    {product.category || product.name}
                </div>

                <h1 style={{ marginTop: 0, marginBottom: "10px" }}>{product.name}</h1>

                <div style={{ fontStyle: "italic", color: "#666", marginBottom: "14px" }}>
                    {product.brand ? `~ ${product.brand}` : ""}
                </div>

                <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(180px, 1fr))", gap: "12px", marginBottom: "18px" }}>
                    <Info label="Price" value={product.price != null ? `$${product.price}` : "N/A"} />
                    <Info label="Quantity" value={product.quantity ?? "N/A"} />
                    <Info label="Available" value={product.available ? "Yes" : "No"} />
                    <Info label="Release Date" value={product.releaseDate ? new Date(product.releaseDate).toLocaleDateString() : "N/A"} />
                </div>

                <div style={{ marginBottom: "18px" }}>
                    <h3 style={{ marginBottom: "8px" }}>Description</h3>
                    <p>{product.description || "No description available."}</p>
                </div>

                <div style={{ marginBottom: "18px" }}>
                    <h3 style={{ marginBottom: "8px" }}>Product Details</h3>
                    <p><strong>ID:</strong> {product.id}</p>
                    <p><strong>Category:</strong> {product.category || "N/A"}</p>
                    <p><strong>Brand:</strong> {product.brand || "N/A"}</p>
                    <p><strong>Price:</strong> {product.price != null ? `$${product.price}` : "N/A"}</p>
                    <p><strong>Quantity:</strong> {product.quantity ?? "N/A"}</p>
                    <p><strong>Available:</strong> {product.available ? "Yes" : "No"}</p>
                    <p><strong>Release Date:</strong> {product.releaseDate || "N/A"}</p>
                </div>

                <Link to="/home" style={{ color: "#1a73e8", textDecoration: "none", fontWeight: 600 }}>
                    Back to products
                </Link>
            </div>
        </div>
    );
};

const Info = ({ label, value }) => (
    <div style={{ border: "1px solid #eee", borderRadius: "8px", padding: "12px" }}>
        <div style={{ color: "#666", fontSize: "12px", textTransform: "uppercase", marginBottom: "6px" }}>{label}</div>
        <div style={{ fontWeight: 700 }}>{value}</div>
    </div>
);

export default Product;