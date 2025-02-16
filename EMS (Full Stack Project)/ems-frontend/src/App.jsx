import { useState } from "react";
import "./App.css";
import EmployeeListComponent from "./components/EmployeeListComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {

  return (
    <>
      <Router>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<EmployeeListComponent />} />
          <Route path="/employees" element={<EmployeeListComponent />} />
        </Routes>
        <FooterComponent />
      </Router>
    </>
  );
}

export default App;
