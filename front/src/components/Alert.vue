<template>
  <div class="text-xs-center">
    <v-dialog
      v-model="dialog"
      width="500"
    >
      

      <v-card>
        <v-card-title
          class="headline grey lighten-2"
          primary-title
        >
Permiso temporal        </v-card-title>

      <v-card-text>
        Identificador:  {{id}}
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text>
        Nombre:  {{name}} {{surname}}
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text>
        Rut:  {{identifier}} 
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text>
        Fecha inicio:  {{date}}
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text>
        Fecha término:  {{finalDate}}
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text>
        Dirección:  {{address}} 
      </v-card-text>
            <v-divider></v-divider>
          <v-spacer></v-spacer>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="error"
            flat
            @click="dialog = false"
          >
           Salir
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
  import moment from 'moment'

  export default {
    data () {
      return {
        dialog: false,
        id: '',
        date: '',
        finalDate: '',
        name: '',
        surname: '',
        address: '',
        identifier: ''
      }
    },
    methods: {
      setValue: function(Pass) {
        this.dialog = true;
        console.log(Pass)
        this.id = Pass.id
        this.date =  moment(String(Pass.date)).format('HH-mm-ss  DD-MM-YYYY')
        this.finalDate =  moment(String(Pass.finalDate)).format('HH-mm-ss  DD-MM-YYYY')
        this.name = Pass.name
        this.surname = Pass.surname
        this.address = Pass.address
        this.identifier = Pass.identifier
    }
    }
  }
</script>