package proyecto_final.backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import proyecto_final.backend.Models.Evaluacion;
import proyecto_final.backend.Services.EvaluacionDb;

@RestController
public class EvaluacionController {
    
    @GetMapping("/evaluacion/all")
    List<Evaluacion> TodasLasEvaluaciones(){
        return new EvaluacionDb().ObtenerTodasLasEvaluaciones();
    }

    @DeleteMapping("/evaluacion/{fechaEvaluacion}")
    public int Delete(@PathVariable("fechaEvaluacion") String f){
        return new EvaluacionDb().EliminarEvaluacion(f);
    }
}