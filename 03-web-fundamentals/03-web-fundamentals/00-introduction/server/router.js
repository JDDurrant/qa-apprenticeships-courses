const
express = require('express'),

contact = require('./controllers/contact'),
customer = require('./controllers/customer');

var router = express.Router();

router.get('/customers', customer.list);
router.get('/api/customers', customer.api);

router.post('/contact', contact.submit);

module.exports = router;