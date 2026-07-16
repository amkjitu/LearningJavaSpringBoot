import './App.css'
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Navbar from "./components/common/Navbar";
import Home from "./pages/Home";
import Product from "./pages/Product";
import AddProduct from "./pages/AddProduct";
import Cart from "./pages/Cart";
import { Toaster } from "react-hot-toast";

function App() {
  return (
      <BrowserRouter>
        <Toaster
            position="top-right"
            reverseOrder={false}
        />
        <Navbar/>
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/add_product" element={<AddProduct/>} />
          <Route path="/product/:id" element={<Product/>} />
          <Route path="/product/edit/:id" element={<AddProduct/>}/>
          <Route path="/cart" element={<Cart/>} />
        </Routes>
      </BrowserRouter>
  )
}

export default App
