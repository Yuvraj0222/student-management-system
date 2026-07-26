import { useEffect, useState } from "react";
import { listStudents } from "../services/StudentService";

function ListStudentComponent() {

    const [students, setStudents] = useState([]);

    useEffect(() => {
        getAllStudents();
    }, []);

    function getAllStudents() {
        listStudents()
            .then((response) => {
                setStudents(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <div className="container mt-4">

            <h2 className="text-center mb-4">
                Student List
            </h2>

            <table className="table table-bordered table-striped">

                <thead>

                <tr>

                    <th>ID</th>

                    <th>First Name</th>

                    <th>Last Name</th>

                    <th>Email</th>

                </tr>

                </thead>

                <tbody>

                {
                    students.map(student =>

                        <tr key={student.id}>

                            <td>{student.id}</td>

                            <td>{student.fname}</td>

                            <td>{student.lname}</td>

                            <td>{student.email}</td>

                        </tr>

                    )
                }

                </tbody>

            </table>

        </div>
    );
}

export default ListStudentComponent;
