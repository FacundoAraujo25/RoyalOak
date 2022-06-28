Vue.createApp({

    data() {
        return {
            email:"",
            contraseña:"",

            nombreR:"",
            apellidoR:"",
            emailR:"",
            telefonoR:"",
            direccionR:"",
            contraseñaR:"",

        }
    },

    created() {
        
        
    },

    methods: {

        iniciarSesion(){
            axios.post('http://localhost:8585/api/login',`email=${this.email}&password=${this.contraseña}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                console.log("sesion iniciada con exito")
                Swal.fire({
                    title: "Login exitoso",
                    text: "Sesion iniciada correctamente, ya puedes hacer pedidos en nuestra app",
                    icon: "success",
                    confirmButtonColor: '#12A098',
                    confirmButtonText: "Vamos por la comida!🍔",
                    width: "40%",
                })
                .then(response =>{
                    window.location.href = './index.html'
                })
            })
            .catch(response => {
                console.log("error")
                Swal.fire({
                    title: "Inicio de sesion fallido",
                    text: "Parte de tu información no es correcta. Intentalo de nuevo",
                    icon: "error",
                    confirmButtonText: "intentar de nuevo",
                    width: "30%",
                })
            })
        },


        registrarse(){
            axios.post('http://localhost:8585/api/clientes',`nombre=${this.nombreR}&apellido=${this.apellidoR}&email=${this.emailR}&telefono=${this.telefonoR}&direccion=${this.direccionR}&contraseña=${this.contraseñaR}`, {headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                console.log("nuevo cliente registrado")
                Swal.fire({
                    title: "Confirmar Registro",
                    text: "Gracias por confiar en royal Oak, por favor confirma tu correo",
                    icon: "success",
                    /* confirmButtonText: "Ir al menu", */
                    width: "40%",
                })
            })
            
            .catch(response =>{
                console.log("no pudimos hacer el registro")
                Swal.fire({
                    title: "Registro Fallido",
                    text: "Parte de tu información no esta completa. Intentalo de nuevo",
                    icon: "warning",
                    confirmButtonText: "intentar de nuevo",
                    width: "30%",
                })
            })
        }

    },

    computed: {
    }


    
}).mount('#app')