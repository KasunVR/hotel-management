import './css/hoteldata.css';
import React,{useEffect, useState} from 'react';
import {listhotel} from './service/districtservice.js';
import{Link} from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import Error from './error.jsx';
import useLocalStorage from "use-local-storage";

const data = () =>{
    const preference = window.matchMedia("(prefers-color-scheme: dark)").matches;
    const [isDark] = useLocalStorage("isDark", preference);

    const[hotel,sethotel] = useState([]);
    const { search } = useLocation();
    const queryParams = new URLSearchParams(search);
    const district = queryParams.get('district');

    useEffect (() => {
        listhotel().then((response) => {
            if (district) 
            {
            const filteredHotels = response.data.filter(hotel => hotel.hotel_state === district);
            sethotel(filteredHotels);
            } 
            else 
            {
            sethotel(response.data);
            }

        }).catch(error => {

            console.error('Error fetching data: ', error);

        })
    },
    [])
    return(
        <div className="hotels"  data-theme={isDark ? 'dark' : 'light'}>
        {hotel.length === 0 && <Error/>}
        {
            hotel.map(hotel =>
            <div class="hotel">
                <img src={"./src/assets/Hotel/"+hotel.hotel_image} class="hotel-img"/>
                <div class="hotel-info">
                    <p class="hotel-name">{hotel.hotel_name}</p>
                    <p class="hotel-addr">{hotel.hotel_address},{hotel.hotel_city},<br/>{hotel.hotel_state}</p>
                    <p class="ratings">{hotel.hotel_rating}<i class="uil uil-star"/></p>
                    <p class="hotel-price">Rs. {hotel.hotel_price}  (per night)</p>
                    <p class="hotel-contact">Phone No - {hotel.hotel_phone}</p>
                    <Link to={hotel.hotel_website}><p class="hotel-website"><i class="uil uil-globe"/> Visit the Website</p></Link>
                </div>
            </div>
            )
        }
        </div>
    );
}

export default data;