import * as React from 'react';

interface Props {
    component;
}

export default class UserList extends React.Component {
    
    template = component => (
        <div className="app_users-list">
            <ul id="app_users-list_ul">
                {component.state.users.map((user, index) => {
                    return (
                        <li>
                            <a
                                href={`/api/user/${index}`}
                                onClick={component.userDetails.bind(component, index)}
                            >{user.name}</a>
                        </li>
                    );
                })}
            </ul>
        </div>
    );

    props: Props;

    render() {
        return this.template(this.props.component);
    }
}
