import React from "react";
import { AppBar, Box, makeStyles, Tab, Tabs, Typography } from "@material-ui/core";
import "./Layout.css";
import { useHistory } from "react-router-dom";
import { useLocation } from 'react-router-dom'

function TabPanel(props) {
    const { children, value, index, ...other } = props;

    return (
        <div role="tabpanel" hidden={value !== index} id={`simple-tabpanel-${index}`} aria-labelledby={`simple-tab-${index}`} {...other}>
            {value === index && (
                <Box p={3}>
                    <Typography>{children}</Typography>
                </Box>
            )}
        </div>
    );
}

function a11yProps(index) {
    return {
        id: `simple-tab-${index}`,
        "aria-controls": `simple-tabpanel-${index}`,
    };
}

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        backgroundColor: theme.palette.background.paper,
    },
}));

const Layout = (props) => {
    const location = useLocation();
    const selectedTab = location.pathname.includes("books") ? 1 :
    location.pathname.includes("categories") ? 2 :
    location.pathname.includes("home") ? 0 : 0

    const classes = useStyles();
    const [value, setValue] = React.useState(selectedTab);
    const history = useHistory();

    const handleChange = (event, newValue) => {
        setValue(newValue);
        if (newValue === 1) {
            history.push("/books");
        } else if (newValue === 2) {
            history.push("/authors");
        } else if (newValue === 3) {
            history.push("/categories");
        } else {
            history.push("/");
        }
    };

    return (
        <div>
            <div className={classes.root}>
                <AppBar position="static">
                    <Tabs centered value={value} onChange={handleChange} aria-label="simple tabs example">
                        <Tab label="Home" {...a11yProps(0)} />
                        <Tab label="Books" {...a11yProps(1)} />
                        <Tab label="Authors" disabled {...a11yProps(2)} />
                        <Tab label="Categories" {...a11yProps(3)} />
                    </Tabs>
                </AppBar>
                <TabPanel>
                    <div className="Layout">{props.children}</div>
                </TabPanel>
            </div>
        </div>
    );
};
Layout.propTypes = {};

export default Layout;
