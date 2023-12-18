let baseUrl = "http://localhost:8080"
let profesores = []
let estudiantesFiltro = []

function ObtenerProfesores(){
    fetch(baseUrl + "/profesor/all").then( res => {
        res.json().then(json => {
            profesores = json
            ImprimirProfesores(profesores)
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
        <input type="checkbox" class="ml-3.5"/>
        <label for="selectAll" class="p-1"></label>
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
                fechaInput.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border"; /* Le da estilo a las celdas agregadas formato fecha*/
                nueva.appendChild(fechaInput);
            } else {
                var registro = document.createElement('input');
                registro.type = "text";
                registro.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border";  /* Le da estilo a las celdas agregadas formato texto*/
                nueva.appendChild(registro);
            }
        }
    }
    nuevaCelda.cells[0].querySelector('input').focus();
}


