<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <Greeting />
    <HelloWorld />
    <UserList />
    <UserInput />
    <CounterButton />
    <TicTacToe />
    <EditableList />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import UserList from "./components/UserList.vue";
import UserInput from "./components/UserInput.vue";
import CounterButton from "./components/CounterButton.vue";
import TicTacToe from "./components/TicTacToe.vue";
import Greeting from "./components/Greeting.vue";
import EditableList from "./components/EditableList.vue";

export default {
  name: "App",
  components: {
    HelloWorld,
    UserList,
    UserInput,
    CounterButton,
    TicTacToe,
    Greeting,
    EditableList,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
