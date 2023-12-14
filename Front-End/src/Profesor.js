let baseUrl = "http://localhost:8080"
let profesores = []

function ObtenerProfesores(){
    fetch(baseUrl + "/profesor/all").then( res => {
        console.log("fetch exitoso")
        res.json().then(json => {
            profesores = json
            console.log("profesores convertidos en json")
            console.log(profesores)
            ImprimirProfesores()
        })
    })
}

function ImprimirProfesores(){
    let contenedor = document.getElementById("cuerpo-tabla")
    console.log("contenedor obtenido")
    contenedor.innerHTML = ""

    profesores.forEach(p => {
        contenedor.innerHTML += MapearProfesor(p)
        console.log("profesor mapeado")
        console.log(p.cod_profesor)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearProfesor(p) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-2"/>
        <label for="selectAll" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_profesor}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.nombre_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.apellido_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.tipo_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_depto}</td>
</tr>`
}