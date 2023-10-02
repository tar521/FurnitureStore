import React, {useState, useEffect} from 'react'
import "./Home.css";
import { useAppContext } from "../lib/contextLib";
import Container from "react-bootstrap/Container";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';

const Home = () => {

    const {productList, userCart, setUserCart, cartTotal, setCartTotal} = useAppContext();

    function handleClick(fitem) {
        const tempCart = [];
        var tempTotal = fitem.price + 0
        userCart.forEach(updateCart)
        function updateCart(cartObj) {
            tempTotal += cartObj.price
            tempCart.push(cartObj)
        }
        tempCart.push(fitem)
        setCartTotal(tempTotal)
        setUserCart(tempCart)
       console.log(tempCart)
       window.confirm("Added to cart!")
       //alert("Added to cart!")
    }

    return (
        <div>
        
            <Row lg={4} className="justify-content-md-center" style={{padding: "10px 100px 10px 100px"}}>
                {productList &&
                 productList.map((product) => (
                    <Col className="d-flex" key={product.title}>
                    <Card className="flex-fill" key={product.id} style={{textAlign: 'center', margin: "0 0 20px 0"}}>
                        {/* <Card.Img variant="top" src={"#"} /> */}
                        <Card.Header>{product.title}</Card.Header>
                        <Card.Body>
                        <Card.Title>{product.title}</Card.Title>
                        <Card.Text>{product.description}</Card.Text>
                        <Card.Text>{product.category}</Card.Text>
                        <Card.Text>${product.price}</Card.Text>
                        <Button variant="primary"
                            onClick={(e) => handleClick(product)}>Add to cart</Button>
                        </Card.Body>
                    </Card>
                    </Col>
                ),
                )}
            
            </Row>
        </div>
  )
}

export default Home