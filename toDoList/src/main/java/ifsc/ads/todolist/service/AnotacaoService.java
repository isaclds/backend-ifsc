package ifsc.ads.todolist.service;

import ifsc.ads.todolist.model.Anotacao;
import ifsc.ads.todolist.repository.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotacaoService {
    @Autowired
    AnotacaoRepository anotacaoRepository;

    public Anotacao criar(Anotacao anotacao){
        return anotacaoRepository.save(anotacao);
    }

}
