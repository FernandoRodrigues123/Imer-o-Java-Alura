import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        String url = "https://api.nasa.gov/planetary/apod?api_key=FzaqqFBGZMUlSnhpk4LwnKS6EZUqmk0GbilMKS4c&start_date=2022-06-12&end_date=2022-06-14";

        ClienteHttp clienteHttp = new ClienteHttp();
        String json = clienteHttp.getDados(url);

        ExtratorDeConteudoNasa nasa = new ExtratorDeConteudoNasa();
        List<Conteudo> conteudos = nasa.extratorDeConteudo(json);

        GeradoraDeFigurinhas geradoraDeFigurinhas = new GeradoraDeFigurinhas();

        for (int i = 0; i < 10; i++) {

            Conteudo conteudo = conteudos.get(i);

            String urlImage = conteudo.getUrlImagem();
            String titulo = conteudo.getTitulo();

            String dir = "imagens/figurinhas/";
            String nomeDoArquivo = dir + titulo + ".png";

            InputStream iS = new URL(urlImage).openStream();

            geradoraDeFigurinhas.cria(iS, nomeDoArquivo);
            System.out.println(titulo);
        }

    }
}
