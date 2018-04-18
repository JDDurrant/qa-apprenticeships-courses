const simpleEncryptor = require('simple-encryptor');
const express = require('express');

const app = express();

app.get('/', function (req, res, next) {
    res.send('Hello, World!');
});

app.get('/encrypted-json', (req, res, next) => {
    const encryptor = simpleEncryptor('P@$$w0rd!123456789');

    const data = encryptor.encrypt([
        {
            name: 'User 1',
            email: 'user1@example.com'
        },
        {
            name: 'User 2',
            email: 'user2@example.com'
        },
        {
            name: 'User 3',
            email: 'user3@example.com'
        }
    ]);

    res.send(data);
})

app.listen(3000, function() {
    console.log('Listening on http://localhost:3000...');
});