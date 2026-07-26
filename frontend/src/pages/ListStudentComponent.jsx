function ListStudentComponent() {
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
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>

        </div>
    );
}

export default ListStudentComponent;