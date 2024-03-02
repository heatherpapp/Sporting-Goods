// Function to validate user credentials
function validateCredentials(username, password) {
    // Replace this with your authentication logic
    // For demonstration purposes, assuming a hardcoded username and password
    var validUsername = "user";
    var validPassword = "password";

    if (username === validUsername && password === validPassword) {
        return true;
    } else {
        return false;
    }
}

// Function to handle form submission
function login() {
    var username = document.getElementById('Username').value;
    var password = document.getElementById('Password').value;

    if (validateCredentials(username, password)) {
        alert('Login successful');
        // Redirect to another page upon successful login
        window.location.href = "Customer.html";
    } else {
        alert('Invalid username or password');
    }
}

// Optional: Attach login function to form submit event
document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission
    login(); // Call login function
});
