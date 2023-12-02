import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Nav from '../layout/Nav';

const Home = () => {
    const [students, setStudents] = useState([]);
    const [filterData, setFilterData] = useState([]);
    const [query, setQuery] = useState('');
    const [selectedParam, setSelectedParam] = useState('');

    useEffect(() => {
        const token = localStorage.getItem('token');

        // Check if the user is authenticated
        if (!token) {
            // Redirect to login if the user is not authenticated
            window.location.href = '/';
        } else {
            loadStudents(); // Load data if the user is authenticated
        }
    }, []);

    useEffect(() => {
        loadStudents();
    }, []);

    const loadStudents = async () => {
        const result = await axios.get("http://localhost:9191/students");
        setStudents(result.data);
        setFilterData(result.data);
    }

    const handlesearch = (event) => {
        const getSearch = event.target.value;
        if (getSearch.length > 0) {
            let searchData = [];

            switch (selectedParam) {
                case 'organisation':
                    searchData = filterData.filter(item => item.placement_id.organisation_id.name.toLowerCase().includes(getSearch.toLowerCase()));
                    break;
                case 'domain':
                    searchData = filterData.filter(item => item.domain.toLowerCase().includes(getSearch.toLowerCase()));
                    break;
                case 'specialisation':
                    searchData = filterData.filter(item => item.specialisation.toLowerCase().includes(getSearch.toLowerCase()));
                    break;
                case 'year':
                    searchData = filterData.filter(item => item.graduation_year.toString().includes(getSearch));
                    break;
                default:
                    searchData = filterData.filter(item => item.first_name.toLowerCase().includes(getSearch.toLowerCase()));
                    break;
            }
            setStudents(searchData);
        }
        else {
            setStudents(filterData);
        }
        setQuery(getSearch);
    }

    const clearFilter = () => {
        setStudents(filterData); // Reset the displayed data to the initial state (show all data)
        setSelectedParam('');    // Reset the selected parameter to empty
        setQuery('');            // Reset the search query to empty
    };

    const handleDropdownChange = (event) => {
        setSelectedParam(event.target.value);
    }

    return (
        <div>
            <Nav />
        
        <div className='container border border rounded-1 mt-5 shadow bg-white'>
            
            <img src='https://www.iiitb.ac.in/includefiles/userfiles/images/IIITB%20Silver%20Jubilee%20Logo.png' alt='logo'className='w-25'/>
            <div>
                <h1 className='text-dark fw-bold mb-5'>Placement History</h1>
            </div>

            <div className="container justify-content-around mb-3 w-50">
                <label htmlFor="selectParam" className="form-label text-dark fs-5 fw-bold">Filter :</label>
                <select
                    id="selectParam"
                    className="form-select rounded-4"
                    value={selectedParam}
                    onChange={(e) => handleDropdownChange(e)}
                >
                    <option value="">Select Parameter</option>
                    <option value="organisation">Organization</option>
                    <option value="domain">Domain</option>
                    <option value="specialisation">Specialisation</option>
                    <option value="year">Year</option>
                </select>
            </div>

            {selectedParam && (
                <div className="container justify-content-around w-50 mb-3">
                    {selectedParam === 'organisation' && (
                        <select
                            id="secondDropdown"
                            className="form-select rounded-4"
                            value={query}
                            onChange={(e) => handlesearch(e)}
                        >
                            <option value="">Select Parameter</option>
                            <option value="google">Google</option>
                            <option value="apple">Apple</option>
                            <option value="microsoft">Microsoft</option>
                            <option value="infosys">Infosys</option>
                        </select>
                    )}
                    {selectedParam === 'domain' && (
                        <select
                            id="secondDropdown"
                            className="form-select rounded-4"
                            value={query}
                            onChange={(e) => handlesearch(e)}
                        >
                            <option value="">Select Parameter</option>
                            <option value="mtech cse">MTech CSE</option>
                            <option value="mtech ece">MTech ECE</option>
                        </select>
                    )}
                    {selectedParam === 'specialisation' && (
                        <select
                            id="secondDropdown"
                            className="form-select rounded-4"
                            value={query}
                            onChange={(e) => handlesearch(e)}
                        >
                            <option value="">Select Parameter</option>
                            <option value="nc">NC</option>
                            <option value="ai/ml">AIML</option>
                            <option value="tscd">TSCD</option>
                            <option value="vlsi">VLSI</option>
                            <option value="none">None</option>
                        </select>
                    )}
                    {selectedParam === 'year' && (
                        <select
                            id="secondDropdown"
                            className="form-select rounded-4"
                            value={query}
                            onChange={(e) => handlesearch(e)}
                        >
                            <option value="">Select Parameter</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                        </select>
                    )}
                    <button
                        className="btn btn-outline-info mt-3"
                        onClick={clearFilter}
                    >
                        Clear Filter
                    </button>
                </div>
            )}

            <div className='py-4'>
                <table className="table border shadow table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Sl.No.</th>
                            <th scope="col">Name</th>
                            <th scope="col">Roll Number</th>
                            <th scope="col">Domain</th>
                            <th scope="col">Specialisation</th>
                            <th scope="col">Graduation Year</th>
                            <th scope="col">Organisation</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            students.map((student, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{`${student.first_name} ${student.last_name}`}
                                        {student.graduation_year && student.graduation_year <= 2022 ? (
                                            <span className="border badge rounded-pill badge-dark">Alumni</span>
                                        ) : null}
                                    </td>
                                    <td>{student.roll_number}</td>
                                    <td>{student.domain}</td>
                                    <td>{student.specialisation}</td>
                                    <td>{student.graduation_year}</td>
                                    <td>{student.placement_id.organisation_id.name}</td>

                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>
        </div>
        </div>
    )
}

export default Home