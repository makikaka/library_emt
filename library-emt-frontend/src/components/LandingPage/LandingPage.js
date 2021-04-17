import React from 'react';
import './LandingPage.css';
import logo from '../../logo.svg';

const LandingPage = () => {
  return (
    <div className="LandingPage text-center">
      <img src={logo} className="App-logo" alt="logo" />
    </div>
  )
}
LandingPage.propTypes = {
}

export default LandingPage;