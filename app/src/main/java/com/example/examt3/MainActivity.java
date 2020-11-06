package com.example.examt3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.examt3.Adaptador.AdapterAnime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.Animerv);
        Context context=this.getApplicationContext();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Anime> anime = new ArrayList<>();
        anime.add(new Anime("https://cdn.lanetaneta.com/wp-content/uploads/2020/07/1595432397_Los-mejores-arcos-de-Kimetsu-no-Yaiba-clasificados-780x470.jpeg","kimetsu no yaiba","Kimetsu no Yaiba, también conocido por su nombre en inglés Demon Slayer y como Guardianes De La Noche en España, es un manga escrito e ilustrado por Koyoharu Gotōge que comenzó a serializarse el 15 de febrero de 2016 en la revista semanal Shūkan Shōnen Jump de la editorial Shūeisha"));
        anime.add(new Anime("https://static.wikia.nocookie.net/inuyasha/images/b/be/Inuyasha_protagonistas.jpg/revision/latest/scale-to-width-down/340?cb=20110910183918&path-prefix=es","Inuyasha","InuYasha, romanizado como INUYASHA y también conocido como Sengoku Otogizōshi InuYasha, es un manga escrito e ilustrado por Rumiko Takahashi, cuya adaptación a serie de anime fue dirigida por Yasunao Aoki y Masashi Ikeda. La serie se da lugar mayormente en el Japón del Período Sengoku."));
        anime.add(new Anime("https://i0.wp.com/culturageek.com.ar/wp-content/uploads/2019/12/Dragon-Ball-Super-anime-www.culturageek.com_.jpeg?fit=1280%2C714&ssl=1","Dragon Ball","Dragon Ball es un manga escrito e ilustrado por Akira Toriyama. Fue publicado originalmente en la revista Shōnen Jump, de la editorial japonesa Shūeisha, entre 1984 y 1995."));
        anime.add(new Anime("https://www.canalviax.com/wp-content/uploads/2019/05/maxresdefault-1.jpg","Shingeki no Kyojin","Shingeki no Kyojin, también conocida en países de habla hispana como Ataque a los titanes y Ataque de los titanes,  es una serie de manga escrita e ilustrada por Hajime Isayama."));
        anime.add(new Anime("https://www.tonica.la/__export/1584554959112/sites/debate/img/2020/03/18/bleach_portada.jpg_1902800913.jpg","Bleach","Bleach es una serie de manga y anime escrita e ilustrada por Tite Kubo. La serie narra las aventuras de Ichigo Kurosaki, un joven adolescente de quince años de edad que accidentalmente absorbe los poderes de una shinigami —personificación japonesa del Dios de la muerte— llamada Rukia Kuchiki."));
        anime.add(new Anime("https://vignette.wikia.nocookie.net/jojo-bizarre-adventure-stardust-crusaders/images/0/09/Jojo-stardust-2_zpsef2d4996.png/revision/latest?cb=20170405172442&path-prefix=es","JoJo's Bizarre Adventure","JoJo's Bizarre Adventure es una serie de manga escrita e ilustrada por Hirohiko Araki. Su publicación comenzó en la revista Weekly Shōnen Jump en 1987 y continúa en la revista Ultra jump desde 2005."));
        anime.add(new Anime("https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2019/07/fairy-tail-anime-personajes-episodio-final.jpg?fit=1080%2C608&quality=80&ssl=1","Fairy Tail","Fairy Tail es un manga de aventura y fantasía escrito e ilustrado por Hiro Mashima, publicado por primera vez el 23 de agosto de 2006 en la revista Shōnen Magazine, de la editorial japonesa Kōdansha. Existen 545 capítulos impresos, los cuales están recopilados en 63 volúmenes, hasta su finalización en julio de 2017. "));
        anime.add(new Anime("https://cadenaser00.epimg.net/ser/imagenes/2020/01/30/television/1580385677_025941_1580385837_noticia_normal.jpg","One Piece","One piece es un manga escrito e ilustrado por Eiichirō Oda y actualmente es el manga más comprado en el mundo. Comenzó a publicarse en la revista japonesa Weekly Shōnen Jump el 10 de octubre de 2011 se publicó los capítulos en volúmenes y actualmente se publicaron 96 volúmenes."));
        anime.add(new Anime("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTDxaASascqexO5IGWim2h7MGI4iZ9htq23-Q&usqp=CAU","One Punch-Man","One Punch-Man es un webcómic de acción y comedia japonés, creado por el artista One e iniciado en 2009. El webcómic rápidamente ganó popularidad, llegando a alcanzar las 7.9 millones de visitas."));
        anime.add(new Anime("https://i.blogs.es/ed157d/230317-deathnote/450_1000.jpg","Death Note","Death Note es una serie de manga escrita por Tsugumi Ōba e ilustrada por Takeshi Obata, y cuya adaptación a serie de anime fue dirigida por Tetsurō Araki. Cuenta, además, con varias películas y videojuegos. La historia se centra en Light Yagami, un estudiante de secundaria."));
        rv.setAdapter(new AdapterAnime(anime,context));
    }
    public class Anime {
        private String image;
        private String titulo;

        public Anime(String image, String titulo, String descripcion) {
            this.image = image;
            this.titulo = titulo;
            this.descripcion = descripcion;
        }

        private String descripcion;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {

            this.image = image;
        }

        public String getTitulo() {

            return titulo;
        }

        public void setTitulo(String titulo) {

            this.titulo = titulo;
        }

        public String getDescripcion() {

            return descripcion;
        }

        public void setDescripcion(String descripcion) {

            this.descripcion = descripcion;
        }
    }
}