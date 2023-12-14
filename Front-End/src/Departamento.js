let baseUrl = "http://localhost:8080"
let departamentos = []

function ObtenerDepartamentos(){
    fetch(baseUrl + "/departamento/all").then( res => {
        console.log("fetch exitoso")
        res.json().then(json => {
            departamentos = json
            console.log("departamentos convertidos en json")
            console.log(departamentos)
            ImprimirDepartamentos()
        })
    })
}

function ImprimirDepartamentos(){
    let contenedor = document.getElementById("cuerpo-tabla")
    console.log("contenedor obtenido")
    contenedor.innerHTML = ""

    departamentos.forEach(d => {
        contenedor.innerHTML += MapearDepartamento(d)
        console.log("departamento mapeado")
        console.log(d.cod_depto)
    })
}

function MapearDepartamento(d) {
    return ``
}