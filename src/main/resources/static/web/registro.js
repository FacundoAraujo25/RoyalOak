Vue.createApp({
    data() {
        return {
            registrationUrlApi:"localhost:8080/api/registro/",
            cliente:[],
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const paramToken = urlParams.get('token'); 
        console.log(paramToken)
        axios.get(this.registrationUrlApi+`${paramToken}`)
            .then(datos =>{
                console.log("y funciona?")
                
                axios.get("localhost:8080/api/clientes/"+`${paramToken}`)
                    .then(datos => {
                        this.cliente = datos.data
                        console.log(this.cliente)
                        console.log(this.cliente.email)
                        console.log(this.cliente.contraseña)
                        setTimeout(this.logInFunc, 1000)
                        setTimeout(function(){window.location.href = "/web/index.html"}, 1000)
                    })
                    .catch(error => console.log(error))
            })
            .catch(error => console.log(error))
    },
    methods: {
        logInFunc() {
            axios.post("localhost:8080/api/login", 
                    `email=${this.cliente.email}&password=${this.cliente.contraseña}`,
                    {headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(response => {
                    console.log("Youre sign in")
                    // if (this.email.includes("@mbb-admin.com")){
                    //     window.location.href = "/web/manager/manager.html"
                    // } else {
                    //     window.location.href = "/web/pages/accounts.html"
                    // }
                })
                .catch(error => 
                    this.errorCatch = true,
                )
        },

    },

    computed: {
        
    }
}).mount('#app')