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

    @PostMapping("/evaluacion")
    public int InsertarEvaluacion(@RequestBody Evaluacion evaluacion) {
        return new EvaluacionDb().GuardarEvaluacion(evaluacion);
    }

    @PutMapping("/evaluacion")
    public int ActualizarEvaluacion(@RequestBody Evaluacion evaluacion) {
        return new EvaluacionDb().ActualizarEvaluacion(evaluacion);
    }

    @DeleteMapping("/evaluacion/{fecha}")
    public int Delete(@PathVariable("fecha") String fecha){
        return new EvaluacionDb().EliminarEvaluacion(fecha);
    }
}