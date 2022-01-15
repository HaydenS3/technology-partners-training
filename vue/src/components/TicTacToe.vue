<template>
  <div>
    <h3>TicTacToe</h3>
    <!--<Board />-->
  </div>
</template>

<script>
import Board from "../components/Board.vue";

export default {
  name: "TicTacToe",
  components: Board,
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
</style>