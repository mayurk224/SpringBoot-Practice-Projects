import React from 'react'

function HeaderComponent() {
  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <div className='container'>
                    <a className='navbar-brand' href='/'>Employee Management System</a>
                    <button 
                        className='navbar-toggler' 
                        type='button' 
                        data-bs-toggle='collapse' 
                        data-bs-target='#navbarNav' 
                        aria-controls='navbarNav' 
                        aria-expanded='false' 
                        aria-label='Toggle navigation'
                    >
                        <span className='navbar-toggler-icon'></span>
                    </button>
                    <div className='collapse navbar-collapse' id='navbarNav'>
                        <ul className='navbar-nav'>
                            <li className='nav-item'>
                                <a className='nav-link' href='/employees'>Employees</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent