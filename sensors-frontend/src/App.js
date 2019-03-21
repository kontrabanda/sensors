import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      text: 'test test test4'
    };
  }

  componentDidMount() {
    fetch("/api/hello")
        .then(res => res.json())
        .then(
            (result) => {
              this.setState({
                text: result.text
              });
            },
            (error) => {
              this.setState({
                text: 'Error9!'
              });
            }
        )
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <span>
            {this.state.text}
          </span>
        </header>
      </div>
    );
  }
}

export default App;
