var model = require('../models/customer');

exports.list = (req, res, next) => {
    const customers = model.list;
    const names = [];

    customers.forEach(customer => {
        names.push(customer.ContactName);
    });

    let response = "<ul>";
    names.forEach(name => {
        response += `<li>${name}</li>`;
    });
    response += "</ul>";

    res.send(response);
};

exports.api = (req, res, next) => {
    res.send(model.list);
};