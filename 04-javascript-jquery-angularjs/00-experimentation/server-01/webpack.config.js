const webpack = require('webpack');

module.exports = {
	entry: './client/src/app.jsx',
	output: {
		path: './client/bin',
		filename: 'client.js'
	}
};
