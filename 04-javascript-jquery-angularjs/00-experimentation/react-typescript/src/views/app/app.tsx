import * as React from 'react';
import './app.css';

import logo from './res/logo.svg';

export default class App extends React.Component {
	public render() {
		return (
			<div className="app">
				<header className="app-header">
					<img src={logo} className="app-logo" alt="React.js logo" />
					<h1 className="app-title">Welcome to React</h1>
				</header>
				<p className="app-intro">
					To get started, edit <code>src/views/app/app.tsx</code> and save to reload.
				</p>
			</div>
		);
	}
}
