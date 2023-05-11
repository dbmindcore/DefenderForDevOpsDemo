import { Component } from 'react';

class Constants extends Component {
  static backendUrlBase = process.env.BACKEND_URL_BASE || "http://localhost:8080/";
  static backendRESTUrlBase = process.env.BACKEND_REST_URL_BASE || "http://localhost:8080/rest/";
  // The below URLs are the google cloud instance mentioned in the README. Changing this to the localhost deployment of Javulna
  // static backendUrlBase = "http://35.204.241.43:31337/";
  // static backendRESTUrlBase = "http://35.204.241.43:31337/rest/";
}

export default Constants;
