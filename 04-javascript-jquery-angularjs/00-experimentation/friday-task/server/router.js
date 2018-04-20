const express = require('express');

const attractions = require('./models/attractions');
const buildings = require('./models/buildings');

const router = express.Router();

router.get('/attractions', (req, res, next) => {
    res.json(attractions);
});

router.get('/buildings', (req, res, next) => {
    res.json(buildings);
});

module.exports = router;