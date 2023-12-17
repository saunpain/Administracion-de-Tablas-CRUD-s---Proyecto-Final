let baseUrl = "http://localhost:8080"
let proyectos = []
let estudiantesFiltro = []

function ObtenerProfesores(){
    fetch(baseUrl + "/profesor/all").then( res => {
        res.json().then(json => {
            proyectos = json
            ImprimirProfesores(proyectos)
        })
    })
}

function FiltrarProfesores() {
    let nombre = document.getElementById("inputNombre").value.trim() || null
    let departamento = document.getElementById("selectDepartamento").value
    let tipo = document.getElementById("selectTipo").value
    console.log(tipo)
    let sede = document.getElementById("selectSede").value

    switch (departamento) {
        case "Arquitectura y Redes de Computadoras":
            departamento = "darc"
            break
        case "Computación y Simulación de Sistemas":
            departamento = "dcss"
            break
        case "Ingeniería de Software":
            departamento = "dis"
            break
        case "Programación de Computadoras":
            departamento = "dpc"
            break
        case "Sistemas de Información, Control y Evaluación de Recursos Informáticos":
            departamento = "siceri"
            break
        default:
            departamento = null
            break
    }

    switch(tipo) {
        case "Tiempo parcial":
            tipo = "Tiempo Parcial"
            tipo = encodeURIComponent(tipo);
            break
        case "Tiempo completo":
            tipo = "Tiempo Completo"
            tipo = encodeURIComponent(tipo);
            break
        default:
            tipo = null
            break
    }

    sede = null;

    console.log(nombre)
    console.log(departamento)
    console.log(tipo)
    console.log(sede)

    fetch(baseUrl + `/profesor/filtrar?nombre=${nombre}&departamento=${departamento}&tipo=${tipo}&sede=${sede}`).then(res => {
        res.json().then(json =>{
            estudiantesFiltro = json
            console.log(estudiantesFiltro)
            ImprimirProfesores(estudiantesFiltro)
        })
    }).catch(error => {
        console.error("Error en la solicitud:", error);
    });
    
}

function ImprimirProfesores(profesores){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    profesores.forEach(p => {
        contenedor.innerHTML += MapearProfesor(p)
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
        <input type="checkbox" id="${p.cod_profesor}" class="ml-2"/>
        <label for="${p.cod_profesor}" class="p-1"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_profesor}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.nombre_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.apellido_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.tipo_prof}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cod_depto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.telefono_profesor}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.correo_profesor}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${p.cedula_profesor}</td>
</tr>`
}