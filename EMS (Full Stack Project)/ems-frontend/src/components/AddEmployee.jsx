import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const AddEmployee = () => {
  const navigate = useNavigate();

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const employee = { firstName, lastName, email };
    console.log(employee);
  };

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
                  className="form-control"
                  placeholder="Enter first name"
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                  required
                />
              </div>

              <div className="form-group mb-3">
                <label className="form-label">Last Name:</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter last name"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                  required
                />
              </div>

              <div className="form-group mb-3">
                <label className="form-label">Email:</label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Enter email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
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
