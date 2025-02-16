import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createEmployee } from "../services/Employee";

const AddEmployee = () => {
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if(validateForm()){
      const employee = { firstName, lastName, email };
      console.log(employee);
      createEmployee(employee).then((response) => {
        console.log(response);
        navigate("/employees");
      });
    }
    
  };

  const [errors, setErrors] = useState({
    firstName: "",
    lastName: "",
    email: "",
  });

  function validateForm() {
    let isValid = true;
    const errorsCopy = { ...errors };
    if (firstName.trim()) {
      errorsCopy.firstName = "";
    } else {
      errorsCopy.firstName = "First name is required";
      isValid = false;
    }

    if (lastName.trim()) {
      errorsCopy.lastName = "";
    } else {
      errorsCopy.lastName = "Last name is required";
      isValid = false;
    }

    if (email.trim()) {
      errorsCopy.email = "";
    } else {
      errorsCopy.email = "Email is required";
      isValid = false;
    }

    setErrors(errorsCopy)

    return isValid;
  }

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="card col-md-6 offset-md-3">
          <div className="card-body">
            <h2 className="text-center">Add Employee</h2>
            <form onSubmit={handleSubmit}>
              <div className="form-group mb-3">
                <label className="form-label">First Name:</label>
                <input
                  type="text"
                  className={`form-control ${errors.firstName ? `is-invalid`:``}`}
                  placeholder="Enter first name"
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                  
                />
                {errors.firstName && <span className="invalid-feedback">{errors.firstName}</span>}
              </div>

              <div className="form-group mb-3">
                <label className="form-label">Last Name:</label>
                <input
                  type="text"
                  className={`form-control ${errors.lastName ? `is-invalid`:``}`}
                  placeholder="Enter last name"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                  
                />
                {errors.lastName && <span className="invalid-feedback">{errors.lastName}</span>}
              </div>

              <div className="form-group mb-3">
                <label className="form-label">Email:</label>
                <input
                  type="email"
                  className={`form-control ${errors.email ? `is-invalid`:``}`}
                  placeholder="Enter email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  
                />
                {errors.email && <span className="invalid-feedback">{errors.email}</span>}
              </div>

              <div className="d-flex justify-content-between">
                <button type="submit" className="btn btn-success">
                  Submit
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => navigate("/employees")}
                >
                  Cancel
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddEmployee;
