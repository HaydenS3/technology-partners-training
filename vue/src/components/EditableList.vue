<template>
  <div>
    <h3>This creates an editable todo list!</h3>
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.text }}
        <button v-on:click="remove(item)">X</button>
      </li>
    </ul>
    <input v-on:keyup.enter="add()" v-model="newItem" />
    <button v-on:click="add()">Add</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "EditableList",
  data() {
    return {
      items: [
        { text: "Learn JavaScript" },
        { text: "Learn Vue" },
        { text: "Build something awesome" },
      ],
      newItem: "",
    };
  },
  mounted() {
    axios
      .get("http://localhost:8081/data/recipe?index=1")
      .then((response) => console.log(response));
  },
  methods: {
    add: function () {
      this.items.push({ text: this.newItem });
      this.newItem = "";
    },
    remove: function (item) {
      let index = this.items.indexOf(item);
      if (index > -1) {
        this.items.splice(index, 1);
      }
    },
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  text-align: left;
  list-style: decimal;
  padding-left: 40vw;
}
li {
  padding: 5px;
  margin: 0 10px;
}
</style>