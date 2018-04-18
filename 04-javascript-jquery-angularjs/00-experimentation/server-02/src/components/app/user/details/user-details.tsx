import * as React from 'react';

interface Props {
    component;
}

export default class UserList extends React.Component {
    
    template = component => (
        <div className="app_user-details">
            <h2>User details</h2>
            <table>
                <tr>
                    <td>Name:</td>
                    <td>{component.state.userDetails.name}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <a href={"mailto:" + component.state.userDetails.email}>
                            {component.state.userDetails.email}
                        </a>
                    </td>
                </tr>
            </table>
        </div>
    );

    props: Props;

    render() {
        return this.template(this.props.component);
    }
}
