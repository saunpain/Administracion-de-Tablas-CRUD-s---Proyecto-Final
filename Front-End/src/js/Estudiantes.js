let baseUrl = "http://localhost:8080"
let estudiantes = []
let estudiantesFiltro = []

function ObtenerEstudiantes(){
    fetch(baseUrl + "/estudiante/all").then( res => {
        res.json().then(json => {
            estudiantes = json
            ImprimirCarreras(estudiantes)
        })
    })
}

function FiltrarEstudiantes() {
    let nombre = document.getElementById("inputNombre").value.trim() || null
    let identificacion = document.getElementById("inputIdentificacion").value || null
    let carrera = document.getElementById("selectCarrera").value
    let anio = document.getElementById("selectAnio").value

    switch (carrera) {
        case "Lic. en Desarrollo y Gestión de Software":
            carrera = "1R";
            break;
        case "Lic. en Ing. de Sistemas de Información General":
            carrera = "4L";
            break;
        case "Lic. en Ciberseguridad":
            carrera = "GS";
            break;
        case "Lic. en Ing de Sistemas de Información":
            carrera = "IF";
            break;
        case "Lic. en Ing. de Sistemas y Computación":
            carrera = "IL";
            break;
        case "Lic. en Ing de Software":
            carrera = "LC";
            break;
        case "Lic. en Informática Aplicada a la Educación":
            carrera = "LS";
            break;
        case "Lic en Redes de Información":
            carrera = "S3";
            break;
        case "Lic. en Informática para la Gestión Empresarial":
            carrera = "SF";
            break;
        default:
            carrera = null;
            break;
    }

    switch(anio) {
        case "Cuarto año":
            anio = 4
            break
        case "Quinto año":
            anio = 5
            break
        default:
            anio = null
            break
    }

    console.log(nombre)
    console.log(identificacion)
    console.log(carrera)
    console.log(anio)

    fetch(baseUrl + `/estudiante/filtrar?nombre=${nombre}&identificacion=${identificacion}&carrera=${carrera}&anio=${anio}`).then(res => {
        res.json().then(json =>{
            estudiantesFiltro = json
            console.log(estudiantesFiltro)
            ImprimirCarreras(estudiantesFiltro)
        })
    }).catch(error => {
        console.error("Error en la solicitud:", error);
    });
}

function ImprimirCarreras(estudiantes){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    estudiantes.forEach(e => {
        contenedor.innerHTML += MapearCarreras(e)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearCarreras(e) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-2" id="${e.cedula}" />
        <label for="${e.cedula}"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cedula}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.pri_nom}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.seg_nom}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.pri_apellido}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.seg_apellido}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">0000-0000</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">aaa.eee @utp.ac.pa</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cod_proyecto}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">Evaluacion</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cod_carrera}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.anio_cursa}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.indice}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cod_sede}</td>
</tr>`
}