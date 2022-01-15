<template>
  <div>
    <h3>This creates a list of users!</h3>
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.firstname }} {{ user.lastname }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "UserList",
  data() {
    return {
      users: [
        { firstname: "Hayden", lastname: "Schroeder" },
        { firstname: "Spence", lastname: "Lamber" },
        { firstname: "Lauren", lastname: "Wagner" },
      ],
    };
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
</style>