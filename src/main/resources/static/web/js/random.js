// Ahora, tanto el valor mínimo como el máximo están incluidos en el resultado.
function idRandom(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1) + min);
  }
const app = Vue.createApp({

    //CREAR Y USAR VARIABLES
    data() {
        return {
            num: 12,
            cantidad: 1,
            cantComida: 1,
            cantBebida:0,
            productos: [],
            productosRandom: [],
            seccionAleatoria: false,
            totalPagar : 0,
            comidas : [],
            bebidas : [],
            deshabilitar : true
        }
    },

    created(){
        axios.get('http://localhost:8585/api/productos')
            .then(respose=>{
                this.productos = respose.data
                this.comidas = this.productos.filter(producto => producto.tipo == 'COMIDA')
                this.bebidas = this.productos.filter(producto => producto.tipo == 'BEBIDA')
                console.log(this.bebidas)
                console.log(this.bebidas.length)
            })
    },


    methods: {
        aumentarCantidad(param){
            if(param === 'comida'){
                this.cantComida = this.cantComida + 1
            }else if (param === 'bebida'){
                this.cantBebida = this.cantBebida + 1
            } else{
                param.cant ++
            }
        },
        disminuirCantidad(param){
            if(this.cantidad >1) {this.cantidad = this.cantidad -1}
            if(param === 'comida' && this.cantComida > 1){
                this.cantComida = this.cantComida - 1
            }else if (param === 'bebida' && this.cantBebida > 0){
                this.cantBebida = this.cantBebida - 1
            }else if (param.cant > 1){
                param.cant --
            }
        },
        random(){
            this.totalPagar = 0
            this.productosRandom = []
            this.seccionAleatoria = true
            let num
            let ids = []
            let ok
            for (let index = 0; index < this.cantComida; index++) {
                ok = true
                while(ok){
                    num = idRandom(1,this.comidas.length)
                    if(!ids.includes(num)){
                        this.productosRandom.push(this.comidas.find(producto => producto.id == num))
                        ids.push(num)
                        ok = false
                    }
                }
            }
            for (let index = 0; index < this.cantBebida; index++) {
                ok = true
                while(ok){
                    num = idRandom(40,this.bebidas.length)
                    if(!ids.includes(num)){
                        this.productosRandom.push(this.bebidas.find(producto => producto.id == num))
                        ids.push(num)
                        ok = false
                    }
                }
            }
            console.log(this.productosRandom)
            this.productosRandom.forEach(producto => {
                producto.cant = 1
            })
        },
        eliminarProducto(producto){
            this.productosRandom = this.productosRandom.filter(product => product != producto)
        },
        // ordenar(){
        //     this.productosRandom.forEach(producto => {
        //         axios.post('http://localhost:8585/api/productos/carrito/agregar',`cantidad=${producto.cant}&idProducto=${producto.id}`)
        //             .then(response => console.log('añadido al carrito'))
        //             .catch(error => console.log('no añadido '+producto.nombre))
        //     })
        // }
        agregar(producto){
                axios.post('http://localhost:8585/api/productos/carrito/agregar',`cantidad=${producto.cant}&idProducto=${producto.id}`)
                    .then(response => this.deshabilitar = true)
                    .catch(error => console.log('no añadido '+producto.nombre))
        }

    },

    computed: {
        total(){
            this.totalPagar = 0
            this.productosRandom.forEach(producto => {
                this.totalPagar = this.totalPagar + (producto.precio * producto.cant)
            })
        }
    },
    

}).mount('#app')
console.log('holaa')



