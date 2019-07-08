package com.valerii.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "news")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "autor", schema = "news_portal")

public class Autor extends  BaseEntity<Long>{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "autor")
    private List<News> news = new ArrayList<>();


    public static class Ranner {


        public static void main(String[] args) {

            @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            @Cleanup Session session = sessionFactory.openSession();
            String nameAutor= "IVAN";
            Query<News> query = session.createQuery("select n from News n join n.autor a where a.name=:nameAutor", News.class).
                    setParameter("nameAutor",nameAutor);
            List<News> news = query.list();
            news.forEach(System.out::println);


            //Autor autor = session.get(Autor.class, 1L);
            //System.out.println(autor);

    /*       Comments comments=Comments.builder().
                    content(Content.of("sdjsjdhsjdj",LocalDateTime.now())).
                    build();
    //
    //        session.save(comments);*/
    //
    //      Autor autor = session.get(Autor.class,1L);
    //
    //        News news = News.builder().
    //                title("news7").
    //                content(Content.of("ncbnbvnbcv news6", LocalDateTime.now())).
    //                count_coments(6L).
    //                autor(autor).
    //                build();
    //        session.save(news);


    //        Users user= Users.builder()
    //                .login("123")
    //                .name("User1")
    //                .password("123")
    //                .build();
    //        session.save(user);
    //
    //        News news=session.get(News.class,2L);
    //
    //        Comments comment = Comments.builder()
    //                .content(Content.of("comment1 ", LocalDateTime.now()))
    //                .news(news)
    //                .user(user)
    //                .build();
    //        session.save(comment);
    //
    //
    //        session.getTransaction().commit();


        }







    }
}
