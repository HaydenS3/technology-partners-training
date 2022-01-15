<template>
  <div>
    <h3>{{ inputVal }}</h3>
    <input type="text" v-model="inputVal" />
  </div>
</template>

<script>
export default {
  name: "UserInput",
  data() {
    return {
      inputVal: "What if you could create your own header?",
    };
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
</style>