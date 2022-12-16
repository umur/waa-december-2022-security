import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router'

function Category() {

  const params = useParams();
  const[categoryState,setCategoryState] = useState();

  const getCategory = async() => {
    const response = await axios.get("/categories/" + params.id);
    setCategoryState(response.data);
    console.log(response.data);
  }

  useEffect(()=>{
    getCategory();
  },[])

  return (
    <div>
      <div>Id : {categoryState?.id}</div>
      <div>name : {categoryState?.name}</div>

    </div>
  )
}

export default Category