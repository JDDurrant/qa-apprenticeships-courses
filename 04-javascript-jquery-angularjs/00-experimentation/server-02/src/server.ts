import * as express from 'express';
import * as react from 'react-engine';

import router from './router';

process.chdir(__dirname);

const app = express();

app.engine('js', react.server.create());

app.set('views', './components');

app.use('/res', express.static('../public'));
app.use(router);

app.listen(8080, () => {
    console.log('Listening on http://localhost:8080...');
});
