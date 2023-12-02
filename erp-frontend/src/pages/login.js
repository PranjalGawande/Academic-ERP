import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import LoginNav from '../layout/loginNav';
import { v4 as uuidv4 } from 'uuid';


export default function Login() {

    let navigate=useNavigate()
    const [user,setUser]=useState(
        {
            email:"",
            password:"",
        }
    )
    const{email,password}=user

    const onInputChange=(e)=>{
        const {id,value}=e.target;
        setUser({ ...user, [id]: value });

    };
    const onSubmit = async (e) => {
        e.preventDefault();
        try {
            const randomToken = uuidv4();       // generates a random token
            // eslint-disable-next-line no-unused-vars
            const response = await axios.post("http://localhost:9191/login", user, {token: randomToken});
            // const token = response.data.token; 
            localStorage.setItem("token", randomToken);
            navigate("/home");
            
        } 
        catch (error) {
            if (error.response && error.response.status === 401) {
                alert('Invalid Email or Password!');
            } else {
                alert('Only Employees of Outreach department are allowed to Login here!!!');
            }
        }
    };
    return (

        <div>
            <LoginNav />
        <div className="container"> 
        <div className="row mt-3">
            <div className='container w-50 justify-content-around border bg-white rounded p-4 mt-5 shadow'>
                <img src="https://www.iiitb.ac.in/includefiles/userfiles/images/IIITB%20Silver%20Jubilee%20Logo.png" alt='logo' class="img-fluid rounded w-50 mb-3"/>
            
                <h2 className='text-center text-dark mt-3'>IIITB Academic ERP</h2>
                <h3 className='text-center text-dark m-4'>Login</h3>
                <form onSubmit={(e)=>onSubmit(e)}>
                <div className='container mb-3 w-50'>
                    <label htmlFor='Name' className='form-label text-dark'>
                        E-mail ID:
                    </label>
                    <input type="text" className="form-control text-dark" placeholder="Enter Email Id" id="email" value={email} onChange={(e) => onInputChange(e)} />
                </div>
                <div className='container mb-5 w-50'>
                    <label htmlFor='Name' className='form-label text-dark'>
                        Password:
                    </label>
                    <input type="password"  className="form-control" placeholder="Enter Password" id="password" value={password} onChange={(e) => onInputChange(e)} />

                </div>
                <button type="submit" className="btn btn-primary btn-lg shadow rounded-2">
                Submit
                </button>
                </form>
            </div>
        </div>
    </div>
    </div>
    )
}

// export default login