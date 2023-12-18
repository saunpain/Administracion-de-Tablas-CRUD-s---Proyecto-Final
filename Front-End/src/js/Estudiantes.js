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


let inputNombre = document.getElementById("inputNombre")
let inputIdentificacion = document.getElementById("inputIdentificacion")

inputNombre.addEventListener('search', function(){
    ObtenerEstudiantes()
})

inputIdentificacion.addEventListener('search', function(){
    ObtenerEstudiantes()
})


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
        anio_cursa: document.getElementById("input10").value,
        semestre: "I",
        indice: document.getElementById("input11").value,
        cod_proyecto: document.getElementById("input8").value,
        cod_carrera: document.getElementById("input9").value,
        cod_sede: document.getElementById("input12").value,
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

function ActualizarEstudiantes(){

    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id

    let data = {
        cedula: idCheckbox,
        cedulaNueva: document.getElementById("input1").value,
        pri_nom: document.getElementById("input2").value,
        seg_nom: document.getElementById("input3").value,
        pri_apellido: document.getElementById("input4").value,
        seg_apellido: document.getElementById("input5").value,
        telefono: document.getElementById("input6").value,
        correo: document.getElementById("input7").value,
        anio_cursa: document.getElementById("input10").value,
        indice: document.getElementById("input11").value,
        cod_proyecto: document.getElementById("input8").value,
        cod_carrera: document.getElementById("input9").value,
        cod_sede: document.getElementById("input12").value,
    }

    console.log(data)

    fetch(baseUrl + "/estudiante", {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerEstudiantes()
    })
}

function EliminarEstudiante(){

    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id

    fetch(baseUrl + "/estudiante/" + idCheckbox, {method: "Delete"}).then(res =>{
        console.log(res)
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
        <input type="checkbox" class="ml-3.5 seleccionar" id="${e.cedula}" />
        <label for="${e.cedula}"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cedula}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.pri_nom}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.seg_nom}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.pri_apellido}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.seg_apellido}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.telefono}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.correo}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${e.cod_proyecto}</td>
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
                fechaInput.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border"; /* Le da estilo a las celdas agregadas formato fecha*/
                nueva.appendChild(fechaInput);
            } else {
                var registro = document.createElement('input');
                registro.type = "text";
                registro.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border";  /* Le da estilo a las celdas agregadas formato texto*/
                registro.id = "input" + i
                nueva.appendChild(registro);
            }
        }
    }
    nuevaCelda.cells[0].querySelector('input').focus();
}

function hacerEditable() {
    var table = document.getElementById('cuerpo-tabla');
    var checkboxes = table.getElementsByClassName('seleccionar');

    for (var i = 0; i < checkboxes.length; i++) {
        var checkbox = checkboxes[i];

        if (checkbox.checked) {
            var row = checkbox.closest('tr');

            if (!row.classList.contains('editable')) {
                row.classList.add('editable');

                // Encuentra el checkbox y ocúltalo
                var checkboxCell = row.cells[0];
                var checkboxInput = checkboxCell.querySelector('input[type="checkbox"]');
                checkboxInput.style.display = 'none';

                // Recorre todas las celdas de la fila, excepto la primera (checkbox)
                for (var j = 1; j < row.cells.length; j++) {
                    var cell = row.cells[j];
                    var currentValue = cell.textContent;

                    // Guarda el valor original de la celda
                    cell.setAttribute('data-original-value', currentValue);

                    // Crea un input con id dinámico
                    var input = document.createElement('input');
                    input.type = 'text';
                    input.value = currentValue;
                    input.id = 'input' + j; // Aquí se crea el id dinámico

                    // Reemplaza la celda con el campo de entrada
                    cell.innerHTML = '';
                    cell.appendChild(input);
                }

                // Agrega botones a la celda del checkbox
                var btnEnviar = document.createElement('button');
                var iconEnviar = document.createElement('img');
                iconEnviar.src = 'img/añadir.png';
                iconEnviar.className = "bg-green-300 w-[18px] h-[18px] mt-[2px]";

                var btnDeshacer = document.createElement('button');
                var iconDeshacer = document.createElement('img');
                iconDeshacer.src = 'img/cancelar.png';
                iconDeshacer.className = "w-[18px] h-[18px] ml-[2px]";

                btnEnviar.appendChild(iconEnviar);
                btnEnviar.addEventListener('click', function () {
                    ActualizarEstudiantes();
                });

                btnDeshacer.appendChild(iconDeshacer);
                btnDeshacer.addEventListener('click', function () {
                    // Elimina los botones antes de deshacer
                    btnEnviar.remove();
                    btnDeshacer.remove();
                    deshacerCambios(row);
                });

                checkboxCell.appendChild(btnDeshacer);
                checkboxCell.appendChild(btnEnviar);
            }
        }
    }
}
  
  function deshacerCambios(row) {
    // Deshace los cambios y sale del modo de edición
    row.classList.remove('editable');
  
    // Encuentra el checkbox y muéstralo
    var checkboxCell = row.cells[0];
    var checkboxInput = checkboxCell.querySelector('input[type="checkbox"]');
    checkboxInput.style.display = 'block';
  
    // Recorre todas las celdas de la fila
    for (var i = 1; i < row.cells.length; i++) {
      var cell = row.cells[i];
      var originalValue = cell.getAttribute('data-original-value');
  
      // Restaura el valor original de la celda
      cell.textContent = originalValue;
      cell.removeAttribute('data-original-value');
    }
  }