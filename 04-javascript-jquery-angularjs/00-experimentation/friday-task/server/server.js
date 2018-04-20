process.chdir(__dirname);
const bodyParser = require('body-parser');
const express = require('express');

const router = require('./router');

const app = express();

app.use(bodyParser.json());
app.use(express.static('../client'));
app.use(router);

app.listen(3000, () => {
    console.log('Listening on http://localhost:3000...');
});