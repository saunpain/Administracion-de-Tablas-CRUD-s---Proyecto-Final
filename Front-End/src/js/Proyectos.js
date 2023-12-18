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

function FiltrarProyecto() {
  let titulo = document.getElementById("inputTitulo").value.trim() || null
  let tipo = document.getElementById("selectTipo").value
  let etapa = document.getElementById("selectEtapa").value
  let anio = document.getElementById("selectAnio").value

  fetch(baseUrl + `/proyecto/filtrar?titulo=${titulo}&tipo=${tipo}&etapa=${etapa}&anio=${anio}`).then(res => {
      res.json().then(json =>{
          proyectosFiltro = json
          console.log(proyectosFiltro)
          ImprimirProyectos(proyectosFiltro)
      })
  }).catch(error => {
      console.error("Error en la solicitud:", error);
  });
}

function GuardarProyecto(){
    let fecha_entrega = formatearFecha(document.getElementById("input5"))
    let fecha_verificacion = formatearFecha(document.getElementById("input6"))
    let fecha_evaluacion = formatearFecha(document.getElementById("input7"))
    let fecha_aprobacion = formatearFecha(document.getElementById("input8"))
    let fecha_sustentacion = formatearFecha(document.getElementById("input9"))

    let data = {
        cod_proyecto: document.getElementById("input1").value,
        tipo_proyecto: document.getElementById("input2").value,
        titulo_proyecto: document.getElementById("input3").value,
        cod_profesor: document.getElementById("input4").value,
        fecha_entrega: fecha_entrega,
        fecha_verificacion: fecha_verificacion,
        fecha_evaluacion: fecha_evaluacion,
        fecha_aprobacion: fecha_aprobacion,
        fecha_sustentacion: fecha_sustentacion
    }

    console.log(data)

    fetch(baseUrl + "/proyecto", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerProyectos()
    })
}

function formatearFecha(fecha){
    if (!fecha || isNaN(new Date(fecha))) {
        return null;
    }

    let fechaObj = new Date(fecha)

    let anio = fechaObj.getFullYear()
    let mes = (fechaObj.getMonth() + 1).toString().padStart(2, "0")
    let dia = (fechaObj.getDate() + 1).toString().padStart(2, "0")

    let fechaFormateada = anio + "-" + mes + "-" + dia
    
    return fechaFormateada
}

function ActualizarProyecto(){

    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id

    let fecha_entrega = formatearFecha(document.getElementById("input5").value)
    let fecha_verificacion = formatearFecha(document.getElementById("input6").value)
    let fecha_evaluacion = formatearFecha(document.getElementById("input7").value)
    let fecha_aprobacion = formatearFecha(document.getElementById("input8").value)
    let fecha_sustentacion = formatearFecha(document.getElementById("input9").value)

    let data = {
        cod_proyecto: idCheckbox,
        codigoNuevo: document.getElementById("input1").value,
        tipo_proyecto: document.getElementById("input2").value,
        titulo_proyecto: document.getElementById("input3").value,
        cod_profesor: document.getElementById("input4").value,
        fecha_entrega: fecha_entrega,
        fecha_verificacion: fecha_verificacion,
        fecha_evaluacion: fecha_evaluacion,
        fecha_aprobacion: fecha_aprobacion,
        fecha_sustentacion: fecha_sustentacion
    }

    console.log(data)

    fetch(baseUrl + "/proyecto", {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    }).then(res => {
        ObtenerProyectos()
    })
}

function EliminarProyecto(){

    let checkboxSeleccionado = document.querySelector('input[type="checkbox"]:checked')
    let idCheckbox = checkboxSeleccionado.id

    fetch(baseUrl + "/proyecto/" + idCheckbox, {method: "Delete"}).then(res =>{
        console.log(res)
        ObtenerProyectos()
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
        <input type="checkbox" id="${p.cod_proyecto}" class="ml-3.5 seleccionar"/>
        <label for="${p.cod_proyecto}"></label>
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
                GuardarProyecto()
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
                    ActualizarProyecto();
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
