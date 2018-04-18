const express = require('express');
const jsx = require('express-react-engine');

const app = express();

app.set('views', '../client/components');
app.engine('jsx', jsx());

app.get('/test', (req, res, next) => {
    res.render('page.jsx');
});

app.use('/', express.static('../client'));

app.listen(3000, () => {
    console.log('Listening on localhost:3000...');
});
