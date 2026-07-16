import React from "react";
import { useNavigate } from "react-router-dom";
import "../../assets/styles/card.css";
import noProductImage from "../../assets/images/no-product.png";
import { useCart } from "../../context/CartContext";

const ProductCard = ({ product }) => {

    const { addToCart } = useCart();
    const navigate = useNavigate();


    const imageUrl = `http://localhost:82/api/product/${product.id}/image`;

    const productImage =
        product.imageData
            ?
            imageUrl
            :
            noProductImage;

    const handleCart = (e)=>{

        e.stopPropagation();

        addToCart(product);

        navigate("/cart");
    };


    return (

        <div
            className="product-card"
            onClick={()=>navigate(`/product/${product.id}`)}
        >


            <div className="image-container">

                <img
                    src={productImage}
                    alt={product.name}

                    onError={(e)=>{
                        e.target.onerror=null;
                        e.target.src=noProductImage;
                    }}

                />

            </div>



            <div className="card-body">


                <span
                    className={
                        product.available
                            ?
                            "badge-success"
                            :
                            "badge-danger"
                    }
                >

                    {
                        product.available
                            ?
                            "In Stock"
                            :
                            "Out of Stock"
                    }

                </span>



                <h3>
                    {product.name}
                </h3>



                <p>
                    Brand:
                    <b>
                        {" "}{product.brand}
                    </b>
                </p>



                <p>
                    Category:
                    <b>
                        {" "}{product.category}
                    </b>
                </p>



                <h2>
                    ${product.price}
                </h2>



                <button
                    onClick={handleCart}
                    disabled={!product.available}
                >

                    Add To Cart

                </button>


            </div>


        </div>

    );
};


export default ProductCard;