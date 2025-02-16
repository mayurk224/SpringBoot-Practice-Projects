import React, { useEffect, useState } from 'react'
import { listEmployees } from '../services/Employee';
import { Link, useNavigate } from 'react-router-dom';
function EmployeeListComponent() {

    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch((error) => {
            console.log(error);
        });
    }, []);

    const navigate = useNavigate();

    const addNewEmployee = () => {
      navigate('/add-employee');
    }
    
  return (

    <div className="container mt-4">
        <h1 className="text-center mb-4">Employee List</h1>
        <button className='btn btn-primary mb-3' onClick={addNewEmployee}>Add Employee</button>
      <table className="table table-striped table-bordered">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default EmployeeListComponent