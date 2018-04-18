module.exports = {
	entry: './src/components/client.tsx',
	module: {
		rules: [
			{
				test: /\.tsx?$/,
				use: 'ts-loader',
				exclude: /node_modules/
			}
		]
	},
	resolve: {
		extensions: ['.tsx', '.ts', '.js']
	},
	output: {
		filename: 'client.js',
		// path: path.resolve(__dirname, 'public')
		path: `${__dirname}/public/js`
	}
};
