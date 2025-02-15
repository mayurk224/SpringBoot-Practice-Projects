import { useState } from 'react'
import './App.css'
import EmployeeListComponent from './components/EmployeeListComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <HeaderComponent />
      <EmployeeListComponent />
      <FooterComponent />
    </>
  )
}

export default App
