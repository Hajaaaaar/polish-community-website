document.getElementById('proceedBtn').addEventListener('click', function () {
    const name = document.getElementById('name').value;
    const gender = document.getElementById('gender').value;
    const email = document.getElementById('email').value;
    const dob = document.getElementById('dob').value;
    const date = document.getElementById('date').value;

    if (!name || !gender || !email || !dob || !date) {
        alert('Please fill in all your details before proceeding.');
        return;
    }

    document.getElementById('details-section').style.display = 'none';
    document.getElementById('questionnaire-section').style.display = 'block';
});
