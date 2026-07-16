import React from "react";
import { useCart } from "../context/CartContext";
import "../assets/styles/cart.css";


const Cart = ()=>{


    const {
        cartItems,
        removeFromCart
    } = useCart();



    if(cartItems.length===0){

        return (

            <h2 className="empty-cart">
                Your cart is empty
            </h2>

        );

    }



    return (

        <div className="cart-container">


            <h1>
                Shopping Cart
            </h1>



            {
                cartItems.map(item=>(


                    <div
                        className="cart-item"
                        key={item.id}
                    >


                        <div>

                            <h3>
                                {item.name}
                            </h3>


                            <p>
                                ${item.price}
                            </p>


                            <p>
                                Quantity:
                                {" "}
                                {item.quantity}
                            </p>


                        </div>



                        <button

                            onClick={()=>
                                removeFromCart(item.id)
                            }

                        >

                            Remove

                        </button>



                    </div>


                ))
            }


        </div>

    );


};


export default Cart;