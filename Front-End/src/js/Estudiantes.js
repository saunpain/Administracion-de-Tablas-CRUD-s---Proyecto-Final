let baseUrl = "http://localhost:8080"
let estudiantes = []
let estudiantesFiltro = []

function ObtenerEstudiantes(){
    fetch(baseUrl + "/estudiante/all").then( res => {
        res.json().then(json => {
            estudiantes = json
            ImprimirEstudiantes(estudiantes)
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
            ImprimirEstudiantes(estudiantesFiltro)
        })
    }).catch(error => {
        console.error("Error en la solicitud:", error);
    });
}

function GuardarEstudiante(){
    let data = {
        cedula: document.getElementById("input1").value,
        pri_nom: document.getElementById("input2").value,
        seg_nom: document.getElementById("input3").value,
        pri_apellido: document.getElementById("input4").value,
        seg_apellido: document.getElementById("input5").value,
        anio_cursa: document.getElementById("input11").value,
        semestre: "I",
        indice: document.getElementById("input12").value,
        cod_proyecto: document.getElementById("input8").value,
        cod_carrera: document.getElementById("input10").value,
        cod_sede: document.getElementById("input13").value,
    }

    console.log(data)

    fetch(baseUrl + "/estudiante", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerEstudiantes()
    })
}

function ImprimirEstudiantes(estudiantes){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    estudiantes.forEach(e => {
        contenedor.innerHTML += MapearEstudiantes(e)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearEstudiantes(e) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-3.5" id="${e.cedula}" />
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

/* Función para desplegar aside en celulares */
document.addEventListener('DOMContentLoaded', function () {
    var toggleButton = document.getElementById('toggleButton');
    var miAside = document.getElementById('aside');

    toggleButton.addEventListener('click', function () {
        if (miAside.style.display === 'none') {
            miAside.style.display = 'block';
            toggleButton.classList.remove('closed');
            toggleButton.classList.add('opened');
        } else {
            miAside.style.display = 'none';
            toggleButton.classList.remove('opened');
            toggleButton.classList.add('closed');
        }
    });
});

/* Función para añadir celdas a las tablas */
function añadirRegistro() {
    var tabla = document.getElementById("añadir_datos");

    var nuevaCelda = tabla.insertRow(1);

    for (var i = 0; i < tabla.rows[0].cells.length; i++) {
        var nueva = nuevaCelda.insertCell(i);

        if (i === 0) {
            var btnEnviar = document.createElement('button');
            var iconEnviar = document.createElement('img');
            iconEnviar.src = 'img/añadir.png';
            iconEnviar.className = "bg-green-300";
            iconEnviar.className = "w-[21px] h-[19px] ml-[5px] mt-[4px]";

            var btnEliminar = document.createElement('button');
            var iconEliminar = document.createElement('img');
            iconEliminar.src = 'img/cancelar.png';
            iconEliminar.className = "w-[21px] h-[19px] ml-[5px] mt-[4px]";

            btnEnviar.appendChild(iconEnviar);
            btnEnviar.addEventListener('click', function () {
                GuardarEstudiante()
            });
            
            btnEliminar.appendChild(iconEliminar);
            btnEliminar.addEventListener('click', function () {
                tabla.deleteRow(nuevaCelda.rowIndex); /* Elimina la celda creada */
            });

            nueva.appendChild(btnEliminar);
            nueva.appendChild(btnEnviar);
        } else {
            var nombreCelda = tabla.rows[0].cells[i].textContent.toLowerCase();


            if (nombreCelda.includes('fecha')) {
                var fechaInput = document.createElement('input');
                fechaInput.type = 'date';
                fechaInput.id = 'fechaInput';
                fechaInput.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border"; /* Le da estilo a las celdas agregadas formato fecha*/
                nueva.appendChild(fechaInput);
            } else {
                var registro = document.createElement('input');
                registro.type = "text";
                registro.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border";  /* Le da estilo a las celdas agregadas formato texto*/
                registro.id = "input" + i;
                nueva.appendChild(registro);
            }
        }
    }
    nuevaCelda.cells[0].querySelector('input').focus();
}


