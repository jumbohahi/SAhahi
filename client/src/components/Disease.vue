<template>
  <v-container>
    <!-- <v-app-bar app color="blue darken-2" dark>
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>ระบบจัดการโรคติดต่อ</v-toolbar-title>
    </v-app-bar> -->
     <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="80%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบเก็บข้อมูลโรคติดต่อ</v-toolbar-title>

              </v-toolbar>

              <v-card-text>
                <v-form>
                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="ชื่อพยาบาล"
                              outlined
                              v-model="disease.personnelId"
                              :items="personnel"
                              item-text="personnelName"
                              item-value="personnelId"
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-col cols="12">
                    <v-text-field
                            label="กรอกชื่อโรค"
                            name="name"
                            type="text"
                            v-model="disease.diseaseName"
                    ></v-text-field>
                  </v-col>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="เลือกประเภทของโรคติดต่อ"
                              outlined
                              v-model="disease.typeId"
                              :items="type"
                              item-text="type"
                              item-value="typeid"
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="เลือกอัตราการติดต่อ"
                              outlined
                              v-model="disease.rateId"
                              :items="rate"
                              item-text="rate"
                              item-value="rateid"
                      ></v-select>
                    </v-col>
                  </v-row>

                  <v-row>
                    <v-col cols="12">
                      <v-select
                              label="เลือกอาการของโรค"
                              outlined
                              v-model="disease.symptomId"
                              :items="symptom"
                              item-text="symptom"
                              item-value="symptomid"
                      ></v-select>
                    </v-col>
                  </v-row>

                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="error" @click="deleteDisease">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="saveDisease">บันทึกข้อมูล</v-btn>
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
// eslint-disable-next-line no-unused-vars
export default {
  name: "disease",
  data() {
    return {
      disease: {
        personnelId: "",
        typeId:"",
        rateId: "",
        symptomId: "",
        diseaseName: "",
      },
      personnel:[],
      type:[],
      rate:[],
      symptom:[],

    };
  },
  methods: {
    /* eslint-disable no-console */
     /* eslint-disable */
    getcreatePersonnel() {
      http
        .get("/personnel")
        .then(response => {
          console.log(response.data);
          this.$forceUpdate();
          this.personnel = response.data;
          
        })
        .catch(e => {
          console.log(e);
        });
    },

    getCreatType() {
      http
        .get("/type")
        .then(response => {
          console.log(response.data);
          this.$forceUpdate();
          this.type = response.data;
          
        })
        .catch(e => {
          console.log(e);
        });
    },

    getCreatRate() {
      http
        .get("/rate")
        .then(response => {
          this.$forceUpdate();
          this.rate = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    getSymptom() {
      http
        .get("/symptom")
        .then(response => {
          this.$forceUpdate();
          this.symptom = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveDisease() {
      console.log(this.disease.personnelId)
      console.log(this.disease.diseaseName)
      console.log(this.disease.typeId)
      console.log(this.disease.symptomId)
      console.log(this.disease.rateId)
      http
        .post(
          ///Disease/add/{diseasename}/{personnelid}/{typeid}/{symptomid}/{rateid}
            "/Disease/" +
            this.disease.diseaseName +
            "/" +
            this.disease.personnelId +
            "/" +
            this.disease.typeId +
            "/" +
            this.disease.symptomId +
            "/" +
            
            this.disease.rateId,
            this.disease
        )
        .then(response => {
          console.log(response);
          alert('เพิ่มข้อมูลสำเร็จ');
          this.disease.diseaseName = " "
            this.disease.personnelId  = " "
            this.disease.typeId  = " "
            this.disease.symptomId  = " "
            this.disease.rateId  = " "
            this.disease = " "
        })
        .catch(e => {
          console.log(e);
          alert('ไม่สามารถเพิ่มข้อมูลได้');
        });
      this.submitted = true;
    },
    deleteDisease() {
      this.disease.diseaseName = ''
            this.disease.personnelId  = ''
            this.disease.typeId  = ''
            this.disease.symptomId  = ''
            this.disease.rateId  = ''
            this.disease = ''
      
      },
  },
  mounted() {
    this.getcreatePersonnel();
    this.getCreatType();
    this.getCreatRate();
    this.getSymptom();
  }
};
</script>
