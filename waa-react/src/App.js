
import "./App.css";
import Address from "./Components/Address";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./Components/Header";
import Product from "./Components/Product";
import { Link, Route, Routes } from "react-router-dom";
import Categories from "./Components/Categories";
import Review from "./Components/Review";
import axios from "axios";
import { useEffect, useState } from "react";
import Category from "./Components/Category";

function App() {

  axios.defaults.baseURL = 'http://localhost:7070';



  const [tokenState,setTokenState] = useState(null);

  const fetchToken = async() =>
  {
    let tokenObj = await axios.post("/uaa",{email:"uinan@miu.edu",password:"123"});
    setTokenState(tokenObj?.data?.accessToken)
  }

  useEffect(()=>{
      fetchToken();
  },[]);

  useEffect(()=>{
    axios.defaults.headers.common['Authorization'] =  `Bearer ${tokenState}`;
  },[tokenState]);



  return (
    <div className="w-100">
      <div className="row">
        <div className="col-12">
          <Header />
        </div>
      </div>
      <div className="container">
        <div className="row">
          <div className="col-12">
            <div className="d-flex justify-content-center">
              <ul className="list-group list-group-horizontal-sm">
                <li className="list-group-item">
                  <Link to={"/category"} className="text-decoration-none text-success">Category</Link>
                </li>
                <li className="list-group-item">
                  <Link to={"/product"} className="text-decoration-none text-success">Product</Link>
                </li>
                <li className="list-group-item">
                  <Link to={"/review"} className="text-decoration-none text-success">Review</Link>
                </li>
                <li className="list-group-item">
                  <Link to={"/address"} className="text-decoration-none text-success">Address</Link>
                </li>
              </ul>
            </div>
          </div>
        </div>

        <Routes>
          <Route path="/category" element={<Categories />} />
          <Route path="/product" element={<Product />} />
          <Route path="/review" element={<Review />} />
          <Route path="/address" element={<Address />} />
          <Route path="/category-detail/:id" element={<Category/>}/>
        </Routes>
      </div>
    </div>
  );
}

export default App;
