import { makeStyles, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from "@material-ui/core";
import React, { useEffect, useState } from "react";
import LibraryService from "repository/libraryRepository";
import "./Categories.css";

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

const Categories = () => {
    const classes = useStyles();
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        LibraryService.fetchCategories().then((data) => {
            setCategories(data.data);
        });
    });

    const categoriesInTable = (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell align="left">Name</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {categories.map((category) => (
                        <TableRow key={category?.name}>
                            <TableCell component="th" scope="row">
                                {category?.name}
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
    return <div className="Categories">{categoriesInTable}</div>;
};

export default Categories;
