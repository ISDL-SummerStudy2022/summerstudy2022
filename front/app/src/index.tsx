import React from 'react';
import ReactDOM from 'react-dom';
import './assets/css/styles.scss'
import App from './App';
// import reportWebVitals from './reportWebVitals';
import { ApiFetch } from './components/ApiFetch';

ReactDOM.render(
  <React.StrictMode>
    <App />
    <ApiFetch />
  </React.StrictMode>,
  document.getElementById('root')
);
// reportWebVitals();
