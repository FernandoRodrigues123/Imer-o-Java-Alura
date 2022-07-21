import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo{

    public List<Conteudo> extratorDeConteudo(String json) {

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jsonParser.parse(json);

        List<Conteudo> listaDeConteudos = new ArrayList<>();
       
        for (Map<String, String> map : listaDeAtributos) {
            String titulo = map.get("title");
            String urlImagem = map.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);    
            listaDeConteudos.add(conteudo);
        }

        return listaDeConteudos;
    }

}
