let baseUrl = "http://localhost:8080"
let estudiantes = []

function ObtenerCarreras(){
    fetch(baseUrl + "/carreras/all").then( res => {
        res.json().then(json => {
            estudiantes = json
            ImprimirCarreras()
        })
    })
}

function ImprimirCarreras(){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    estudiantes.forEach(c => {
        contenedor.innerHTML += MapearCarreras(c)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearCarreras(c) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" id="${c.cod_carrera}" class="ml-2"/>
        <label for="${c.cod_carrera}" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.cod_carrera}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.nombre_carrera}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${c.cod_depto}</td>
  </tr>`
}

function añadirRegistro() {
    var tabla = document.getElementById("cuerpo-tabla");

    tabla.innerHTML += MapearInput()
}

function MapearInput(){
    return `<tr>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">
        <button>
            <img src="img/cancelar.png" class="w-[21px] h-[19px] ml-[5px] mt-[4px]">
        </button>
        <button>
            <img src="img/añadir.png" class="bg-green-300 w-[21px] h-[19px] ml-[5px] mt-[4px]">
        </button>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">
        <input type="text" class="border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border">
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">
        <input type="text" class="border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border">
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">
        <input type="text" class="border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border">
    </td>
</tr>`
}
