const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {lists: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/Listings'}).done(response => {
			this.setState({lists: response.entity._embedded.listings});
		});
	}

	render() {
		return (
			<ListingsList lists={this.state.lists}/>
		)
	}
}

class ListingsList extends React.Component{
	render() {
		const lists = this.props.lists.map(employee =>
			<Listings key={listings._links.self.href} listings={listings}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{lists}
				</tbody>
			</table>
		)
	}
}