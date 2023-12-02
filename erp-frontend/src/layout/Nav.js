import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
// import { a } from "react-router-dom";

const Nav = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    // Clear authentication token or flag
    localStorage.removeItem('token'); // Remove authentication token
    // Any other logout-related operations

    // Redirect to the login page or any other desired route
    navigate('/');
  };

  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary bg-opacity-50 ">
    <div className="container-fluid ">
      <div className="navbar-brand ">
      <img src="https://www.iiitb.ac.in/includefiles/userfiles/images/IIITB%20Silver%20Jubilee%20Logo.png" alt="logo" height={70} />
        Academic ERP
      </div>
      <button
        className="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon" />
      </button>
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <Link to="/" onClick={handleLogout} className=' logout btn btn-outline-danger btn-lg shadow ms-auto'>
          Log Out
        </Link>
      </div>
    </div>
  </nav>
  )
}

export default Nav