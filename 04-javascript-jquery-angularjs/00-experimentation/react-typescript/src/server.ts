import * as express from 'express';
import jsx = require('express-react-engine');

process.chdir(__dirname);

const app = express();

app.set('views', './views');
app.engine('jsx', jsx());

app.get('/', (req: express.Request, res: express.Response, next: Function) => {
	res.render('page.jsx');
});

app.listen(3000, () => {
    console.log('Listening on http://localhost:3000...');
});
