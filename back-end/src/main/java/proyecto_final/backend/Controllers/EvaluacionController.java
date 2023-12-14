package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto_final.backend.Models.Evaluacion;
import proyecto_final.backend.Services.EvaluacionDb;

@RestController
public class EvaluacionController {
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/evaluacion/all")
    List<Evaluacion> TodasLasEvaluaciones(){
        return new EvaluacionDb().ObtenerTodasLasEvaluaciones();
    }
}