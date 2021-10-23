import React from "react";
import "./Footer.styles.css";

const Footer = () => {
  return (
    <footer id="footer">
      <h1>
        Made by <span>Kapil Negi</span>
      </h1>
      <div className="socialIcons">
        <a href="https://instagram.com/">
          <i className="fab fa-instagram"></i>
        </a>
        <a href="https://twitter.com/">
          <i className="fab fa-twitter"></i>
        </a>
        <a href="https://www.linkedin.com/in/kapil-negi-8494b5149/">
          <i className="fab fa-linkedin"></i>
        </a>
        <a href="https://github.com/kapilnegi98">
          <i className="fab fa-github"></i>
        </a>
      </div>
    </footer>
  );
};

export default Footer;
