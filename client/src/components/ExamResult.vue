<template>
  <v-container>
     <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบสอบถามอาการเบื้องต้น</v-toolbar-title>

              </v-toolbar>

              <v-card-text>
                <v-form>
                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อคนไข้"
                              outlined
                              v-model="patientId"
                              :items="patients"
                              item-text="name"
                              item-value="paid"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>
                     <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อพยาบาล"
                              outlined
                              v-model="personnelId"
                              :items="personnels"
                              item-text="personnelName"
                              item-value="personnelId"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>
                  <v-col cols="12">
                    <v-text-field
                            label="Examresult"
                            name="name"
                            type="text"
                            v-model="examresults"
                            :rules="[(v) => !!v || 'Please fill in the information']"
                            required
                    ></v-text-field>
                  </v-col>

                 

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ระยะเวลา"
                              outlined
                              v-model="periodId"
                              :items="periods"
                              item-text="periodName"
                              item-value="id"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
                    </v-col>
                  </v-row>

              

                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="error" @click="clear">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="addDocument">บันทึกข้อมูล</v-btn>
              </v-card-actions>

            </v-card>
          </v-flex>
        </v-responsive>
      </div>
    </v-container>
  </v-container>
</template>

<script>
import http from "../http-common";


export default {
  name: "document",
  data() {
    return {
        personnelId: "",
        patientId:"",
        periodId: "",
        examresults: "",

      patients:[],
      personnels:[],
      periods:[],


    };
  },
 methods: {                                          //สร้าง method เพื่ออ้างอิงในการรับข้อมูล
            /* eslint-disable no-console */
             getPersonel() {
              http
                 .get("/personnel")
                 .then(response => {
                 this.personnels = response.data;
                console.log(response.data);
                })
                .catch(e => {
                console.log(e);
              });
            },
            /* eslint-disable no-console */
            getPatient() {
              http
                 .get("/pa")
                 .then(response => {
                 this.patients = response.data;
                console.log(response.data);
                })
                .catch(e => {
                console.log(e);
              });
            },
            /* eslint-disable no-console */
            getPeriod() {
              http
                 .get("/period")
                 .then(response => {
                 this.periods = response.data;
                console.log(response.data);
                })
                .catch(e => {
                console.log(e);
              });
            },
            /* eslint-disable no-console */
            addDocument() {
          http
        .post(
          "/document/" + this.patientId + "/" + this.personnelId + "/" + this.examresults + "/"
          + this.periodId)
       .then(response => {
          console.log(response);
          alert('เพิ่มข้อมูลสำเร็จ');    
        })
        .catch(e => {
          console.log(e);
          alert('ไม่สามารถเพิ่มข้อมูลได้');
        });
    },
    clear(){
      this.personnelId = ''
      this.patientId = ''
      this.periodId = ''
      this.examresults = ''
    }
        },
        mounted() {           
            this.getPatient();
            this.getPersonel();
            this.getPeriod();
        }
    };
</script>