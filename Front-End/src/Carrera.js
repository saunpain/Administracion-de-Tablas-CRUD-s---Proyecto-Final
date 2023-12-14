let baseUrl = "http://localhost:8080"
let carreras = []

function ObtenerCarreras(){
    fetch(baseUrl + "/carreras/all").then( res => {
        console.log("fetch exitoso")
        res.json().then(json => {
            carreras = json
            console.log("carreras convertidas en json")
            console.log(carreras)
            ImprimirCarreras()
        })
    })
}

function ImprimirCarreras(){
    let contenedor = document.getElementById("cuerpo-tabla")
    console.log("contenedor obtenido")
    contenedor.innerHTML = ""

    carreras.forEach(c => {
        contenedor.innerHTML += MapearCarrera(c)
        console.log("carrera mapeada")
        console.log(c.cod_carrera)
    })
}

function MapearCarrera(c) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-2"/>
        <label for="selectAll" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.cod_carrera}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.nombre_carrera}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.cod_depto}</td>
  </tr>`
}