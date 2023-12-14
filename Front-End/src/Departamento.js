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

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearDepartamento(d) {
    return `
    <tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-2"/>
        <label for="selectAll" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${d.cod_depto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${d.nombre_departamento}</td>
  </tr>
    `
}