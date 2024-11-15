package consumption.power.global.controller;

import consumption.power.global.model.ConsumoEnergia;
import consumption.power.global.repository.ConsumoRepository;
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
@RequestMapping("consumo")
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(ConsumoEnergia consumoEnergia){
        return "consumo/cadastro";
    }

    @GetMapping("listar") //localhost:8080/cliente/listar
    public String listar(Model model){
        //Enviar a lista de clientes para a view
        model.addAttribute("status", consumoRepository.findAll());
        return "consumo/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o ciente pelo id e enviar o aluno para a view
        model.addAttribute("consumo", consumoRepository.findById(id));
        //Retornar a view
        return "consumo/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(@Valid ConsumoEnergia consumoEnergia, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if (bindingResult.hasErrors()){
            return "consumo/editar";
        }
        consumoRepository.save(consumoEnergia);
        redirectAttributes.addFlashAttribute("msg", "Consumo atualizado");
        return "redirect:/consumo/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid ConsumoEnergia consumoEnergia, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model){
        if (bindingResult.hasErrors()){
            return "consumo/editar";
        }
        consumoRepository.save(consumoEnergia);
        redirectAttributes.addFlashAttribute("msg", "Consumo registrado!");
        return "redirect:/consumo/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        consumoRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Consumo removido!");
        return "redirect:/consumo/listar";
    }
}