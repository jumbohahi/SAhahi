<template>
  <v-app>
    <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบจัดการโรคติดต่อ</v-toolbar-title>
        <div class="flex-grow-1"></div>

      <v-toolbar-items>
        
        <v-btn text to="/personnel">บันทึกข้อมูลผู้ปฏิบัติงาน</v-btn>
        <v-btn text to="/disease">เก็บข้อมูลโรคติดต่อ</v-btn>
        <v-btn text to="/infection">ข้อมูลผู้ป่วยโรคติดต่อ</v-btn>
        <v-btn text to="/examResult">สอบถามอาการเบื้องต้น</v-btn>
        <v-btn text to="">นัดตรวจผู้ป่วยโรคติดต่อ</v-btn>
        <v-btn text to="">สถิติ</v-btn>
      </v-toolbar-items>
    </v-app-bar>

    <v-content>
      <!-- <VideoRental/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data: () => ({
    username: 'Tanapon Kongjaroensk',
  }),
};
</script>
