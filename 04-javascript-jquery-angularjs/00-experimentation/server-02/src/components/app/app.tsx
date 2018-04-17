import * as React from 'react';

import styles from './app.css';

export default class App extends React.Component {
    render() {
        return (
            <div className="app">
                <h1>Hello, World!</h1>
                <button onClick={this.message}>Click me!</button>
                <noscript>
                    This site is set up to work without JavaScript. However, for the best experience, we encourage you to enable JavaScript for this website.
                </noscript>
            </div>
        );
    }

    message() {
        alert('Clicked');
    }
}
