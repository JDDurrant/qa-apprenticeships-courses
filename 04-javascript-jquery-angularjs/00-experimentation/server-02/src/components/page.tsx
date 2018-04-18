import * as React from 'react';

import App from './app/app';

export default class Page extends React.Component {
	render() {
		return (
			<html>
				<head>
					<meta charSet="utf-8" />
					<meta name="viewport" content="width=device-width, initial-scale=1.0" />
					<title>Hello, World!</title>
					<link rel="stylesheet" href="/res/css/main.css" />
					<script src="/res/js/client.js" />
				</head>
				<body>
					<App />
				</body>
			</html>
		);
	}
}
