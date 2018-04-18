import React from 'react';

import HelloWorld from './hello-world';

class App extends React.Component {
    render() {
        return (
            <html>
                <head>
                    <title>Hello, World!</title>
                </head>
                <body>
                    <HelloWorld />
                </body>
            </html>
        );
    }
}