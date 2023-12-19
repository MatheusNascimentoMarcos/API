package br.com.projeto.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @GetMapping("")
    public String message(){
        return "Hello World!";
    }

    @GetMapping("/boasvindas")
    public String boas_vindas(){
        return "Seja Bem-Vindo!";
    }

    @GetMapping("/boasvindas/{nome}")
    public String boas_vindas(@PathVariable String nome){
        return "Seja Bem-Vindo "+ nome +"!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa p){
        return acao.save(p);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/api/codigo/{codigo}")
    public Pessoa selectPeopleById(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    @GetMapping("/api/idade/{idade}")
    public List<Pessoa> selectPeopleByAge(@PathVariable int idade){
        return acao.findByIdade(idade);
    }

    @GetMapping("/api/nome/{nome}")
    public List<Pessoa> selectPeopleByName(@PathVariable String nome){
        return acao.findByNome(nome);
    }

    @PutMapping("api/codigo/{codigo}")
    public Pessoa editar(@RequestBody Pessoa p){
        return acao.save(p);
    }

    @DeleteMapping("api/codigo/{codigo}")
    public void remove(@PathVariable int codigo){
        Pessoa p = acao.findByCodigo(codigo);
        acao.delete(p);
    }

    @GetMapping("api/contador")
    public long count(){
        return acao.count();
    }

    @GetMapping("api/ordenarNomes")
    public List <Pessoa> orderName(){
        return acao.findByOrderByNome();
    }

    @GetMapping("api/ordenarIdades")
    public List <Pessoa> orderidade(){
        return acao.findByOrderByIdadeDesc();
    }
}
