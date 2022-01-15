<template>
  <div>
    <h1>{{ greeting }}</h1>
  </div>
</template>

<script>
export default {
  name: "Greeting",
  data() {
    return {
      greeting: "Hello! You loaded this page on " + new Date().toLocaleString(),
    };
  },
};
</script>

<style scoped>
h1 {
  margin: 40px 0 0;
}
</style>