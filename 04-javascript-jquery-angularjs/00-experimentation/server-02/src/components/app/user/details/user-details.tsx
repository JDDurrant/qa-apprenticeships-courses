import * as React from 'react';

interface Props {
	component;
}

interface State {
	userDetails: {
		name: string,
		email: string
	}
}

export default class UserList extends React.Component {

	props: Props;
	state: State = {
		userDetails: {
			name: '',
			email: ''
		}
	};
	
	template = component => (
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

	render() {
		return this.template(this.props.component);
	}
}
