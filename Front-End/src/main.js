/*document.addEventListener('DOMContentLoaded', function () {
    var toggleButton = document.getElementById('toggleButton');
    var miAside = document.getElementById('aside');
    var contenido = document.getElementById('contenido')

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
});*/

document.addEventListener('DOMContentLoaded', function () {
    var toggleButton = document.getElementById('toggleButton');
    var miAside = document.getElementById('aside');
    var contenido = document.getElementById('contenido');
    var pie = document.getElementById('foot');

    toggleButton.addEventListener('click', function () {
        if (miAside.style.display === 'none') {
            // Cuando el menú está desplegado
            miAside.style.display = 'block';
            toggleButton.classList.remove('closed');
            toggleButton.classList.add('opened');
            contenido.style.position = 'fixed';
            contenido.style.width = '100%'; // O ajusta según sea necesario
            contenido.style.overflowY = 'hidden';
        } else {
            // Cuando el menú está cerrado
            miAside.style.display = 'none';
            toggleButton.classList.remove('opened');
            toggleButton.classList.add('closed');
            contenido.style.position = 'static'; // O ajusta según sea necesario
            contenido.style.overflowY = 'auto';
        }
    });
});





