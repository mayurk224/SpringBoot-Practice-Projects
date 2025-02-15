import { useState } from 'react'
import './App.css'
import EmployeeListComponent from './components/EmployeeListComponent'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <EmployeeListComponent />
    </>
  )
}

export default App
