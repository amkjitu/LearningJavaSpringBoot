import React, { useEffect, useState } from "react";
import { getProducts } from "../services/productService";
import ProductCard from "../components/product/ProductCard";
import "../assets/styles/home.css";


const Home = () => {

    const [products, setProducts] = useState([]);
    const [isError, setIsError] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getProducts();
                setProducts(response.data);
            } catch(error) {
                console.error("Error fetching products:", error);
                setIsError(true);
            }
        };
        fetchData();
    }, []);


    if(isError){
        return (
            <h2 style={{
                textAlign:"center",
                marginTop:"50px"
            }}>
                Error fetching products
            </h2>
        );
    }

    return (
        <div className="home-container">
            <h1>
                Products
            </h1>
            <div className="product-grid">
                {
                    products.map(product => (
                        <ProductCard
                            key={product.id}
                            product={product}
                        />
                    ))
                }
            </div>
        </div>
    );
};

export default Home;