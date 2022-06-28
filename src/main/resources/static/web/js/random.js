
const app = Vue.createApp({

    //CREAR Y USAR VARIABLES
    data() {
        return {
            num: 12,
            cantidad: 1,
            cantComida: 1,
            cantBebida:0,
            productos: [
                {
                id: 1,
                nombre: "Hamburguesa",
                descripcion: "Gorda, grande y jugosa",
                imagen: "urlDeImagen",
                stock: 25,
                precio: 550,
                ingredientes: [ ]
                },
                {
                id: 2,
                nombre: "Lomito Veggie",
                descripcion: "pan ciabatta, bife de seitan",
                imagen: "urlImagen",
                stock: 20,
                precio: 650,
                ingredientes: [ ]
                },
                {
                id: 3,
                nombre: "Bastoncitos de papa",
                descripcion: "rellenos con queso mozzarella",
                imagen: "urlImagen",
                stock: 15,
                precio: 500,
                ingredientes: [ ]
                },
                {
                id: 4,
                nombre: "Papas con cheddar",
                descripcion: "acompañadas del mejor cheddar de la zona",
                imagen: "urlImagen",
                stock: 35,
                precio: 600,
                ingredientes: [ ]
                },
                {
                id: 5,
                nombre: "Picada para 2 personas",
                descripcion: "aros de cebolla, aceitunas y fiambres y quesos varios",
                imagen: "urlImagen",
                stock: 15,
                precio: 900,
                ingredientes: [ ]
                }
                ],
            productosRandom: [],
            seccionAleatoria: false,
            totalPagar : 0
        }
    },

    created(){
        // axios.get('http://localhost:8585/api/productos')
        //     .then(respose=>{
        //         this.productos = respose.data
        //     })
    },


    methods: {
        aumentarCantidad(param){
            if(param === 'comida'){
                this.cantComida = this.cantComida + 1
            }else if (param === 'bebida'){
                this.cantBebida = this.cantBebida + 1
            }
        },
        disminuirCantidad(param){
            if(this.cantidad >1) {this.cantidad = this.cantidad -1}
            if(param === 'comida' && this.cantComida > 1){
                this.cantComida = this.cantComida - 1
            }else if (param === 'bebida' && this.cantBebida > 0){
                this.cantBebida = this.cantBebida - 1
            }
        },
        random(){
            this.totalPagar = 0
            this.productosRandom = []
            this.seccionAleatoria = true
            let num
            let ids = []
            let ok
            for (let index = 0; index < (this.cantComida+this.cantBebida); index++) {
                ok = true
                while(ok){
                    num = Math.floor((Math.random() * (this.productos.length - 1 + 1)) + 1);
                    if(!ids.includes(num)){
                        this.productosRandom.push(this.productos.filter(producto => producto.id == num))
                        ids.push(num)
                        ok = false
                    }
                }
            }
            this.productosRandom.forEach(producto => {
                this.totalPagar = this.totalPagar + producto[0].precio
            })
        }

    },

    computed: {

    },
    

}).mount('#app')
console.log('hola')


