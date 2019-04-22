const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
const root = '/api';

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {items: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/Listings'}).done(response => {
			this.setState({items: response.entity._embedded.items});
		});
	}

	render() {
		return (
			<ItemsList items={this.state.items}/>
		)
	}
}