package ifsc.ads.todolist.service;

import ifsc.ads.todolist.model.Lista;
import ifsc.ads.todolist.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {
    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> buscarTodas(){
        return listaRepository.findAll();
    }

    public Lista criar(Lista lista) {
        return listaRepository.save(lista);
    }
}
