import React, { createContext, useContext, useState } from "react";
const CartContext = createContext();

export const CartProvider = ({children}) => {

    const [cartItems,setCartItems] = useState([]);
    const addToCart = (product)=>{

        setCartItems((previous)=>{

            const existingProduct =
                previous.find(
                    item=>item.id === product.id
                );

            if(existingProduct){

                return previous.map(item=>

                    item.id === product.id

                        ?

                        {
                            ...item,
                            quantity:item.quantity + 1
                        }

                        :

                        item

                );

            }



            return [

                ...previous,

                {
                    ...product,
                    quantity:1
                }

            ];

        });


    };



    const removeFromCart=(id)=>{


        setCartItems(

            previous=>
                previous.filter(
                    item=>item.id !== id
                )

        );


    };



    const clearCart=()=>{

        setCartItems([]);

    };



    return (

        <CartContext.Provider

            value={{
                cartItems,
                addToCart,
                removeFromCart,
                clearCart
            }}

        >

            {children}

        </CartContext.Provider>

    );

};



export const useCart = ()=>{

    return useContext(CartContext);

};