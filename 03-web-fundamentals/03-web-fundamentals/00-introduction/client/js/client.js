import Contact, * as contact from './modules/contact.js';
import Customers, * as customers from './modules/customers.js';

const app = angular.module('app', []);

app.controller('Contact', Contact);
app.controller('Customers', Customers);

$(() => {
    // $('#contact-form').submit(contact.submit);
    $('#contact-submit-message').click(Contact.dismissMessage);
    $('#customer-list-button').click(customers.list);
    $('#customer-list-londoners-button').click(customers.listLondoners);
});
