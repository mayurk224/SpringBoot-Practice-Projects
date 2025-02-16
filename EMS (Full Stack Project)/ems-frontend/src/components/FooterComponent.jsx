import React from 'react'

const FooterComponent = () => {
  return (
    <div>
        <footer className='footer' style={{ position: 'fixed', bottom: 0, width: '100%', backgroundColor: 'white', padding: '15px 0', borderTop: '1px solid #e7e7e7' }}>
            <div className='container'>
                <div className='row'>
                    <div className='col text-center'>
                        <span className='text-muted'>All Rights Reserved 2024 @Employee Management System</span>
                    </div>
                </div>
            </div>
        </footer>
    </div>
  )
}

export default FooterComponent