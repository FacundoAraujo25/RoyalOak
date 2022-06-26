const app = Vue.createApp({

    //CREAR Y USAR VARIABLES
    data() {
        return {
            
        }
    },

    created(){

    },


    methods: {
        
        mostrarIngredientes(){
            Swal.fire({
                title:'Nombre Hamburguesa',
                text: 'Una hamburguesa es un sándwich hecho a base de carne molida o de origen vegetal, aglutinada en forma de filete cocinado a la parrilla o a la plancha, aunque también puede freírse u hornearse. Fuera del ámbito de habla hispana, es más común encontrar la denominación estadounidense burger, acortamiento de hamburger.',
                confirmButtonText: 'Entendido',
                footer: '<a href="">Agregar al carro</a>'
              })
        }
        

    },

    computed: {

    },
    

}).mount('#app')


