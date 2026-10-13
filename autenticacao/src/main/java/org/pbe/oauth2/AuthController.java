package org.pbe.oauth2;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @GetMapping("/api/login")
    @ResponseBody
    public String loginForm() {
        return """
            <form method="post" action="/api/login">
                <input type="text" name="username" placeholder="Usuário" />
                <input type="password" name="password" placeholder="Senha" />
                <button type="submit">Login</button>
            </form>
        """;
    }

    @GetMapping("/api/erro")
    @ResponseBody
    public String erro() {
        return "Falha na autenticação.";
    }

    @GetMapping("/api/receitas")
    @ResponseBody
    public String receitas(HttpSession session) {
        Integer contador = (Integer) session.getAttribute("contador");
        if (contador == null) contador = 0;
        contador++;
        session.setAttribute("contador", contador);

        return "Bem-vindo às receitas! Acesso #" + contador + "\n\n<a href=localhost:8080/api/logout>Aperte aqui para fazer logout</a>";
    }

    @GetMapping("/api/logout")
    public String logout() {
        // Spring Security já cuida do logout
        return "redirect:/api/login";
    }
}