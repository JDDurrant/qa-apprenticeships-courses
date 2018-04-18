import users from '../models/user';

export default class User {
    static list(req, res, next) {
        res.json(users);
    }

    static details(req, res, next) {
        res.json(users[req.params.i]);
    }
}