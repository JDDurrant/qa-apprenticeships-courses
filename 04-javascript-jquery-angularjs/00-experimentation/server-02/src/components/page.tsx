import * as React from 'react';

import App from './app/app';

export default class Page extends React.Component {
	render() {
		return (
			<html>
				<head>
					<meta charSet="utf-8" />
					<title>Hello, World!</title>
					<script src="/res/client.js" />
				</head>
				<body>
					<App />
				</body>
			</html>
		);
	}
}
