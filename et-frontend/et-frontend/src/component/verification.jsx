import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';

function Verification() {
    const [verificationCode, setVerificationCode] = useState('');
    const [error, setError] = useState('');
    const history = useHistory();

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/checkVerificationCode', { verificationCode });

            if (response.data.success) {
                history.push('/admin');
            } else {
                setError('Invalid verification code');
            }
        } catch (error) {
            setError('Error checking verification code');
        }
    };

    return (
        <div>
            <h2>Verification</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Verification Code:
                    <input type="text" value={verificationCode} onChange={(e) => setVerificationCode(e.target.value)} />
                </label>
                <button type="submit">Submit</button>
            </form>
            {error && <p>{error}</p>}
        </div>
    );
}

export default Verification;