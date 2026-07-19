import { NavLink, useNavigate } from "react-router-dom";
import { FaShoppingCart, FaStore } from "react-icons/fa";
import "../../assets/styles/navbar.css";
import { useCart } from "../../context/CartContext";
import { searchProducts } from "../../services/productService.js";
import { useState, useEffect, useRef } from "react";

const Navbar = () => {
    const { cartItems } = useCart();
    const navigate = useNavigate();
    const [input, setInput] = useState("");
    const [debouncedInput, setDebouncedInput] = useState("");
    const [searchResults, setSearchResults] = useState([]);
    const [showSearchResults, setShowSearchResults] = useState(false);
    const [noResults, setNoResults] = useState(false);
    const searchRef = useRef(null);

    /*
        Debounce search input
    */
    useEffect(() => {
        const timer = setTimeout(() => {
            setDebouncedInput(input);
        }, 300);
        return () => clearTimeout(timer);
    }, [input]);

    /*
        Call backend search API
    */
    useEffect(() => {
        const search = async () => {
            if (!debouncedInput.trim()) {
                setSearchResults([]);
                setShowSearchResults(false);
                setNoResults(false);
                return;
            }

            try {
                const response =
                    await searchProducts(debouncedInput);
                setSearchResults(response.data);
                setNoResults(
                    response.data.length === 0
                );
                setShowSearchResults(true);
            } catch(error) {
                console.error(
                    "Search error:",
                    error
                );
            }
        };

        search();

    }, [debouncedInput]);


    /*
        Input change
    */
    const handleChange = (value) => {
        setInput(value);
    };

    /*
        Click search result
    */
    const handleSearchResultClick = (productId) => {
        navigate(`/product/${productId}`);
        setInput("");
        setSearchResults([]);
        setShowSearchResults(false);
        setNoResults(false);
    };

    /*
        Close dropdown when clicking outside
    */
    useEffect(() => {
        const handleClickOutside = (event) => {
            if(
                searchRef.current &&
                !searchRef.current.contains(event.target)
            ){
                setShowSearchResults(false);
            }
        };

        document.addEventListener(
            "mousedown",
            handleClickOutside
        );

        return () => {
            document.removeEventListener(
                "mousedown",
                handleClickOutside
            );

        };

    }, []);

    return (
        <header className="navbar">
            <div className="logo">
                <FaStore />
                <span>
                    ShopEasy
                </span>
            </div>

            <nav className="nav-links">
                <NavLink
                    to="/"
                    className={({isActive}) =>
                        isActive
                            ?
                            "nav-link active"
                            :
                            "nav-link"
                    }
                >
                    Home
                </NavLink>

                <NavLink
                    to="/add_product"
                    className={({isActive}) =>
                        isActive
                            ?
                            "nav-link active"
                            :
                            "nav-link"
                    }
                >
                    Add Product
                </NavLink>

                <NavLink
                    to="/cart"
                    className={({isActive}) =>
                        isActive
                            ?
                            "nav-link active"
                            :
                            "nav-link"
                    }
                >
                    <FaShoppingCart />
                    Cart
                    <span className="cart-badge">
                        {cartItems.length}
                    </span>
                </NavLink>

            </nav>

            <div
                className="search-box"
                ref={searchRef}
            >
                <input
                    type="search"
                    placeholder="Search products..."
                    value={input}
                    onChange={
                        (e)=>
                            handleChange(e.target.value)
                    }
                    onFocus={() => {
                        if(searchResults.length > 0){
                            setShowSearchResults(true);
                        }
                    }}
                />

                {
                    showSearchResults && (
                        <div className="search-results">
                            {
                                noResults ?
                                    (
                                        <div className="search-item no-result">
                                            No products found
                                        </div>
                                    )
                                    :
                                    (
                                        searchResults.map(product => (
                                            <div
                                                key={product.id}
                                                className="search-item"
                                                onClick={() =>
                                                    handleSearchResultClick(
                                                        product.id
                                                    )
                                                }
                                            >
                                                <div>
                                                    <strong>
                                                        {product.name}
                                                    </strong>
                                                    <small>
                                                        {product.brand}
                                                    </small>
                                                </div>
                                                <span>
                                                ${product.price}
                                            </span>
                                            </div>

                                        ))
                                    )
                            }
                        </div>
                    )
                }
            </div>
        </header>
    );
};

export default Navbar;