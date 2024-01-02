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

function GuardarProfesor(){
    let data = {
        cod_profesor: document.getElementById("input1").value,
        nombre_prof: document.getElementById("input2").value,
        apellido_prof: document.getElementById("input3").value,
        tipo_prof: document.getElementById("input4").value,
        cod_depto: document.getElementById("input5").value,
        telefono_profesor: document.getElementById("input6").value,
        correo_profesor: document.getElementById("input7").value,
        cedula_profesor: document.getElementById("input8").value,
    }

    console.log(data)

    fetch(baseUrl + "/profesor", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerProfesores()
    })
}

function ActualizarProfesor(){

    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id

    let data = {
        cod_profesor: idCheckbox,
        cod_profesorNuevo: document.getElementById("input1").value,
        nombre_prof: document.getElementById("input2").value,
        apellido_prof: document.getElementById("input3").value,
        tipo_prof: document.getElementById("input4").value,
        cod_depto: document.getElementById("input5").value,
        telefono_profesor: document.getElementById("input6").value,
        correo_profesor: document.getElementById("input7").value,
        cedula_profesor: document.getElementById("input8").value,
    }

    console.log(data)

    fetch(baseUrl + "/profesor", {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerProfesores()
    })
}

function EliminarProfesor(){
    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id
    
    console.log(idCheckbox)

    fetch(baseUrl + "/profesor/" + idCheckbox, {method: "Delete"}).then(res =>{
        console.log(res)
        ObtenerProfesores()
    })
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
        <input id="${p.cod_profesor}" type="checkbox" class="ml-3.5 seleccionar"/>
        <label for="${p.cod_profesor}"></label>
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
                GuardarProfesor()
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
                    ActualizarProfesor();
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