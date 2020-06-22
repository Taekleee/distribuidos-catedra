<template>
<v-container id = "formulario">
    <v-row justify="center">
    <v-form
      ref="form"
      v-model="valid"
      :lazy-validation="lazy"
    >
      <v-text-field
        v-model="Pass.name"
        :counter="25"
        :rules="nameRules"
        label="Nombre"
        required
      ></v-text-field>

      <v-text-field
        v-model="Pass.surname"
        :counter="25"
        :rules="nameRules"
        label="Apellido"
        required
      ></v-text-field>

    <v-text-field
        v-model="Pass.identifier"
        :counter="25"
        label="Rut ej: 17828372-1"
        required
      ></v-text-field>

       <v-text-field
        v-model="Pass.address"
        :counter="50"
        label="Dirección"
        required
      ></v-text-field>


      <v-select
        v-model="Pass.select"
        :items="items"
        :rules="[v => !!v || 'Item is required']"
        label="Tipo de permiso"
        required
      ></v-select>




      <Alert ref="Alert"></Alert>
      <v-btn
        :disabled="!valid"
        color="success"
        class="mr-4"
        @click="validate"
        
      >
        Generar permiso
      </v-btn>
      <v-btn
        color="error"
        class="mr-4"
        @click="reset"
      >
        Cancelar
      </v-btn>

    </v-form>
  </v-row>
</v-container>
</template>

<script>
import axios from 'axios'
import Alert from './Alert'
  export default {
    components: {
      Alert
      
    },
    data: () => ({
      valid: true,
      name: '',
      nameRules: [
        v => !!v || 'Name is required',
        v => (v && v.length <= 10) || 'Name must be less than 10 characters',
      ],
      surname: '',
      address: '',
      rut: '',
      Pass: {name: '', surname: '', address: '', identifier: '', select: ''},
      select: null,
      items: [
        '01 Permiso Temporal Individual - Asistencia a establecimientos de salud',
        '02 Permiso Temporal Individual - Compras insumos básicos',
        '03 Permiso Temporal Individual - Salida de personas con espectro autista u otra discapacidad mental',
        '04 Permiso Temporal Individual - Paseo de mascotas',
        '05 Permiso Temporal Individual - Pago de Servicios Básicos',
        '06 Permiso Temporal Individual - Asistencia a funeral familiar directo',
        '07 Permiso Temporal Individual - Retiro de alimentos y textos escolares desde organismos públicos',
        '08 Permiso Temporal Individual - Comparecencia a una citación en virtud de la Ley',
        '09 Permiso Temporal Individual - Entregar alimentos u otros insumos de primera necesidad a adultos mayores',
        '10 Permiso Temporal Individual - Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario',
        '11 Permiso Temporal Individual - Retorno del menor o adolescente al hogar del tutelar',
        '12 Permiso Temporal Individual - Cambio de domicilio (mudanza)',
        '13 Permiso Temporal Individual - Traslado de padres o tutores a establecimientos de salud'

      ],
      checkbox: false,
      lazy: false,
    }),

    methods: {
      validate (evt) {
        evt.preventDefault();
        console.log(this.Pass)
        let newPass = {
           name: this.Pass.name,
           surname: this.Pass.surname,
           address: this.Pass.address,
           identifier: this.Pass.identifier,
           reason: this.Pass.select

         };
        axios.post('http://localhost:8080/newPass',newPass)
         .then((response)=>{
           console.log("hice post de esto: "+response)
            this.$refs.Alert.setValue(response.data);
    })
         .catch((error)=>{
           console.log(error)
         })
          
        this.$refs.form.validate()
        this.$refs.form.reset()
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
    },
  }
</script>

<style scoped>

</style>