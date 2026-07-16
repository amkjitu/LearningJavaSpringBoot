import React, { useState, useEffect, useRef } from "react";
import { addProduct, getProductById, updateProduct } from "../../services/productService";
import toast from "react-hot-toast";
import "../../assets/styles/form.css";

const ProductForm = ({productId}) => {

    const [product,setProduct] = useState({

        name:"",
        description:"",
        brand:"",
        price:"",
        category:"",
        releaseDate:"",
        available:true,
        quantity:""

    });

    const [image,setImage] = useState(null);

    const [preview, setPreview] = useState(null);

    useEffect(()=>{

        if(productId){
            const fetchProduct = async()=>{
                try{
                    const response = await getProductById(productId);
                    setProduct(response.data);
                    if(response.data.imageName){
                        setPreview(
                            `http://localhost:82/api/product/${productId}/image`
                        );
                    }
                }
                catch(error){
                    console.error(error);
                }
            };
            fetchProduct();
        }
    },[productId]);

    const [loading,setLoading] = useState(false);

    const fileInputRef = useRef(null);

    const handleChange=(e)=>{

        const {name,value,type,checked}=e.target;

        setProduct({
            ...product,
            [name]:
                type==="checkbox"
                    ?
                    checked
                    :
                    value

        });
    };



    const handleSubmit=async(e)=>{

        e.preventDefault();

        if(product.name.trim()===""){
            toast.error("Product name is required");
            return;
        }

        if(product.price<=0){
            toast.error("Price must be greater than zero");
            return;
        }

        if(product.quantity<0){
            toast.error("Quantity cannot be negative");
            return;
        }

        if(product.category.trim()===""){
            toast.error("Category is required");
            return;
        }

        if(product.brand.trim()===""){
            toast.error("Brand is required");
            return;
        }

        try{

            const formData = new FormData();
            formData.append(
                "product",
                new Blob(
                    [
                        JSON.stringify(product)
                    ],
                    {
                        type:"application/json"
                    }
                )
            );

            if(image){
                formData.append(
                    "imageFile",
                    image
                );
            }

            if(productId){
                await updateProduct(productId, formData);
                toast.success(
                    "Product updated successfully"
                );
            }
            else{
                const response = await addProduct(formData);
                if(response.status === 201){
                    toast.success(
                        `${product.name} added successfully`
                    );
                }
            }

            setProduct({

                name:"",
                description:"",
                brand:"",
                price:"",
                category:"",
                releaseDate:"",
                available:true,
                quantity:""

            });
        }
        catch(error){
            console.error(error);
            toast.error("Failed to add product");

        }
        finally {

            setImage(null);
            setPreview(null);
            setLoading(false);
        }
    };


    return (

        <div className="form-container">
            <h2>
                Add New Product
            </h2>
            <form onSubmit={handleSubmit}>

                <div className="form-group">
                    <label>
                        Product Name
                    </label>
                    <input
                        name="name"
                        placeholder="Product Name"
                        value={product.name}
                        onChange={handleChange}
                    />
                </div>

                <div className="row">
                    <div className="form-group">
                        <label>
                            Price
                        </label>
                        <input
                            name="price"
                            type="number"
                            placeholder="Price"
                            value={product.price}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>
                            Quantity
                        </label>
                        <input
                            name="quantity"
                            type="number"
                            placeholder="Quantity"
                            value={product.quantity}
                            onChange={handleChange}
                        />
                    </div>
                </div>

                <div className="row">
                    <div className="form-group">
                        <label>
                            Brand
                        </label>
                        <input
                            name="brand"
                            placeholder="Brand"
                            value={product.brand}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>
                            Category
                        </label>
                        <input
                            name="category"
                            placeholder="Category"
                            value={product.category}
                            onChange={handleChange}
                        />
                    </div>
                </div>

                <div className="form-group">
                    <label>
                        Release Date
                    </label>
                    <input
                        name="releaseDate"
                        type="date"
                        value={product.releaseDate}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>
                        Available
                    </label>
                    <input
                        type="checkbox"
                        name="available"
                        checked={product.available}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>
                        Description
                    </label>
                    <textarea
                        name="description"
                        placeholder="Description"
                        value={product.description}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>
                        Product Image
                    </label>
                    <input
                        ref={fileInputRef}
                        type="file"
                        accept="image/*"
                        required
                        onChange={(e)=>{
                            const file = e.target.files[0];
                            setImage(file);
                            if(file){
                                setPreview(URL.createObjectURL(file));
                            }
                        }}
                    />
                </div>

                {
                    preview && (
                        <div className="image-preview">
                            <img
                                src={preview}
                                alt="Preview"
                            />
                        </div>
                    )
                }

                <button type="submit" disabled={loading}>
                    {
                        loading
                            ? "Processing.."
                            : ( productId
                                ? "Update Product"
                                : "Add Product"
                            )
                    }
                </button>

            </form>
        </div>
    );
};

export default ProductForm;