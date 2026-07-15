import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
    return (
        <div style={{ padding: "16px 20px", borderBottom: "1px solid #eee", display: "flex", gap: "16px", alignItems: "center" }}>
            <strong style={{ marginRight: "12px" }}>Shop</strong>
            <Link to="/home" style={{ color: "#1a73e8", textDecoration: "none", fontWeight: 600 }}>
                Home
            </Link>
            <Link to="/add_product" style={{ color: "#1a73e8", textDecoration: "none", fontWeight: 600 }}>
                Add Product
            </Link>
        </div>
    );
};

export default Navbar;