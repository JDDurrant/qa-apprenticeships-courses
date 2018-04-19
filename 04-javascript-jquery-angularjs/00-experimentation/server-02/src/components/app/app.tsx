import * as axios from 'axios';
import * as React from 'react';

import UserDetails from './user/details/user-details';
import UserList from './user/list/user-list';

export default class App extends React.Component {

	template = component => (
		<div className="app">
			<h1>Hello, World!</h1>
			<div className="app_users-link" id="app_users-link">
				<a href="/api/users" onClick={component.listUsers.bind(component)}>List users</a>
			</div>
			<UserList component={component} />
			<UserDetails component={component} />
			<button onClick={component.message}>Click me!</button>
			<noscript>
				Please enable JavaScript to enjoy the full experience of this web application.
			</noscript>
		</div>
	);

	template2 = (
		<div className="app">
			<h1>Hello, World!</h1>
			<UserList component={this} />
			<button onClick={this.message}>Click me!</button>
			<noscript>
			Please enable JavaScript to enjoy the full experience of this web application.
			</noscript>
		</div>
	);

	styles = {
		button: {
			background: '#fff',
			border: '1px solid #000'
		}
	};

	state = {
		users: [],
		userDetails: { name: '', email: '' }
	};

	render() {
		// return this.template(this);
		return this.template2;
	}

	// Client
	message() {
		alert('Clicked');
	}
}
