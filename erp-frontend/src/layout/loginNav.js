import React from 'react'

const Nav = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary bg-opacity-50">
    <div className="container-fluid">
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
      </div>
    </div>
  </nav>
  )
}

export default Nav