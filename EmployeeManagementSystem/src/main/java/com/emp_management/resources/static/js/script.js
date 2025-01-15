let sessionMessage = sessionStorage.getItem('msg');

if (sessionMessage) {
    let alertDiv = document.getElementById('alert');
    alertDiv.innerText = sessionMessage;
    alertDiv.style.display = 'block'; // Show the alert

    // Remove the message after displaying
    sessionStorage.removeItem('msg'); // Clean up
    setTimeout(() => {
        alertDiv.style.display = 'none'; // Hide after 3 seconds
    }, 3000);
}