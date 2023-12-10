document.addEventListener('DOMContentLoaded', function () {
    var toggleButton = document.getElementById('toggleButton');
    var miAside = document.getElementById('aside');
    var contenido = document.getElementById('contenido');
    var pie = document.getElementById('foot');

    toggleButton.addEventListener('click', function () {
        if (miAside.style.display === 'none') {
            miAside.style.display = 'block';
            toggleButton.classList.remove('closed');
            toggleButton.classList.add('opened');
            contenido.style.position = 'fixed';
            contenido.style.width = '100%';
            contenido.style.overflowY = 'hidden';
        } else {
            miAside.style.display = 'none';
            toggleButton.classList.remove('opened');
            toggleButton.classList.add('closed');
            contenido.style.position = 'static';
            contenido.style.overflowY = 'auto';
        }
    });
});


/*
  function addCampi() {
    var table = document.getElementById("dataTable");

    var newRow = table.insertRow(table.rows.length);

    for (var i = 0; i < table.rows[0].cells.length; i++) {
        var newCell = newRow.insertCell(i);
        if(i!==0){
            var input = document.createElement('input');
            input.type = "text";
            input.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border";
            newCell.appendChild(input);
        }
    }
    newRow.cells[0].querySelector('input').focus();
}
*/
function añadirRegistro() {
    var tabla = document.getElementById("datos");

    var nuevaCelda = tabla.insertRow(tabla.rows.length);

    for (var i = 0; i < tabla.rows[0].cells.length; i++) {
        var nueva = nuevaCelda.insertCell(i);
        if(i===0){
            var btnEnviar = document.createElement('button');
            var iconEnviar = document.createElement('img');
            iconEnviar.src = 'img/añadir.png';
            iconEnviar.className = "bg-green-300";
            iconEnviar.className = "w-[21px] h-[19px] ml-[5px]";
            
            var btnEliminar = document.createElement('button');
            var iconEliminar = document.createElement('img');
            iconEliminar.src = 'img/cancelar.png';
            iconEliminar.className = "w-[21px] h-[19px] ml-[5px]";
            
            
            btnEnviar.appendChild(iconEnviar);
            btnEnviar.addEventListener('click', function(){
            });
            
            btnEliminar.appendChild(iconEliminar);
            btnEliminar.addEventListener('click', function(){
                tabla.deleteRow(nuevaCelda.rowIndex);
            });
            
            nueva.appendChild(btnEliminar);
            nueva.appendChild(btnEnviar);
        }
        else{
            var registro = document.createElement('input');
            registro.type = "text";
            registro.className = "border border-solid border-gray-300 text-center px-2 py-1 w-full h-full box-border";
            nueva.appendChild(registro);
        }
    }
    nuevaCelda.cells[0].querySelector('input').focus();
}


