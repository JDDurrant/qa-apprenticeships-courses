module.exports = {
	entry: './src/components/client.tsx',
	module: {
		rules: [
			{
				test: /\.tsx?$/,
				use: 'ts-loader',
				exclude: /node_modules/
			},
			{
				test: /\.css?$/,
				use: [
					{ loader: 'style-loader' },
					{ loader: 'typing-for-css-modules-loader' }
				]
			}
		]
	},
	resolve: {
		extensions: ['.tsx', '.ts', '.js']
	},
	output: {
		filename: 'client.js',
		// path: path.resolve(__dirname, 'public')
		path: `${__dirname}/public`
	}
};
