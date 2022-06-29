Vue.createApp({
    data() {
        return {
            factura:[],
            totalFactura:"",
            apiHbanking:"https://homebanking-mh.herokuapp.com/api/transaction/payments",
            numUno:"",
            numDos:"",
            numTres:"",
            numCuatro:"",
            nombre:"",
            cvv:"",
            nombreTitular:"",
            fechaMes:"",
            fechaAño:"",
        }
    },
    created() {
        axios.get("http://localhost:8585/api/clientes/actual")
            .then(datos =>{
                this.factura = datos.data.facturas[0]
                this.totalFactura = this.factura.total
            })
    },
    methods: {
        confirmacionPagoFunc(){
            let numTarjeta = this.numUno+this.numDos+this.numTres+this.numCuatro;
            
            axios.post(this.apiHbanking,
                `{
                    "cardNumber": "1234123412341234",
                    "securityCode": "856",
                    "amount":${this.totalFactura},
                    "detail": "Factura N°: "++${this.factura.id},
                }`)
                .then(data =>{
                    Swal.fire({
                        title: "Compra exitosa",
                        text: "¡Gracias por tu cumpra!",
                        icon: "success",
                        confirmButtonColor: '#12A098',
                        confirmButtonText: "Vamos por la comida!🍔",
                        width: "40%",
                    })
                    axios.get("/api/clientes/factura")
                        .then(response =>{
                            window.location.href="./index.html"
                        })
                        .catch(error =>{
                            Swal.fire({
                                title: "Fallo descarga factura",
                                text: "No se pudo descargar tu factura, no te preocupes en un momento la encontraras en tu perfil",
                                icon: "error",
                                width: "30%",
                            })
                        })

                })
                .catch(error =>{
                    Swal.fire({
                        title: "Fallo de pago",
                        text: "Error en el procesamiento de tu pago, vuelve a intentar",
                        icon: "error",
                        width: "30%",
                    })
                })

        }

    },

    computed: {
        
    }
}).mount('#app')