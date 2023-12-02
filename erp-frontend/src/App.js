// import logo from './logo.svg';
import './App.css';
import './layout/MyStyle.css'
import Home from './pages/Home'
import Login from './pages/login';
import Footer from './layout/Footer';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {

  return (
    <div className="App">
      
      <Router>
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/home" element={<Home />} />
        </Routes>
        <Footer />
      </Router>
    </div>
  );
}

export default App;



