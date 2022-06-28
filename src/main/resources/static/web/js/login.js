Vue.createApp({
    data() {
        return {
        }
    },
    created() {
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
            }
    },

    computed: {
    }
}).mount('#app')