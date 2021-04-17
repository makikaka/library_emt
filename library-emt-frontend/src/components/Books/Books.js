import { Button, makeStyles, Paper, Table, TableBody, TableCell, TableContainer, TableFooter, TableHead, TableRow } from "@material-ui/core";
import React, { useEffect, useState } from "react";
import LibraryService from "repository/libraryRepository";
import { TablePagination } from "@material-ui/core";
import "./Books.css";
import TablePaginationActions from "@material-ui/core/TablePagination/TablePaginationActions";

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

const Books = () => {
    const classes = useStyles();
    const [books, setBooks] = useState([]);
    const [numBooks, setNumBooks] = useState(11);

    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(2);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
        handleChangePagination(rowsPerPage, page);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
        handleChangePagination(rowsPerPage, page);
    };

    const handleChangePagination = (numRows, pageNum) => {
        LibraryService.getBooksPaging(pageNum, numRows).then((data) => {
            setBooks(data?.data?.pageBook);
            setNumBooks(data?.data?.bookCount);
        });
    };

    const deleteBook = (id) => {
        LibraryService.removeBook(id);
        handleChangePagination(rowsPerPage, page)
    };

    const takeBook = (id) => {
      LibraryService.takeBook(id);
      handleChangePagination(rowsPerPage, page)
  };

    useEffect(() => {
        handleChangePagination(rowsPerPage, page);
    });

    const booksInTable = (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell align="left">Name</TableCell>
                        <TableCell align="right">Author</TableCell>
                        <TableCell align="right">Genre</TableCell>
                        <TableCell align="right">Available copies</TableCell>
                        <TableCell align="right">Actions</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {books.map((book) => (
                        <TableRow key={book?.name}>
                            <TableCell component="th" scope="row">
                                {book?.name}
                            </TableCell>
                            <TableCell align="right">{`${book?.author?.name} ${book.author?.surname}`}</TableCell>
                            <TableCell align="right">{book?.genre?.name}</TableCell>
                            <TableCell align="right">{book?.available_copies}</TableCell>
                            <TableCell align="right">
                                <Button color="primary">Add</Button>
                                <Button>Edit</Button>
                                <Button
                                    color="secondary"
                                    onClick={() => {
                                        deleteBook(book?.id);
                                    }}
                                >
                                    Delete
                                </Button>
                                <Button color="primary" variant="outlined" onClick={() => {
                                        takeBook(book?.id);
                                    }}>Take book</Button>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            rowsPerPageOptions={[2, 4, 8, 16, { label: "All", value: -1 }]}
                            colSpan={3}
                            count={numBooks}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            SelectProps={{
                                inputProps: { "aria-label": "rows per page" },
                                native: true,
                            }}
                            onChangePage={handleChangePage}
                            onChangeRowsPerPage={handleChangeRowsPerPage}
                            ActionsComponent={TablePaginationActions}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
    return <div className="Books">{booksInTable}</div>;
};

export default Books;
