import * as $ from 'jquery';
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
				This site is set up to work without JavaScript. However, for the best experience, we encourage you to enable JavaScript for this website.
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
		return this.template(this);
	}

	// Client
	message() {
		alert('Clicked');
	}

	listUsers(event) {
		event.preventDefault();
		
		const $users = $.get('/api/users');
		$users.done(users => {
			this.setState({
				users: users
			});
		});
	}

	userDetails(index, event) {
		event.preventDefault();
		
		const $user = $.get(`/api/user/${index}`);
		$user.then(user => {
			this.setState({
				userDetails: user
			});
		});
	}
}
