import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router";

function Categories() {
  const [categoriesState, setCategoriesState] = useState([]);
  const navigate = useNavigate();

  const fetchCategory = async () => {
    const categoryObject = await axios.get("/categories");
    setCategoriesState(categoryObject?.data);
  };

 

  useEffect(() => {
    fetchCategory();
  }, []);

 

  const onShowDetailClicked = (id) => {
    navigate('/category-detail/' + id);
  };

  return (
    <div className="d-flex justify-content-center mt-5">
      <table className="table table-bordered table-hover  rounded">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {categoriesState?.map((item) => {
            return (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>
                  <button
                    type="button"
                    className="btn btn-outline-dark text-dark"
                    onClick={() => onShowDetailClicked(item.id)}
                  >
                    More Info
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default Categories;
