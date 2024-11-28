function validateEmail(email) {
    // Use a more robust regular expression to handle various email formats
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function validatePhoneNumber(phoneNum) {
    // Consider international phone number formats and potential validation libraries
    // For a basic US phone number format:
    let phoneRegex = /^\d{10}$/;
    return phoneRegex.test(phoneNum);
}

function submitFunction() {

    let fullName = document.getElementById('fullName');
    let emailAddress = document.getElementById('emailAddress');
    let phoneNumber = document.getElementById('phoneNumber');

    if (
         fullName.value.trim() !== null &&
        validateEmail(emailAddress.value) &&
        phoneNumber.value !== null &&
        validatePhoneNumber(phoneNumber.value)
    ) {
        alert('Your details have successfully got registered!');
    } else {

        if (fullName.value.trim()==='') {
            alert('Please enter your full name.');
        } else if (!validateEmail(emailAddress.value)) {
            alert('Please enter a valid email address.');
        } else if (phoneNumber.value===null) {
            alert('Please enter your phone number.');
        } else if (!validatePhoneNumber(phoneNumber.value)) {
            alert('Please enter a valid phone number.');
        } else {
            alert('Oops, something went wrong. Please try again.');
        }
    }
}
