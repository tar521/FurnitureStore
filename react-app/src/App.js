import React, { useState, useEffect } from 'react';

import './App.css';
import { useNavigate } from "react-router-dom";
import { AppContext } from "./lib/contextLib";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Routes from "./Routes";
import Container from 'react-bootstrap/Container';
import { LinkContainer } from "react-router-bootstrap";

function App() {
  const [userCart, setUserCart] = useState([])
  const [cartTotal, setCartTotal] = useState(0.00)
  const [productList, setProductList] = useState([
    {
        id: 1,
        title: "Comfy Chair", 
        price: 50.99, 
        category: "CHAIR", 
        description: "COMFY CHAIR TO SIT IN"

    },
    {
        id: 2,
        title: "3-Seater Couch", 
        price: 100.99, 
        category: "CHAIR", 
        description: "COMFY THINGS TO SIT IN"

    },
    {
        id: 3,
        title: "Side Table", 
        price: 40.99, 
        category: "TABLE", 
        description: "STYLISH THING TO PLACE ITEMS"

    },
    {
        id: 4,
        title: "Coffee Table", 
        price: 55.99, 
        category: "TABLE", 
        description: "STYLISH THING TO PLACE ITEMS"

    },
    {
        id: 5,
        title: "Ottoman", 
        price: 40.99, 
        category: "COUCH", 
        description: "STYLISH THING FOR LEGS"

    },
    {
        id: 6,
        title: "Lamp", 
        price: 55.99, 
        category: "LAMP", 
        description: "DEVICE FOR LIGHT"

    },
    {
        id: 7,
        title: "Blanket", 
        price: 40.99, 
        category: "BLANKET", 
        description: "STYLISH WARM THING"

    },
    {
        id: 8,
        title: "Shelf", 
        price: 55.99, 
        category: "SHELF", 
        description: "WALL SHELF"

    }
])


  return (
    <>
        <Navbar collapseOnSelect bg="secondary opacity-75" data-bs-theme="dark" expand="md" className="mb-3">
          <Container>
          <LinkContainer to="/">
            <Navbar.Brand>
              Furniture Store
            </Navbar.Brand>
          </LinkContainer>
          <Navbar.Toggle />
          <Navbar.Collapse className="justify-content-end">
            <Nav activeKey={window.location.pathname}>
            
              <>
                {/* <LinkContainer to="/settings">
                  <Nav.Link>Settings</Nav.Link>
                </LinkContainer>
                <Nav.Link onClick={handleLogout}>Logout</Nav.Link> */}
              </>
              <>
                <LinkContainer to="/login">
                  <Nav.Link>Login</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/cart">
                  <Nav.Link>Cart</Nav.Link>
                </LinkContainer>
              </>
            </Nav>
          </Navbar.Collapse>
          </Container>
        </Navbar>
        
        <AppContext.Provider value={{ productList, userCart, setUserCart, setCartTotal, cartTotal }}>
          <Routes />
        </AppContext.Provider>
        </>
  );
}

export default App;
