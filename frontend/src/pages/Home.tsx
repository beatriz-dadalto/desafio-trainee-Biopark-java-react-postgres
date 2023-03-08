import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Apartment } from '../model/Apartment';

export function Home() {
  const [apiData, setApiData] = useState<Apartment[]>();

  useEffect(() => {
    axios
      .get(`http://localhost:8080/apartments`)
      .then((getData) => {
        setApiData(getData.data);
        console.log(getData.data);
      })
      .catch((error) => {
        setApiData(undefined);
        console.log(error);
      });
  }, [apiData]);

  return (
    <>
      {apiData &&
        apiData.map((data) => {
          let role = data.user.role.toString();

          return (
            <div className="card" key={data.id}>
              <div className="card-item">
                <p>Apartment{data.statusApartment}</p>
                <img
                  className="card-img"
                  src={data.imageUrl}
                  alt="apartment"
                />
                <div className="item-description">
                  <p>Locatário: {role === '0' ? "Biopark" : data.user.name}</p>
                  <p>Quarto: {data.bedroom}</p>
                  <p>Banheiro: {data.bathroom}</p>
                  <p>Garagem: {data.garage}</p>
                </div>
                <Link to="advertise">Quero Ver</Link>
              </div>
            </div>
          );
        })}
    </>
  );
}

export default Home;
