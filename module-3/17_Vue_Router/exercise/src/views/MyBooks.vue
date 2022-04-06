<template>
  <div>
      <reading-list/>
      <nav>
          <router-link to="/addBook">Add Book to Reading List</router-link>
      </nav>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
    components: {
        ReadingList
    }
}
</script>

<style>

</style>