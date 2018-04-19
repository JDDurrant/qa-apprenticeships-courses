var Joi = require('joi');

exports.schema = Joi.object().keys({
    name: Joi.string().max(30).required().error(new Error("Please provide your name in the 'Name' field.")),
    email: Joi.string().email().required().error(new Error("A valid email address is required.")),
    message: Joi.string().required().error(new Error("Please type your message in the 'Message' field."))
});