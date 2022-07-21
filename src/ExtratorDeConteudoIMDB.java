import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extratorDeConteudo(String json) {
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jsonParser.parse(json);

        List<Conteudo> listaDeConteudos = new ArrayList<>();

        for (Map<String, String> map : listaDeAtributos) {
            String titulo = map.get("title");
            String urlImagem = map.get("image").replaceAll("(@+) (.*).jpg$", "$1.jpg");
            ;
            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            listaDeConteudos.add(conteudo);
        }

        return listaDeConteudos;
    }

}
