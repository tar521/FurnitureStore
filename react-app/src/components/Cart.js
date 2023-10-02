import React from 'react'
import "./Cart.css"
import { useAppContext } from "../lib/contextLib";

const Cart = () => {

    const {productList, userCart, setUserCart, cartTotal, setCartTotal} = useAppContext();

  return (
    <div className="Cart">
        <section className="cart">
      <h1>Cart</h1>

      <div className="container">
        {userCart.map(product => (
          <div className="product" key={product.id}>
            {/* <img src={product.thumbnail} alt={product.title} /> */}
            <h3>{product.title}</h3>
            <h3 className="text-end">${product.price}</h3>
            {/* <Quantifier
              removeProductCallback={() => handleRemoveProduct(product.id)}
              productId={product.id}
              handleUpdateQuantity={handleUpdateQuantity} /> */}
          </div>
        ))}
      </div>
      <div className="text-center">
        <h2>${cartTotal.toFixed(2)}</h2>
        </div>
    </section>
    </div>
  )
}

export default Cart