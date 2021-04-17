import "./App.css";
import { Route, Switch } from "react-router-dom";
import React from "react";
import Layout from "components/Layout/Layout";
import Books from "components/Books/Books";
import Categories from "components/Categories/Categories";
import LandingPage from "components/LandingPage/LandingPage";

function App() {
    return (
        <Layout>
            <Switch>
                <Route path="/books" component={Books} />
                <Route path="/categories" component={Categories} />
                <Route path="/" exact component={LandingPage} />
            </Switch>
        </Layout>
    );
}

export default App;
