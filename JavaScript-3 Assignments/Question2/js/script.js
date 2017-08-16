var username = document.getElementById('username');
var email = document.getElementById('useremail');
var city = document.getElementById('usercity');
var organisation = document.getElementById('userorg');
var contact = document.getElementById('usercontact');
var message = document.getElementById('usermessage');

/**
 * Store the data of corrosponding fields in the local storage.
 */
function setData() {
    localStorage.setItem('name', username.value);
    localStorage.setItem('email', email.value);
    localStorage.setItem('city', city.value);
    localStorage.setItem('organisation', organisation.value);
    localStorage.setItem('contact', contact.value);
    localStorage.setItem('message', message.value);
    // Reset all the fields.
    username.value = '';
    email.value = '';
    city.value = 'city';
    organisation.value = '';
    contact.value = '';
    message.value = '';

}

/**
 * Clear all the data from the local storage.
 */
function clearData() {
    localStorage.clear();
    username.value = '';
    email.value = '';
    city.value = 'city';
    organisation.value = '';
    contact.value = '';
    message.value = '';
}

/**
 * Sets the value of each field with the values stored in the local storage
 * whenever the page is refreshed.
 */
window.onload = function () {
    username.value = localStorage.getItem('name');
    email.value = localStorage.getItem('email');
    city.value = localStorage.getItem('city');
    organisation.value = localStorage.getItem('organisation');
    contact.value = localStorage.getItem('contact');
    message.value = localStorage.getItem('message');
    document.getElementById('save').addEventListener('click', setData);
    document.getElementById('clear').addEventListener('click', clearData);
}
