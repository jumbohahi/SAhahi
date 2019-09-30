<template>
  <v-app>
    <v-content>
      <!-- <VideoRental/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
import Personnel from './components/Personnel';

export default {
  name: 'App',
  // components: {
  //   Personnel,
  // },
  data: () => ({
    //
  }),
};
</script>
