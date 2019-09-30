<template>
  <v-container>
    <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบจัดการโรคติดต่อ</v-toolbar-title>
    </v-app-bar>
    <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบบันทึกข้อมูลผู้ปฏิบัติงาน</v-toolbar-title>

              </v-toolbar>
              <v-card-text>
              <v-form>
              <v-row>
              <v-col cols="3">
                <v-combobox
                  label="เลือกคำนำหน้าชื่อ"
                  outlined
                  v-model="personnel.prefixId"
                  :items="prefixs"
                  item-text="prefixName"
                  item-value="prefixId"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-combobox>
              </v-col>
              </v-row>
                  <v-col cols="12">
                    <v-text-field
                      label="ชื่อ-นามสกุล"
                      name="name"
                      type="text"
                      v-model="personnel.personnelName"
                      :rules="[(v) => !!v || 'Please fill in the information']"
                  required
                    ></v-text-field>
                  </v-col>
                
              <v-row>
              <v-col cols="12">
                <v-combobox
                  label="เลือกตำแหน่ง"
                  outlined
                  v-model="personnel.positionId"
                  :items="positions"
                  item-text="positionName"
                  item-value="positionId"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-combobox>
              </v-col>
              </v-row>

              <v-row>
              <v-col cols="12">
                <v-combobox
                  label="เลือกแผนก"
                  outlined
                  v-model="personnel.departmentId"
                  :items="departments"
                  item-text="departmentName"
                  item-value="departmentId"
                  :rules="[(v) => !!v || 'Item is required']"
                  required
                ></v-combobox>
              </v-col>
              </v-row>

                  <v-col cols="12">
                    <v-text-field
                      label="หน้าที่"
                      name="role"
                      type="text"
                      v-model="personnel.personnelRole"
                      :rules="[(v) => !!v || 'Please fill in the information']"
                  required
                    ></v-text-field>
                  </v-col>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="error">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="savePersonnel(personnel.value)">Save</v-btn>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-responsive>
      </div>
    </v-container>
  </v-container>
</template>

 <script>
//import controller from "../controller/controller";
/* eslint-disable */
import http from '../http-common';

export default {
  name: "personnels",
  data() {
    return {
      personnel:{
        prefixId: "",
        personnelName: "",       
        positionId: "",
        departmentId: "",
        personnelRole: "",
        
      },
      prefixs: [],
      positions: [],
      departments: []
    };
  },
  methods: {
    getPrefixs(){
      http
        .get("/Prefix")
        .then(response => {
          this.prefixs = response.data;
          console.log(this.prefixs);
        })
        .catch(e => {
          console.log(e);
        });
  },
    getPositions(){
      http
        .get("/Positions")
        .then(response => {
         this.positions = response.data;
         console.log(this.positions);
        })
        .catch(e => {
          console.log(e);
        });
    
  },
    getDepartments(){
      http
        .get("/Department")
        .then(response => {
          this.departments = response.data;
          console.log(this.departments);
        })
        .catch(e => {
          console.log(e);
        });
    
  },
   savePersonnel(value) {
     console.log(value)
      http
        .post(
        "/Personnels/add/" ,{value}
            // this.personnel.prefixId +
            // "/" +
            // this.personnel.personnelName +
            // "/" +
            // this.personnel.positionId +
            // "/" +
            // this.personnel.departmentId+
            // "/" +
            // this.personnel.personnelRole,
          //this.personnel
        )
        
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    Clear() {
      this.$refs.form.reset();
     
    },
  },
    mounted() {
    this.getPrefixs();
    this.getPositions();
    this.getDepartments();
  }
  
};
</script>
