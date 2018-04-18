const jss = require('jss').default;
const preset = require('jss-preset-default');

const styles = {
    app: {
        background: '#0ff',
        color: '#222'
    },
    button: {
        background: '#fff',
        border: '1px solid #00f'
    }
};

const stylesheet = jss.createStyleSheet(styles);
const { classes, renderer } = stylesheet;

console.log(stylesheet);
console.log(classes);
console.log(renderer.toString());
console.log(stylesheet.toString());