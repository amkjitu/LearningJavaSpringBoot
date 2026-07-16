import { NavLink } from "react-router-dom";
import { FaShoppingCart, FaStore } from "react-icons/fa";
import "../../assets/styles/navbar.css";
import { useCart } from "../../context/CartContext";

const Navbar = () => {
    const { cartItems } = useCart();

    return (
        <header className="navbar">

            <div className="logo">
                <FaStore />
                <span>ShopEasy</span>
            </div>

            <nav className="nav-links">

                <NavLink
                    to="/home"
                    className={({ isActive }) =>
                        isActive ? "nav-link active" : "nav-link"
                    }
                >
                    Home
                </NavLink>

                <NavLink
                    to="/add_product"
                    className={({ isActive }) =>
                        isActive ? "nav-link active" : "nav-link"
                    }
                >
                    Add Product
                </NavLink>

                <NavLink
                    to="/cart"
                    className={({ isActive }) =>
                        isActive ? "nav-link active" : "nav-link"
                    }
                >
                    <FaShoppingCart />

                    Cart

                    <span className="cart-badge">
                        {cartItems.length}
                    </span>

                </NavLink>

            </nav>

            <div className="search-box">

                <input
                    type="text"
                    placeholder="Search products..."
                />

            </div>

        </header>
    );
};

export default Navbar;