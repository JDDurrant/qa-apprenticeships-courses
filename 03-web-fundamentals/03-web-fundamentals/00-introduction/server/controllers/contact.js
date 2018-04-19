var Joi = require('joi');

var model = require('../models/contact');

exports.submit = (req, res, next) => {
    console.log(req.body);

    const validation = Joi.validate(req.body, model.schema);
    console.log(validation);

    validation.then(store(res));

    validation.catch(error(res));
};

const store = res => value => {
    console.log(value);

    res.json({
        message: "Message submitted.",
        valid: true
    });
};

const error = res => error => {
    console.log(error);

    res.json({
        message: error.message,
        valid: false
    });
};
