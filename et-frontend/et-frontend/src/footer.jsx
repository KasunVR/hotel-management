import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Logo from './assets/work-in-progress.png';
import './css/footer.css';
import './assets/icon.css';
import useLocalStorage from 'use-local-storage';
import axios from 'axios';

function Footer() {
    const preference = window.matchMedia('(prefers-color-scheme: dark)').matches;
    const [isDark] = useLocalStorage('isDark', preference);
    const [loading, setLoading] = useState(false);
    const [showVerification, setShowVerification] = useState(false);
    const [verificationCode, setVerificationCode] = useState('');

    function generateVerificationCode() {
        const randomCode = Math.floor(Math.random() * 16777215).toString(16);
        return randomCode.slice(0, 6); 
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        setLoading(true); 
    
        const code = generateVerificationCode();
        localStorage.setItem('verificationCode', code);
    
        const emailRequest = {
            email: 'laserxnext@gmail.com',
            verificationCode: code,
        };
    
        try {
            await axios.post('http://localhost:8080/sendEmail', emailRequest);
            setShowVerification(true);
            setLoading(false);
        } catch (error) {
            alert('Error sending email: ' + error.message);
            setLoading(false);
        }
    };
    

    const handleVerificationSubmit = () => {
        const storedCode = localStorage.getItem('verificationCode');
        if (verificationCode === storedCode) {
            window.location.href = '/admin';
        } else {
            console.log(storedCode);
            alert('Incorrect verification code');
        }
    };

    return (
        <footer className="footer" data-theme={isDark ? 'dark' : 'light'}>
            <div>
                <Link className="footer-logo" onClick={handleSubmit}>
                    {loading ? ( 
                        <div>Loading...</div>
                    ) : (
                        <img src={Logo} alt="Logo" />
                    )}
                </Link>
                <p className="footer-text"></p>
            </div>
            <div>
                <ul className="socialmedia-list">
                    <li>
                        <i className="uil uil-facebook facebook"></i>
                    </li>
                    <li>
                        <i className="uil uil-linkedin linkedin"></i>
                    </li>
                    <li>
                        <i className="uil uil-whatsapp whatsapp"></i>
                    </li>
                </ul>
            </div>
            <div>
                <h3 className="service-tag">OUR SERVICES</h3>
                <ul className="service-list">
                    <li>Find Hotels</li>
                    <li>Ratings</li>
                    <li>Review</li>
                    <li>Hotel Management</li>
                </ul>
                <p className="footer-bottom">© All right reserved by laserX</p>
            </div>
            {showVerification && (
                <div className="verification-popup">
                    <input
                        type="text"
                        placeholder="Enter verification code"
                        value={verificationCode}
                        onChange={(e) => setVerificationCode(e.target.value)}
                    />
                    <button onClick={handleVerificationSubmit}>Submit</button>
                </div>
            )}
        </footer>
    );
}

export default Footer;
