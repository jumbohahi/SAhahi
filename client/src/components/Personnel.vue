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
                <v-toolbar-title>ระบบบันทึกข้อมูลผู้ปฏิบัติงาน</v-toolbar-title>

              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-row>
                    <v-col cols="3">
                      <v-select
                              label="เลือกคำนำหน้าชื่อ"
                              outlined
                              v-model="personnel.prefixId"
                              :items="prefixName"
                              item-text="prefixName"
                              item-value="prefixId"
                              :rules="[(v) => !!v || 'Item is required']"
                              required
                      ></v-select>
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
                              :items="positionName"
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
                              :items="departmentName"
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
                <v-btn color="error" @click="clear">Clear</v-btn>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-2" @click="savePersonnel">Save</v-btn>
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
  name: "personnel",
  data() {
    return {
      personnel: {
        prefixId: "",
        positionId: "",
        departmentId: "",
        personnelName: "",
        personnelRole: ""
      },
      prefixName: [],
      departmentName: [],
      positionName: []
    };
  },
  methods: {
    /* eslint-disable no-console */

    // ดึงข้อมูล Employee ใส่ combobox
    getPrefix() {
      http
        .get("/prefix")
        .then(response => {
          this.prefixName = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Video ใส่ combobox
    getCreatDepartment() {
      http
        .get("/department")
        .then(response => {
          this.departmentName = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล RentalType ใส่ combobox
    getCreatTravel() {
      http
        .get("/position")
        .then(response => {
          this.positionName = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    savePersonnel() {
      console.log(this.personnel)
      http
        .post(
          "http://localhost:9000/personnel/" +
            this.personnel.prefixId +
            "/" +
            this.personnel.positionId.positionId +
            "/" +
            this.personnel.departmentId.departmentId,
                {
                  personnelName: this.personnel.personnelName,
                  personnelRole: this.personnel.personnelRole
                }
        )
        .then(response => {
          console.log(response);
          alert('เพิ่มข้อมูลสำเร็จ');
        })
        .catch(e => {
          console.log(e);
          alert('ไม่สามารถเพิ่มข้อมูลได้');
        });
      this.submitted = true;
    },
    clear() {
      this.personnel.prefixId = ''
      this.personnel.personnelName = ''
      this.personnel.positionId = ''
      this.personnel.departmentId = ''
      this.personnel.personnelRole = ''
     

      
    },
    refreshList() {
      this.getPrefix();
      this.getCreatDepartment();
      this.getCreatTravel();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getPrefix();
    this.getCreatDepartment();
    this.getCreatTravel();
  }
};
</script>
