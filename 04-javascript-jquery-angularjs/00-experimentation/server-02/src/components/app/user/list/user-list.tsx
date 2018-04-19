import axios from 'axios';
import * as React from 'react';

import Props from './user-list.props';
import State, { defaultState } from './user-list.state';

export default class UserList extends React.Component {

	props: Props;
	state: State = defaultState;
	
	template = component => (
		<div className="app_users-list">
			<a href="/api/users" onClick={this.listUsers.bind(this)}>List users</a>
			{this.list}
			<h2>User Details</h2>
			{this.table()}
		</div>
	);

	get list() {
		return (
			<ul id="app_users-list_ul">
				{this.state.users.map((user, index) => {
					return (
						<li>
							<a
								href={`/api/user/${index}`}
								onClick={this.userDetails.bind(this, index)}
							>{user.name}</a>
						</li>
					);
				})}
			</ul>
		);
	}

	table = () => (
		<table>
			<tr>
				<td>Name:</td>
				<td>{this.state.userDetails.name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>
					<a href={"mailto:" + this.state.userDetails.email}>
						{this.state.userDetails.email}
					</a>
				</td>
			</tr>
		</table>
	);

	listUsers(event) {
		event.preventDefault();
		
		const request = axios.get('/api/users');
		request.then(response => this.setState({ users: response.data }));
	}

	userDetails(index, event) {
		event.preventDefault();
		
		const request = axios.get(`/api/user/${index}`);
		request.then(response => this.setState({ userDetails: response.data }));
	}

	render() {
		return this.template(this.props.component);
	}
}
