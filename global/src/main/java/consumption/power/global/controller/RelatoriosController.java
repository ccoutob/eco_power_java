package consumption.power.global.controller;

import consumption.power.global.model.Relatorios;
import consumption.power.global.repository.RelatoriosRepository;
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
@RequestMapping("relatorios")
public class RelatoriosController {

    @Autowired
    private RelatoriosRepository relatoriosRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Relatorios relatorios){
        return "relatorios/cadastro";
    }

    @GetMapping("listar") //localhost:8080/cliente/listar
    public String listar(Model model){
        //Enviar a lista de clientes para a view
        model.addAttribute("status", relatoriosRepository.findAll());
        return "relatorios/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o ciente pelo id e enviar o aluno para a view
        model.addAttribute("relatorios", relatoriosRepository.findById(id));
        //Retornar a view
        return "relatorios/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Relatorios relatorios, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "relatorios/editar";
        }
        relatoriosRepository.save(relatorios);
        redirectAttributes.addFlashAttribute("msg", "Consumo atualizado");
        return "redirect:/relatorios/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Relatorios relatorios, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            return "relatorios/editar";
        }
        relatoriosRepository.save(relatorios);
        redirectAttributes.addFlashAttribute("msg", "Consumo registrado!");
        return "redirect:/relatorios/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        relatoriosRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Consumo removido!");
        return "redirect:/relatorios/listar";
    }
}