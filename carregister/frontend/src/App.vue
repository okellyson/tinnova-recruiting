<template lang='pug'>

    v-app#app
        v-main

            v-app-bar(color="success")
                h1 Cadastro de Veículos

            v-container
                router-view

</template>

<script>

    export default {

        name: "App",

        data: () => ({})

    };

</script>

<style>

h1 {
    color: white;
}

h2 {
    color: #1B1B1B;
}

p {
    color: #2B2B2B;
}

html {
    overflow-y: auto !important;
}

#app {
    font-family: Roboto, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}

</style>