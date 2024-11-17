package consumption.power.global.controller;

import consumption.power.global.dto.UserDto;
import consumption.power.global.repository.RoleRepository;
import consumption.power.global.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.Transient;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("registrar")
    public String cadastrar(Model model){
        model.addAttribute("usuario", new UserDto());
        model.addAttribute("roles", roleRepository.findAll());
        return "usuario/cadastro";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid UserDto userDto,
                            BindingResult bindingResult,
                            Model model,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("roles", roleRepository.findAll());
            return "usuario/cadastro";
        }
        usuarioService.save(userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()), userDto.getRoles());
        return "redirect:/login";
    }

}