package al.infnet.edu.br.DR1TP1.controller;
import al.infnet.edu.br.DR1TP1.model.OperacaoRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/adicao")
    public double adicao(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    @PostMapping("/adicao")
    public double adicaoPost(@RequestBody OperacaoRequest request) {
        return request.getNum1() + request.getNum2();
    }

    @GetMapping("/subtracao")
    public double subtracao(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    @PostMapping("/subtracao")
    public double subtracaoPost(@RequestBody OperacaoRequest request) {
        return request.getNum1() - request.getNum2();
    }

    @GetMapping("/multiplicacao")
    public double multiplicacao(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    @PostMapping("/multiplicacao")
    public double multiplicacaoPost(@RequestBody OperacaoRequest request) {
        return request.getNum1() * request.getNum2();
    }

    @GetMapping("/divisao")
    public double divisao(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return num1 / num2;
    }

    @PostMapping("/divisao")
    public double divisaoPost(@RequestBody OperacaoRequest request) {
        if (request.getNum2() == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return request.getNum1() / request.getNum2();
    }

    @GetMapping("/exponenciacao")
    public double exponenciacao(@RequestParam double base, @RequestParam double expoente) {
        return Math.pow(base, expoente);
    }

    @PostMapping("/exponenciacao")
    public double exponenciacaoPost(@RequestBody OperacaoRequest request) {
        return Math.pow(request.getBase(), request.getExpoente());
    }
}

