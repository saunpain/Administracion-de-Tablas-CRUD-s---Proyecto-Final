let baseUrl = "http://localhost:8080"
let proyectos = []
let proyectosFiltro = []

function ObtenerProyectos(){
    fetch(baseUrl + "/proyecto/all").then( res => {
        res.json().then(json => {
            proyectos = json
            ImprimirProyectos(proyectos)
        })
    })
}

function ImprimirProyectos(proyectos){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    proyectos.forEach(p => {
        contenedor.innerHTML += MapearProyecto(p)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearProyecto(p) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input id="${p.cod_proyecto}" type="checkbox" class="ml-2"/>
        <label for="${p.cod_proyecto}" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_proyecto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.tipo_proyecto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.titulo_proyecto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_profesor}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.fecha_entrega}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.fecha_verificacion}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.fecha_evaluacion}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.fecha_aprobacion}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.fecha_sustentacion}</td>
</tr>`
}