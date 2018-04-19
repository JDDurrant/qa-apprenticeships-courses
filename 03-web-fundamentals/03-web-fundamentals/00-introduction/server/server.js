const
bodyParser = require('body-parser'),
express = require('express'),
latency = require('express-simulate-latency'),

router = require('./router'),
contact = require('./controllers/contact');

const app = express();

// app.use(latency({ min: 5000, max: 10000 }));

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(express.static('./client'));

app.use(router);

app.listen(3000, () => {
    console.log("Listening on http://127.0.0.1:3000");
});
