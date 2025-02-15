import React from 'react'

function EmployeeListComponent() {
    const dummyEmployees = [
        {
            id: 1,
            firstName: 'John',
            lastName:'Doe',
            email: 'john.doe@example.com',
        },
        {
            id: 2,
            firstName: 'Jane',
            lastName:'Doe',
            email: 'jane.doe@example.com',
        },
        {
            id: 3,
            firstName: 'Jim',
            lastName:'Beam',
            email: 'jim.beam@example.com',
        },
        {
            id: 4,
            firstName: 'Jill',
            lastName:'Doe',
            email: 'jill.doe@example.com',
        },
        {
            id: 5,
            firstName: 'Jack',
            lastName:'Doe',
            email: 'jack.doe@example.com',
        },
    ]
    
  return (

    <div className="container mt-4">
        <h1 className="text-center mb-4">Employee List</h1>
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
          {dummyEmployees.map(employee => (
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