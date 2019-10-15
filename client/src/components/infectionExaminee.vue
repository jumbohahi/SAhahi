<template>

    <v-container>
     <v-container>
      <div>
        <v-responsive>
          <v-flex>
            <v-card class="mx-auto" max-width="40%">
              <v-toolbar color="blue darken-2" dark flat>
                <v-toolbar-title>ระบบจัดเก็บข้อมูลผู้ป่วยโรคติดต่อ</v-toolbar-title>

              </v-toolbar>

              <v-card-text>
  <v-form class="mx-auto" max-width="80%" >
              
             
    <v-row>
     <v-col cols="12">
          <v-text-field
            label="ชื่อผู้ป่วย"
            hint="กรอกชื่อผู้ป่วย"

            required
            v-model="Patient.name"
          ></v-text-field>
        </v-col>
  </v-row>


  <v-row>
     <v-col cols="12">
          <v-text-field
            label="อายุผู้ป่วย"
            hint="กรอกอายุ"

            required
            v-model="Patient.age"
          ></v-text-field>
        </v-col>
  </v-row>

<v-row>
    <v-col cols="12">
    <v-select
        label="โปรดเลือกจังหวัด"
        outlined

         v-model="Patient.provinceid"
         :items="province"
          item-text="pro"   
         item-value="provinceid"
       
      required
    ></v-select>
    </v-col>
  </v-row>
    

  <v-row>
    <v-col cols="12">
    <v-select
        
        label="โปรดเลือกโรคที่พบ"
        outlined

        v-model="Patient.diseaseid"
       :items="disease"
       item-text="diseaseName"
       item-value="id"
       
      required
    ></v-select>
    </v-col>
  </v-row>




  <v-row>
    <v-col cols="12">
    <v-select
        
        label="โปรดเลือกชื่อพยาบาล"
        outlined

         v-model="Patient.personnelid"
         :items="personnel"
         item-text="personnelName"
          item-value="personnelId"
       
      required
    ></v-select>
    </v-col>
  </v-row>






   
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-btn color="error" @click="clear">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="savePatient">บันทึกข้อมูล</v-btn>
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
        name: "Patient",
         data() {
    return {
      Patient:{
        name: "",
        age: "",
        diseaseid: "",
        personnelid: "",
        provinceid: "",
        active: false
        },
        submitted: false,
        valid: false,
    };
  },
methods: {
   /* eslint-disable */
    getDiseases(){
      http
        .get("/disease")
        .then(response => {
          this.$forceUpdate();   //เผื่อข้อมูลไม่ขึ้นในคอมโบ
          this.disease = response.data; //
          console.log(this.disease);  //คำสั่งปริ้นว่าส่ง obj หลังบ้านออกมาหน้าบ้านได้มั้ย

        })
        .catch(e => {
          console.log(e);
        });
  },
    getPersonnels(){
      http
        .get("/personnel")
        .then(response => {
        this.$forceUpdate();
         this.personnel = response.data;
         //ไม่มี s
         console.log(response.data);
        })
       
        .catch(e => {
          console.log(e);
          alert('ไม่สามารถเพิ่มข้อมูลได้');
        });
    
  },
    getProvinces(){
      http
        .get("/pro")
        .then(response => {
          this.$forceUpdate();
          this.province = response.data;
          //ไม่ต้งเติมs เอามาแค่ชื่อ ตารางพอ
          console.log(response.data);
        })
        .catch(e => {   //แจ้งเตือน ดักจับ error
          console.log(e);
        });
    
  },
   savePatient() {
      http
        .post(
          "/pa/" +
            this.Patient.name +
            "/" +
            this.Patient.age +
            "/" +
            this.Patient.diseaseid +
            "/" +
            this.Patient.personnelid +
            "/" +
            this.Patient.provinceid,
          this.Patient
        )
    .then(response => {
          console.log(response);
          if(response = true){
            alert('บันทึกข้อมูลเสร็จสิ้น')
          } 
          this.$refs.form.reset();
       //   this.customerCheck = false;
        })
        .catch(e => {
          console.log(e);
           if(e = false){
            alert('การบันทึกข้อมูลผิดพลาด')
          }
        });
      
     
    },
   clear(){
      this.Patient.name = ''
        this.Patient.age = ''
        this.Patient.diseaseid = ''
        this.Patient.personnelid = ''
        this.Patient.provinceid = ''
    }
  },
    mounted() {
      this.getDiseases();
      this.getPersonnels();
      this.getProvinces();
  }
  
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style  scoped,lang="scss" scoped>
    .v-app-bar{
    margin-top: 1px;
    background-color:rgb(75, 73, 238)  
  }

  .v-form {
      width: 400px;
      background-color:rgb(250, 250, 250)
    }
    
  .v-btn{
      background-color:rgba(255, 255, 255)
  }
</style>