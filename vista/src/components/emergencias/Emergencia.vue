<template>  
    <div b-row class="container-fluid ">


        <b-container class="container-fluid text-center">
            <b-row>
                        
                
                <b-col>
                    <button class="btn btn-lg colorRojo rounded-pill mb-1" @click="volver()" ><i class="bi bi-arrow-left-short"></i>
                         Volver a tablón
                    </button>

                     <div b-col class="container-fluid ventana_emer extra px-0 text-center mt-4">
                    <!-- @submit.prevent="handleUpdateForm()" -->

                    <form > 
                        <h3 class="py-1 px-0 mx-0 soloRojo" style="border-top-left-radius: 20px;border-top-right-radius: 20px;">Emergencia</h3>
                        <h1 class="capitalize mt-3">{{emergencia.nombre}}</h1>
                        <!-- 
                        <h2> 
                            Nombre : {{institucion.nombre}}
                        </h2>
                        -->


                        <h5 >
                            <hr>
                            <p class="justificar px-4 mt-3"> 
                            Fecha de inicio: {{emergencia.finicio}}
                            <br>Fecha de termino: {{emergencia.ffin}}
                            <!-- 
                            Hola _{{emergencia.id_institucion}}
                            -->

                            </p>
                            <hr>
                            <p style="text-align: left; padding-left: 24px"> 
                            Ubicación : {{emergencia.latitud}} , {{emergencia.longitud}}
                            </p>
                            <hr>

                            <p class="justificar px-4">Descripción : <br>{{emergencia.descrip}}
                            </p> 
                            <hr>
       
                        </h5>
                       
                        <div class="row">
                            <div class="col-8 pt-2">
                                <h5>
                                    Cantidad de Voluntarios Cercanos:
                                </h5>
                            </div>
                             <div class="col-4 px-0">
                                <div class=" form-group text-center " style="width: 140px;">
                                    <div class="form-group input-group text-center">
                                        <select class="form-control rounded-pill text-center" style="text-align-last: center;" placeholder="Voluntarios" v-model="totalVol" @change="obtenerUsuarios()" required>
                                            <option  v-for="number in N" :key="number">{{number}}</option>
                                        </select>
                                    </div> 
                                </div>  
                            </div>
                        </div>
                        
                       
                        <div >
                            <button class="mt-4 btn btn-lg color3 rounded-pill" 
                            @click="checkearPostulantes();" > Postular</button>
                        </div>
                        

                    </form>



                </div>
                </b-col>

                <b-col>
                    <Mapa v-bind:emergencia="emergencia" v-bind:usuarios="usuarios" ></Mapa> 

                </b-col>
            </b-row>
        </b-container>

       
        <div b-col>
            

            <Lista v-bind:usuarios="usuarios" ></Lista>  

        </div>
    </div> 
</template>

<script>
    import axios from "axios";
    import Mapa from '../mapas/MapaVoluntario.vue';
    import Lista from '../usuario/UsuariosCercanos.vue';
    export default {
        components:{
            Mapa,
            Lista
        },
        props:[
            'usuario'
        ],
        data() {
            return {
                emergencia: { },
                id_institucion : '',
                latitud : 0,
                longitud : 0,
                institucion : {} ,
                ubicacion : [],
                usuarios : [],
                totalVol: 1,
                N : 0,
            }
        },     
        created() {
            let apiURL = `http://localhost:3000/emergencias/${this.$route.params.id}`;
            axios.get(apiURL).then((res) => {
                this.emergencia= res.data;
                this.latitud = this.emergencia.latitud;
                this.longitud = this.emergencia.longitud;
                this.id_institucion =  res.data.id_institucion;
                console.log(this.emergencia.latitud,this.emergencia.longitud);
                let apiURL2 = 'http://localhost:3000/instituciones/' + this.id_institucion.toString();
                axios.get(apiURL2).then((res) => {
                    this.institucion = res.data;
                    console.log("Nombre : " + this.institucion.nombre);
                }); 
                this.ubicacion = [this.emergencia.latitud,this.emergencia.longitud];
            }); 
            
            this.obtenerUsuarios(); 

        },
        mounted(){
            let apiURL4 = `http://localhost:3000/voluntarios/count`;  
            axios.get(apiURL4).then(res => {
                this.N = res.data;
                console.log("N : " + this.N);
            }).catch(error => {
            console.log(error)
             });
 
        },
        updated(){
        },
        computed(){
            
        },

        methods: {
            volver(){
                this.$router.push('/emergencias');   
            },
            obtenerUsuarios(){
                let apiURL3 = `http://localhost:3000/voluntarioscercanos`;  
                axios.post(apiURL3, {"latitud" : this.latitud,"longitud" :this.longitud, "id": this.totalVol}).then((res) => {
                    this.usuarios = res.data;
                    console.log(this.usuarios);
                }).catch(error => {
                    console.log(error)
                });
            }
        }    
    }
</script>

<style>

    body, html {
    padding: 0;
    margin: 0;
    width: 100%;
    min-height: 100vh;
    }
    body {
        background: linear-gradient(180deg, #A8DADC 4.87%, rgba(255, 255, 255, 0) 20%),
                    linear-gradient(0deg, #A8DADC -12.07%, rgba(255, 255, 255, 0) 20%),
                    #FEF9FF;
    }
    .divider-text {
        position: relative;
        text-align: center;
        margin-top: 15px;
        margin-bottom: 15px;
    }
    .divider-text span {
        padding: 7px;
        font-size: 12px;
        position: relative;   
        z-index: 2;
    }
    .divider-text:after {
        content: "";
        position: absolute;
        width: 100%;
        border-bottom: 1px solid #ddd;
        top: 55%;
        left: 0;
        z-index: 1;
    }
    .ocultar {
    display: none;
    }
    .mostrar {
        display: block;
    }

    .ventana_emer{
        width: 540.93px;
        height: 750px;
        /*
        left: 482px;
        top: 26px;
*/
        background: #FFFFFF;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 20px;
        
    }
    .extra{
        transition: 0.5s;
    }
    .extra:hover{
        /*
        margin-top: 23px !important;
        */
        box-shadow: 0px 10px 10px rgba(0, 0, 0, 0.5);
         
    }
    .padding_up{
        padding-top: 15px;
    }
    .margin-l{
        margin-left: 51px;
    }
    .margin-moreleft{
        margin-left: -150px;
    }
    .soloRojo{
        color:white !important;
        background-color: red !important;
    }

    

</style>


