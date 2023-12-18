let baseUrl = "http://localhost:8080"
let empresas = []
let empresasFiltro = []

function ObtenerEmpresas(){
    fetch(baseUrl + "/empresa/all").then( res => {
        res.json().then(json => {
            empresas = json
            ImprimirEmpresas(empresas)
        })
    })
}

function ImprimirEmpresas(empresas){
    let contenedor = document.getElementById("cuerpo-tabla")
    contenedor.innerHTML = ""

    empresas.forEach(a => {
        contenedor.innerHTML += MapearEmpresas(a)
    })

    let selectAllCheckbox = document.getElementById("selectAll")
    let checkboxes = document.querySelectorAll('input[type="checkbox"]')

    selectAllCheckbox.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });
}

function MapearEmpresas(a) {
    return `<tr>
    <td class="checkbox px-2 appearance-none border border-solid border-gray-300 rounded-full w-5 h-5 cursor-pointer checked:bg-gray-700">
        <input type="checkbox" class="ml-3.5 seleccionar" id="${a.cod_empresa}" />
        <label for="${a.cod_empresa}"></label>
    </td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${a.cod_empresa}</td>
    <td class="border border-solid border-gray-300 text-center px-8 py-2 whitespace-nowrap text-gray-700">${a.nombre_empresa}</td>
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
            btnEnviar.addEventListener('click', function () {});
            
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
  
          
            var input = document.createElement('input');
            input.type = 'text';
            input.value = currentValue;
  
            
            input.addEventListener('blur', function () {
              guardarCambios(row, j, this.value);
            });
  
            // Reemplaza la celda con el campo de entrada
            cell.innerHTML = '';
            cell.appendChild(input);
          }
  
          // Agrega botones a la celda del checkbox
          var btnEnviar = document.createElement('button');
          var iconEnviar = document.createElement('img');
          iconEnviar.src = 'img/añadir.png';
          iconEnviar.className = "bg-green-300 w-[18px] h-[18px] ml-[2px]";
  
          var btnDeshacer = document.createElement('button');
          var iconDeshacer = document.createElement('img');
          iconDeshacer.src = 'img/cancelar.png';
          iconDeshacer.className = "w-[18px] h-[18px] mt-[2px]";
  
          btnEnviar.appendChild(iconEnviar);
          btnEnviar.addEventListener('click', function () {
            // Agrega la lógica
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
  
  function guardarCambios(row, cellIndex, newValue) {
    // Actualiza el contenido de la celda con el nuevo valor
    row.cells[cellIndex].textContent = newValue;
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