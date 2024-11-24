const fullName = document.getElementById('fullName');
const emailAddress = document.getElementById('emailAddress');
const phoneNumber = document.getElementById('phoneNumber');

function validateEmail(email) {
    // Use a more robust regular expression to handle various email formats
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePhoneNumber(phoneNum) {
    // Consider international phone number formats and potential validation libraries
    // For a basic US phone number format:
    const phoneRegex = /^\d{10}$/;
    return phoneRegex.test(phoneNum);
}

// function submitFunction() {
//     if (
//         fullName.value.trim() !== '' &&
//         validateEmail(emailAddress.value) &&
//         phoneNumber.value.trim() !== '' &&
//         validatePhoneNumber(phoneNumber.value)
//     ) {
//         alert('Your details have successfully got registered!');
//     } else {
//         alert('Oops, you might have provided invalid details. Please check your input.');
//     }
// }

function submitFunction(event) {
    event.preventDefault(); // Prevents the form from submitting and refreshing the page

    if (
        fullName.value.trim() !== '' &&
        validateEmail(emailAddress.value) &&
        phoneNumber.value.trim() !== '' &&
        validatePhoneNumber(phoneNumber.value)
    ) {
        alert('Your details have successfully got registered!');
    } else {
        // Provide more specific error messages based on validation failures
        if (!fullName.value.trim()) {
            alert('Please enter your full name.');
        } else if (!validateEmail(emailAddress.value)) {
            alert('Please enter a valid email address.');
        } else if (!phoneNumber.value.trim()) {
            alert('Please enter your phone number.');
        } else if (!validatePhoneNumber(phoneNumber.value)) {
            alert('Please enter a valid phone number.');
        } else {
            alert('Oops, something went wrong. Please try again.');
        }
    }
}
