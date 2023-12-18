let baseUrl = "http://localhost:8080"
let usuario = []
let estudiantesFiltro = []

function ObtenerUsuario(){
    fetch(baseUrl + "/usuario/all").then( res => {
        res.json().then(json => {
            usuario = json
            ImprimirEstudiantes(usuario)
        })
    })
}