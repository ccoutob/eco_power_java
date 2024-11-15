package consumption.power.global.controller;

import consumption.power.global.model.Dispositivos;
import consumption.power.global.repository.DispositivosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("dispositivos")
public class DispositivosController {

    @Autowired
    private DispositivosRepository dispositivosRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Dispositivos dispositivos){
        return "dispositivos/cadastro";
    }

    @GetMapping("listar") //localhost:8080/cliente/listar
    public String listar(Model model){
        //Enviar a lista de clientes para a view
        model.addAttribute("status", dispositivosRepository.findAll());
        return "dispositivos/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o ciente pelo id e enviar o aluno para a view
        model.addAttribute("dispositivos", dispositivosRepository.findById(id));
        //Retornar a view
        return "dispositivos/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Dispositivos dispositivos, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "dispositivos/editar";
        }
        dispositivosRepository.save(dispositivos);
        redirectAttributes.addFlashAttribute("msg", "Dispositivo atualizado");
        return "redirect:/dispositivos/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Dispositivos dispositivos, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            return "dispositivos/editar";
        }
        dispositivosRepository.save(dispositivos);
        redirectAttributes.addFlashAttribute("msg", "Dispositivo registrado!");
        return "redirect:/dispositivos/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        dispositivosRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Dispositivo removido!");
        return "redirect:/dispositivos/listar";
    }
}
