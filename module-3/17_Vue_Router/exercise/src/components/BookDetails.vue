<template>
  <div>
    <h1 class="book-title">{{ book.title }}</h1>
    <h2 class="book-author">{{ book.author }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <p>{{book.read ? "I have read this book" : "I have not read this book" }}</p>
  </div>
</template>

<script>

export default {
  
  computed: {
      book() {
      return this.$store.state.books.filter((book) => {
        return book.isbn === this.$route.params.isbn;
      })[0];
      }
  },
}
</script>

<style>

</style>