import axios from "../custom-axios/axios";

const LibraryService = {
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    removeBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    takeBook: (id) => {
        return axios.post(`/books/take-book/${id}`);
    },
    addBook: (name, genreId, authorId, availableCopies) => {
        return axios.post("/books/add", {
            name: name,
            genreId: genreId,
            authorId: authorId,
            availableCopies: availableCopies,
        });
    },
    editBook: (id, name, genreId, authorId, availableCopies) => {
        return axios.post("/books/add", {
            id: id,
            name: name,
            genreId: genreId,
            authorId: authorId,
            availableCopies: availableCopies,
        });
    },
    getBooksPaging: (page, size) => {
        return axios.get("/books", {
            params: {
                page: page,
                size: size,
            },
        });
    },
};

export default LibraryService;
