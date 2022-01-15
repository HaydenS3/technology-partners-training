<template>
  <div>
    <h3>Creates a counter button</h3>
    <button v-on:click="counter++">
      I've been clicked {{ counter }} times!
    </button>
  </div>
</template>

<script>
export default {
  name: "CounterButton",
  data() {
    return {
      counter: 0,
    };
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
</style>