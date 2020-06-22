<template>
  <v-app>
    
   <Navbar/>
   <v-container>
        <router-view>
          
        </router-view>
  </v-container>
  </v-app>
</template>

<script>
import Navbar from './components/Navbar'
//import Form from './components/Form'
export default {
  name: 'App',

  components: {
    Navbar
    
  },

  data: () => ({
    //
  }),
};
</script>
