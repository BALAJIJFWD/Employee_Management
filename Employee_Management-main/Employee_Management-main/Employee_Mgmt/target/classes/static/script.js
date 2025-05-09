const employees = [
  { firstName: "Sibin", lastName: "trivandrum", email: "sibinzaiya@gmail.com" },
  { firstName: "beta", lastName: "pro", email: "betapro@gmail.com" },
  { firstName: "alpha", lastName: "pro", email: "betapro@gmail.com" },
  { firstName: "tera", lastName: "byte", email: "tera@gmail.com" },
];

function renderTable() {
  const tableBody = document.getElementById('employeeTableBody');
  tableBody.innerHTML = "";

  employees.forEach((emp, index) => {
    const row = document.createElement('tr');

    row.innerHTML = `
      <td>${emp.firstName}</td>
      <td>${emp.lastName}</td>
      <td>${emp.email}</td>
      <td>
        <button class="action-btn update-btn" onclick="updateEmployee(${index})">Update</button>
        <button class="action-btn delete-btn" onclick="deleteEmployee(${index})">Delete</button>
        <button class="action-btn view-btn" onclick="viewEmployee(${index})">View</button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

function updateEmployee(index) {
  alert("Update clicked for: " + employees[index].firstName);
}

function deleteEmployee(index) {
  if (confirm(`Are you sure you want to delete ${employees[index].firstName}?`)) {
    employees.splice(index, 1);
    renderTable();
  }
}

function viewEmployee(index) {
  const emp = employees[index];
  const viewContent = `
    <strong>First Name:</strong> ${emp.firstName}<br/>
    <strong>Last Name:</strong> ${emp.lastName}<br/>
    <strong>Email:</strong> ${emp.email}
  `;
  document.getElementById('viewContent').innerHTML = viewContent;
  document.getElementById('viewModal').style.display = 'block';
}

function closeModal() {
  document.getElementById('viewModal').style.display = 'none';
}

renderTable();
