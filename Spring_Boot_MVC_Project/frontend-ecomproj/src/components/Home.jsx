import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [isError, setIsError] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("http://localhost:82/api/products");
                setProducts(response.data);
                console.log(response.data);
            } catch (error) {
                console.error("Error fetching products:", error);
                setIsError(true);
            }
        };

        fetchData();
    }, []);

    if(isError){
        return(
            <h2 className="text-danger" style={{textAlign: "center", marginTop: "20px"}}>
                Error fetching products
            </h2>
        );

    }

    return (
        <div style={{ padding: '20px' }}>
            <h1>Products</h1>
            <div style={{
                display: 'grid',
                gridTemplateColumns: 'repeat(auto-fill, minmax(220px, 1fr))',
                gap: '16px',
                marginTop: '16px'
            }}>
                {products.map((product) => (
                    <div
                        key={product.id}
                        onClick={() => navigate(`/product/${product.id}`)}
                        role="link"
                        tabIndex={0}
                        onKeyDown={(event) => {
                            if (event.key === "Enter" || event.key === " ") {
                                navigate(`/product/${product.id}`);
                            }
                        }}
                        style={{
                        background: '#fff',
                        border: '1px solid #eee',
                        borderRadius: '10px',
                        padding: '14px',
                        boxShadow: '0 2px 6px rgba(0,0,0,0.06)',
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'space-between',
                        cursor: 'pointer',
                        textAlign: 'left'
                    }}>
                        <div>
                            <div style={{ color: '#1a73e8', fontSize: '12px', fontWeight: 600, textTransform: 'uppercase', marginBottom: '8px' }}>
                                {product.name}
                            </div>

                            <div style={{ fontStyle: 'italic', color: '#666', marginBottom: '6px' }}>
                                {product.brand ? `~ ${product.brand}` : ''}
                            </div>
                        </div>

                        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginTop: '8px' }}>
                            <div style={{ color: '#1a73e8', fontWeight: 700, fontSize: '1.05rem' }}>
                                {product.price != null ? `$${product.price}` : ''}
                            </div>
                            <button type="button" style={{ background: '#1a73e8', color: '#fff', border: 'none', padding: '8px 12px', borderRadius: '6px', cursor: 'pointer' }}>Add to Cart</button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Home;