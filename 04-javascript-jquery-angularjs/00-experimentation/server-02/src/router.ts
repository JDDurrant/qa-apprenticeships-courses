import * as express from 'express';

import User from './controllers/user';

const router = express.Router();

router.get('/', (req, res, next) => {
    // res.send("Hello");
    res.render('page.js');
});

router.get('/api/users', User.list);
router.get('/api/user/:i', User.details);

export default router;
